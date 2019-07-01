package com.yusuf.hurriyet.dto

data class CategoryDTO(val name:String="")

private fun getCategory(): MutableList<CategoryDTO> {
    val categories = mutableListOf(

        CategoryDTO("GÜNDEM"),
        CategoryDTO("DÜNYA"),
        CategoryDTO("AVRUPA"),
        CategoryDTO("TÜRKİYE"),
        CategoryDTO("ALMANYA"),
        CategoryDTO("EKONOMİ"),
        CategoryDTO("YAŞAM"),
        CategoryDTO("BASIN"),
        CategoryDTO("SPOR"),
        CategoryDTO("MULTİMEDYA")

    )

    return categories
}