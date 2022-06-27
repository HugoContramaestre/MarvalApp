package com.talentomobile.domain.common


data class CharacterDataContainer (

  var offset  : String?            = null,
  var limit   : String?            = null,
  var total   : String?            = null,
  var count   : String?            = null,
  var results : List<Character> = emptyList()

)