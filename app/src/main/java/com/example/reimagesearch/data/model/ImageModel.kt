package com.example.reimagesearch.data.model

data class ImageModel (
    val documents: ArrayList<Documents>,
    val meta: Meta
){
    //이미지 검색 응답에서 단일 문서 혹은 결과를 나타내는 클래스
    data class Documents(
        val collection: String,
        val thumbnail_url: String,
        val image_url: String,
        val width: Int,
        val height: Int,
        val display_sitename: String,
        val doc_url: String,
        val datetime: String
    )

    //이미지 검색 응답에 대한 메타 정보를 나타내는 클래스
    data class Meta(
        val is_end: Boolean,
        val pageable_count: Int,
        val total_count: Int
    )
}