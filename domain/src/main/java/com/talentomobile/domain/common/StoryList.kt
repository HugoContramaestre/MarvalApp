package com.talentomobile.domain.common


data class StoryList (

  var available     : Int?          = null,
  var returned      : Int?          = null,
  var collectionURI : String?          = null,
  var items         : List<StorySummary> = emptyList()

)