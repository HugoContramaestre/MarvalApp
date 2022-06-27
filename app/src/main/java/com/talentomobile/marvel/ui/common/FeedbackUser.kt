package com.talentomobile.marvel.ui.common

import com.talentomobile.data.exception.Failure
import com.talentomobile.marvel.R

data class FeedbackUser(
    val messageResId: Int,
    val error: Boolean = false,
) {
    companion object {
        fun from(failure: Failure?): FeedbackUser {
            val msg = when(failure) {
                is Failure.NetworkConnection -> R.string.error_connection
                else -> R.string.error_unknown
            }
            return FeedbackUser(msg, true)
        }
    }
}