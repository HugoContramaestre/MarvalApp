package com.talentomobile.domain.characters

data class ComicsList(
    var available: Int? = null,
    var returned: Int? = null,
    var collectionUri: String? = null,
    var items: List<ComicSummary>? = null,
)

