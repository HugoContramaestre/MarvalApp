package com.talentomobile.domain.common


data class Comics (

  var available     : String?          = null,
  var returned      : String?          = null,
  var collectionURI : String?          = null,
  var items         : List<StorySummary> = emptyList()

)