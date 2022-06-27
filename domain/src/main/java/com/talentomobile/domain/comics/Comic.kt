package com.talentomobile.domain.comics

import com.talentomobile.domain.characters.ComicSummary
import com.talentomobile.domain.common.*
import java.util.*

data class Comic(
    var id: Int,
    var digitalId: Int? = null,
    var title: String? = null,
    var issueNumber: Double? = null,
    var variantDescription: String? = null,
    var description: String? = null,
    var modified: String? = null,
    var isbn: String? = null,
    var upc: String? = null,
    var diamondCode: String? = null,
    var ean: String? = null,
    var issn: String? = null,
    var format: String? = null,
    var pageCount: Int? = null,
    var textObjects: List<TextObjects> = emptyList(),
    var resourceUri: String? = null,
    var urls: List<Url> = emptyList(),
    var series: SeriesSummary? = SeriesSummary(),
    var variants: List<ComicSummary> = emptyList(),
    var collections: List<ComicSummary> = emptyList(),
    var collectedIssues: List<ComicSummary> = emptyList(),
    var dates: List<ComicDate> = emptyList(),
    var prices: List<ComicPrice> = emptyList(),
    var thumbnail: Image? = Image(),
    var images: List<Image> = emptyList(),
    var creators: CreatorList? = CreatorList(),
    var characters: CharacterList? = CharacterList(),
    var stories: StoryList? = StoryList(),
    var events: EventList? = EventList()

): ContentContract() {
    override fun id(): Int = id
}