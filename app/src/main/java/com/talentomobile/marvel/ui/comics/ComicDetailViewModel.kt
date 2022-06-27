package com.talentomobile.marvel.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.talentomobile.domain.comics.Comic
import com.talentomobile.marvel.ui.common.BaseViewModel
import com.talentomobile.marvel.ui.common.FeedbackUser
import com.talentomobile.usecases.comic.GetComicDetailUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ComicDetailViewModel(
    private val comicId: Int,
    private val getComicDetailUseCase: GetComicDetailUseCase
): BaseViewModel() {
    private val _detail = MutableLiveData<Comic>()
    val detail: LiveData<Comic> = _detail
    private val _error = MutableLiveData<Unit>()
    val error: LiveData<Unit> = _error

    init {
        getDetail()
    }

    fun getDetail(){
        viewModelScope.launch {
            showLoading()
            delay(500)
            getComicDetailUseCase.invoke(comicId).fold({
                sendFeedbackUser(FeedbackUser.from(it))
                _error.postValue(Unit)
            },{ comicDataWrapper ->
                if(comicDataWrapper.data != null){
                    comicDataWrapper.data?.let {
                        if(it.results.isNotEmpty()){
                            _detail.postValue(it.results[0])
                        }
                    }
                }
            })
            hideLoading()
        }
    }
}