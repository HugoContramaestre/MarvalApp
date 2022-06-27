package com.talentomobile.marvel.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.talentomobile.domain.comics.Comic
import com.talentomobile.domain.common.Character
import com.talentomobile.marvel.ui.common.BaseViewModel
import com.talentomobile.marvel.ui.common.Event
import com.talentomobile.marvel.ui.common.FeedbackUser
import com.talentomobile.marvel.ui.common.postValueEvent
import com.talentomobile.marvel.ui.common.states.ListState
import com.talentomobile.usecases.comic.GetComicsUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ComicsViewModel(
    private val getComicsUseCase: GetComicsUseCase
) : BaseViewModel() {

    private val _listState = MutableLiveData<Event<ListState>>()
    val listState: LiveData<Event<ListState>> = _listState
    private val _list = MutableLiveData<Event<List<Comic>>>()
    val list: LiveData<Event<List<Comic>>>
        get() {
            if(_list.value == null) getList()
            return _list
        }

    fun getList() {
        viewModelScope.launch {
            _listState.postValueEvent(ListState.Loading)
            delay(500)
            getComicsUseCase.invoke()
                .fold({
                    _listState.postValueEvent(ListState.Error)
                    sendFeedbackUser(FeedbackUser.from(it))
                }, { comicsWrapper ->
                    if (comicsWrapper.data != null && comicsWrapper.data!!.results.isNotEmpty()) {
                        _listState.postValueEvent(ListState.Done)
                        _list.postValueEvent(comicsWrapper.data!!.results)
                    } else {
                        _listState.postValueEvent(ListState.Empty)
                    }
                })
        }
    }

}