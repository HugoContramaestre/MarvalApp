package com.talentomobile.domain.common


data class Image(
    var path: String? = null,
    var extension: String? = null
) {

    //Portrait type images
    fun getSmallPortrait(): String{
        return formImagePath(ImageVariants.PORTRAIT_SMALL)
    }
    fun getMediumPortrait(): String{
        return formImagePath(ImageVariants.PORTRAIT_MEDIUM)
    }
    fun getLargePortrait(): String{
        return formImagePath(ImageVariants.PORTRAIT_LARGE)
    }
    fun getFantasticPortrait(): String{
        return formImagePath(ImageVariants.PORTRAIT_SMALL)
    }
    fun getUncannyPortrait(): String{
        return formImagePath(ImageVariants.PORTRAIT_SMALL)
    }
    fun getIncrediblePortrait(): String{
        return formImagePath(ImageVariants.PORTRAIT_SMALL)
    }

    //Standard type images
    fun getSmallStandard(): String{
        return formImagePath(ImageVariants.STANDARD_SMALL)
    }
    fun getMediumStandard(): String{
        return formImagePath(ImageVariants.STANDARD_MEDIUM)
    }
    fun getLargeStandard(): String{
        return formImagePath(ImageVariants.STANDARD_LARGE)
    }
    fun getFantasticStandard(): String{
        return formImagePath(ImageVariants.STANDARD_SMALL)
    }
    fun getUncannyStandard(): String{
        return formImagePath(ImageVariants.STANDARD_SMALL)
    }
    fun getIncredibleStandard(): String{
        return formImagePath(ImageVariants.STANDARD_SMALL)
    }

    private fun formImagePath(variant: ImageVariants): String {
        return if (path != null && extension != null) {
            "${path!!.replace("http", "https")}/${variant.variant}.$extension"
        } else {
            ""
        }
    }

    private sealed class ImageVariants(val variant: String) {
        object PORTRAIT_SMALL : ImageVariants("portrait_small")
        object PORTRAIT_MEDIUM : ImageVariants("portrait_medium")
        object PORTRAIT_LARGE : ImageVariants("portrait_large")
        object PORTRAIT_FANTASTIC : ImageVariants("portrait_fantastic")
        object PORTRAIT_UNCANNY : ImageVariants("portrait_uncanny")
        object PORTRAIT_INCREDIBLE : ImageVariants("portrait_incredible")

        object STANDARD_SMALL : ImageVariants("standard_small")
        object STANDARD_MEDIUM : ImageVariants("standard_medium")
        object STANDARD_LARGE : ImageVariants("standard_large")
        object STANDARD_XLARGE : ImageVariants("standard_xlarge")
        object STANDARD_FANTASTIC : ImageVariants("standard_fantastic")
        object STANDARD_AMAZING : ImageVariants("standard_amazing")

        object LANDSCAPE_SMALL : ImageVariants("landscape_small")
        object LANDSCAPE_MEDIUM : ImageVariants("landscape_medium")
        object LANDSCAPE_LARGE : ImageVariants("landscape_large")
        object LANDSCAPE_XLARGE : ImageVariants("landscape_xlarge")
        object LANDSCAPE_AMAZING : ImageVariants("landscape_amazing")
        object LANDSCAPE_INCREDIBLE : ImageVariants("landscape_incredible")

    }
}