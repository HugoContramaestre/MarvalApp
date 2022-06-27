package com.talentomobile.domain.characters

import com.talentomobile.domain.common.CharacterDataContainer


data class CharacterDataWrapper(

    var code: Int? = null,
    var status: String? = null,
    var copyright: String? = null,
    var attributionText: String? = null,
    var attributionHtml: String? = null,
    var data: CharacterDataContainer? = null,
    var etag: String? = null

)