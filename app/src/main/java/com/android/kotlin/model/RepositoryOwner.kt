package com.android.kotlin.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class RepositoryOwner(
        val login: String,
        val id: Long,
        val avatar_url: String,
        val url: String,
        val type: String
) : PaperParcelable {
    companion object {
        @JvmField
        val CREATOR = PaperParcelRepositoryOwner.CREATOR
    }
}