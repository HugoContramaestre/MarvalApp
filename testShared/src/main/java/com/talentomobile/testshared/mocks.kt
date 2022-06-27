package com.talentomobile.testshared

import com.talentomobile.domain.characters.CharacterDataWrapper
import com.talentomobile.domain.characters.ComicSummary
import com.talentomobile.domain.characters.ComicsList
import com.talentomobile.domain.comics.Comic
import com.talentomobile.domain.comics.ComicDataContainer
import com.talentomobile.domain.common.*

val mockCharacter = Character(
    id = 1,
    name = "Lore master",
    description = "sdfadfasf asdfasdfasfas asdfasdfasdfas asdfgasdfasdfasdf asdfasdfas",
    modified = "2022-03-15T00:00:00-0500",
    resourceUri = "https://",
    urls = listOf(Url(type = "abc", url = "https://")),
    thumbnail = Image(path = "https://", extension = "png"),
    comics = ComicsList(
        available = 1,
        returned = 0,
        collectionUri = "",
        items = listOf(ComicSummary(resourceUri = "https://", name = "Callisto"))
    ),
    stories = StoryList(
        available = 1,
        returned = 0,
        collectionURI = "",
        items = listOf(StorySummary(resourceUri = "https://", name = "Callisto", type = ""))
    ),
    events = EventList(
        available = 1,
        returned = 0,
        collectionURI = "",
        items = listOf(EventSummary(resourceUri = "https://", name = "Callisto"))
    ),
    series = SeriesList(available = 1, returned = 0, collectionUri = "", items = emptyList()),
)

val mockComic = Comic(
    id = 1,
    digitalId = 1,
    title = "Titan",
    issueNumber = 1.0,
    variantDescription = null,
    description = "sdfadfasf asdfasdfasfas asdfasdfasdfas asdfgasdfasdfasdf asdfasdfas",
    modified = "2022-03-15T00:00:00-0500",
    isbn = "202200455-003-158578954",
    upc = null,
    diamondCode = null,
    ean = null,
    issn = null,
    format = null,
    pageCount = null,
    textObjects = emptyList(),
    resourceUri = null,
    urls = emptyList(),
    series = null,
    variants = emptyList(),
    collections = emptyList(),
    collectedIssues = emptyList(),
    dates = emptyList(),
    prices = emptyList(),
    thumbnail = null,
    images = emptyList(),
    creators = null,
    characters = null,
    stories = null,
    events = null
)

val mockCharacterDataWrapper = CharacterDataWrapper(
    code = 200,
    status = "OK",
    copyright = null,
    attributionText = "",
    attributionHtml = "",
    data = CharacterDataContainer(
        offset = null,
        limit = null,
        total = null,
        count = null,
        results = listOf(mockCharacter)
    ),
    etag = ""
)

val mockComicDataWrapper = ComicDataWrapper(
    code = 200,
    status = "OK",
    copyright = null,
    attributionText = null,
    attributionHtml = null,
    data = ComicDataContainer(
        offset = null,
        limit = null,
        total = null,
        count = null,
        results =  listOf(mockComic)
    ),
    etag = ""
)