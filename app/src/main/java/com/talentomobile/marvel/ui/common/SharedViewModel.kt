package com.talentomobile.marvel.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel() : BaseViewModel() {

    private val _homeNavigate = MutableLiveData<Event<Int>>()
    val homeNavigate: LiveData<Event<Int>> get() = _homeNavigate

    fun handleFeedbackUser(feedbackUser: FeedbackUser) = sendFeedbackUser(feedbackUser)

    fun handleLoading(loading: Boolean) = toggleLoading(loading)
}