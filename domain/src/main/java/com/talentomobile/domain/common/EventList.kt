package com.talentomobile.domain.common


data class EventList (
  var available     : Int?          = null,
  var returned      : Int?          = null,
  var collectionURI : String?          = null,
  var items         : List<EventSummary> = emptyList()
)