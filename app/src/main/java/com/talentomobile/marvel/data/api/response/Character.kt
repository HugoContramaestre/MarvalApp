package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import java.util.*
import com.talentomobile.domain.common.Character as CharacterDomain


data class Character(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("urls") var urls: List<Url> = emptyList(),
    @SerializedName("thumbnail") var thumbnail: Image? = Image(),
    @SerializedName("comics") var comics: ComicsList? = null,
    @SerializedName("stories") var stories: StoryList? = StoryList(),
    @SerializedName("events") var events: EventList? = null,
    @SerializedName("series") var series: SeriesList? = SeriesList(),

    ) {
    fun toDomain() = CharacterDomain(
        id = id ?: -1,
        name = name,
        description = description,
        modified = modified,
        resourceUri = resourceUri,
        urls = urls.map { it.toDomain() },
        thumbnail = thumbnail?.toDomain(),
        comics = comics?.toDomain(),
        stories = stories?.toDomain(),
        events = events?.toDomain(),
        series = series?.toDomain(),
    )
}