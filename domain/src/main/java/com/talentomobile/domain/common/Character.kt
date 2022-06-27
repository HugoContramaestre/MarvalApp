package com.talentomobile.domain.common

import com.talentomobile.domain.characters.ComicsList


data class Character(
    var id: Int,
    var name: String? = null,
    var description: String? = null,
    var modified: String? = null,
    var resourceUri: String? = null,
    var urls: List<Url> = emptyList(),
    var thumbnail: Image? = Image(),
    var comics: ComicsList? = null,
    var stories: StoryList? = StoryList(),
    var events: EventList? = EventList(),
    var series: SeriesList? = SeriesList(),
): ContentContract() {
    override fun id(): Int = id
}