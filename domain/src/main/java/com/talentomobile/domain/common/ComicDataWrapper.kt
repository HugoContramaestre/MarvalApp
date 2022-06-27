package com.talentomobile.domain.common

import com.talentomobile.domain.comics.ComicDataContainer


data class ComicDataWrapper(

    var code: Int? = null,
    var status: String? = null,
    var copyright: String? = null,
    var attributionText: String? = null,
    var attributionHtml: String? = null,
    var data: ComicDataContainer? = null,
    var etag: String? = null

)