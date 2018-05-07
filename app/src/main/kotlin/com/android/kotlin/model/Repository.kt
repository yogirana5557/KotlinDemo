package com.android.kotlin.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class Repository(
        val id: Long,
        val name: String,
        val full_name: String,
        val owner: RepositoryOwner,
        val html_url: String,
        val description: String?,
        val url: String,
        val created_at: String,
        val updated_at: String,
        val pushed_at: String,
        val homepage: String?,
        val stargazers_count: Long,
        val watchers_count: Long,
        val watchers: String,
        val score: Double
) : PaperParcelable {

    companion object {
        @JvmField
        val CREATOR = PaperParcelRepository.CREATOR
    }
}