package com.talentomobile.marvel.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.talentomobile.marvel.ui.common.BaseViewModel
import com.talentomobile.usecases.characters.GetCharacterDetailUseCase
import com.talentomobile.domain.common.Character
import com.talentomobile.marvel.ui.common.FeedbackUser
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val characterId: Int,
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
): BaseViewModel() {

    private val _detail = MutableLiveData<Character>()
    val detail: LiveData<Character> = _detail
    private val _error = MutableLiveData<Unit>()
    val error: LiveData<Unit> = _error

    init {
        getDetail()
    }

    fun getDetail(){
        viewModelScope.launch {
            showLoading()
            delay(500)
            getCharacterDetailUseCase.invoke(characterId).fold({
                sendFeedbackUser(FeedbackUser.from(it))
                _error.postValue(Unit)
            },{ characterDataWrapper ->
                if(characterDataWrapper.data != null){
                    characterDataWrapper.data?.let {
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