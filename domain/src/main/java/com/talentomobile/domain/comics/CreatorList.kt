package com.talentomobile.domain.comics



data class CreatorList (

  var available     : Int?          = null,
  var returned      : Int?          = null,
  var collectionURI : String?          = null,
  var items         : List<CreatorSummary> = emptyList()

)