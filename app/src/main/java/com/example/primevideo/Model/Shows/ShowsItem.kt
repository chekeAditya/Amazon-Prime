package com.example.primevideo.Model.Shows


import com.google.gson.annotations.SerializedName

data class ShowsItem(
    @SerializedName("averageRuntime")
    val averageRuntime: Int,
    @SerializedName("dvdCountry")
    val dvdCountry: Any,
    @SerializedName("externals")
    val externals: Externals,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("language")
    val language: String,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("network")
    val network: Network,
    @SerializedName("officialSite")
    val officialSite: String,
    @SerializedName("premiered")
    val premiered: String,
    @SerializedName("rating")
    val rating: Rating,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("schedule")
    val schedule: Schedule,
    @SerializedName("status")
    val status: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated")
    val updated: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("webChannel")
    val webChannel: WebChannel,
    @SerializedName("weight")
    val weight: Int, override val size: Int
) : List<ShowsItem> {
    override fun contains(element: ShowsItem): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<ShowsItem>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): ShowsItem {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: ShowsItem): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<ShowsItem> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: ShowsItem): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<ShowsItem> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<ShowsItem> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<ShowsItem> {
        TODO("Not yet implemented")
    }
}