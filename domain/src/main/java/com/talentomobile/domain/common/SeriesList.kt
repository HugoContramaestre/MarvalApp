package com.talentomobile.domain.common

data class SeriesList(
    var available     : Int?          = null,
    var returned      : Int?          = null,
    var collectionUri : String?          = null,
    var items         : List<SeriesSummary> = emptyList()
)
