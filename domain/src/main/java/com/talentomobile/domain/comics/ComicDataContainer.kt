package com.talentomobile.domain.comics

data class ComicDataContainer(
    var offset: Int? = null,
    var limit: Int? = null,
    var total: Int? = null,
    var count: Int? = null,
    var results: List<Comic> = emptyList(),
)
