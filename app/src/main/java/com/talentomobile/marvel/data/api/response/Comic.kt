package com.talentomobile.marvel.data.api.response

import com.google.gson.annotations.SerializedName
import com.talentomobile.marvel.data.api.response.comics.ComicDate
import java.util.*
import com.talentomobile.domain.comics.Comic as ComicDomain

data class Comic(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("digitalId") var digitalId: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("issueNumber") var issueNumber: Double? = null,
    @SerializedName("variantDescription") var variantDescription: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("modified") var modified: String? = null,
    @SerializedName("isbn") var isbn: String? = null,
    @SerializedName("upc") var upc: String? = null,
    @SerializedName("diamondCode") var diamondCode: String? = null,
    @SerializedName("ean") var ean: String? = null,
    @SerializedName("issn") var issn: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("pageCount") var pageCount: Int? = null,
    @SerializedName("textObjects") var textObjects: List<TextObjects> = emptyList(),
    @SerializedName("resourceURI") var resourceUri: String? = null,
    @SerializedName("urls") var urls: List<Url> = emptyList(),
    @SerializedName("series") var series: SeriesSummary? = SeriesSummary(),
    @SerializedName("variants") var variants: List<ComicSummary> = emptyList(),
    @SerializedName("collections") var collections: List<ComicSummary> = emptyList(),
    @SerializedName("collectedIssues") var collectedIssues: List<ComicSummary> = emptyList(),
    @SerializedName("dates") var dates: List<ComicDate> = emptyList(),
    @SerializedName("prices") var prices: List<ComicPrice> = emptyList(),
    @SerializedName("thumbnail") var thumbnail: Image? = Image(),
    @SerializedName("images") var images: List<Image> = emptyList(),
    @SerializedName("creators") var creators: CreatorList? = CreatorList(),
    @SerializedName("characters") var characters: CharacterList? = CharacterList(),
    @SerializedName("stories") var stories: StoryList? = StoryList(),
    @SerializedName("events") var events: EventList? = EventList()
) {
    fun toDomain() = ComicDomain(
        id = id ?: -1,
        digitalId = digitalId,
        title = title,
        issueNumber = issueNumber,
        variantDescription = variantDescription,
        description = description,
        modified = modified,
        isbn = isbn,
        upc = upc,
        diamondCode = diamondCode,
        ean = ean,
        issn = issn,
        format = format,
        pageCount = pageCount,
        textObjects = textObjects.map { it.toDomain() },
        resourceUri = resourceUri,
        urls = urls.map { it.toDomain() },
        series = series?.toDomain(),
        variants = variants.map { it.toDomain() },
        collections = collections.map { it.toDomain() },
        collectedIssues = collectedIssues.map { it.toDomain() },
        dates = dates.map { it.toDomain() },
        prices = prices.map { it.toDomain() },
        thumbnail = thumbnail?.toDomain(),
        images = images.map { it.toDomain() },
        creators = creators?.toDomain(),
        characters = characters?.toDomain(),
        stories = stories?.toDomain(),
        events = events?.toDomain()
    )
}
