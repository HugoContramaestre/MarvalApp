package com.talentomobile.marvel.ui.common.states

sealed class ListState {
    object Loading: ListState()
    object Empty: ListState()
    object Error: ListState()
    object Done: ListState()
}
