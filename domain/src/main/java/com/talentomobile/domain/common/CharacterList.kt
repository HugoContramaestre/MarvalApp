package com.talentomobile.domain.common

import com.talentomobile.domain.comics.CharacterSummary


data class CharacterList (
  var available     : Int?          = null,
  var returned      : Int?          = null,
  var collectionURI : String?          = null,
  var items         : List<CharacterSummary> = emptyList()

)