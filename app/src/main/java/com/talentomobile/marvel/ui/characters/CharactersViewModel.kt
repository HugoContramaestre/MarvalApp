package com.talentomobile.marvel.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.talentomobile.domain.common.Character
import com.talentomobile.marvel.ui.common.BaseViewModel
import com.talentomobile.usecases.characters.GetCharactersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import androidx.paging.cachedIn
import com.talentomobile.marvel.ui.common.Event
import com.talentomobile.marvel.ui.common.FeedbackUser
import com.talentomobile.marvel.ui.common.postValueEvent
import com.talentomobile.marvel.ui.common.states.ListState
import kotlinx.coroutines.delay

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : BaseViewModel() {

    private val _listState = MutableLiveData<Event<ListState>>()
    val listState: LiveData<Event<ListState>> = _listState
    private val _list = MutableLiveData<Event<List<Character>>>()
    val list: LiveData<Event<List<Character>>>
        get() {
            if(_list.value == null) getList()
            return _list
        }

    fun getList() {
        viewModelScope.launch {
            _listState.postValueEvent(ListState.Loading)
            delay(500)
            getCharactersUseCase.invoke()
                .fold({
                    _listState.postValueEvent(ListState.Error)
                    sendFeedbackUser(FeedbackUser.from(it))
                }, { charactersWrapper ->
                    if (charactersWrapper.data != null && charactersWrapper.data!!.results.isNotEmpty()) {
                        _listState.postValueEvent(ListState.Done)
                        _list.postValueEvent(charactersWrapper.data!!.results)
                    } else {
                        _listState.postValueEvent(ListState.Empty)
                    }
                })
        }
    }
}