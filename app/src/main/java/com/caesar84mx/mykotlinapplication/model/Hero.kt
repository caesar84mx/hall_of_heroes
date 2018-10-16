package com.caesar84mx.mykotlinapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Hero(
        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("realname")
        @Expose
        val realName: String,

        @SerializedName("team")
        @Expose
        val team: String,

        @SerializedName("firstappearance")
        @Expose
        val firstAppearance: Int,

        @SerializedName("createdby")
        @Expose
        val createdBy: String,

        @SerializedName("publisher")
        @Expose
        val publisher: String,

        @SerializedName("imageurl")
        @Expose
        val imageUrl: String,

        @SerializedName("bio")
        @Expose
        val bio: String

): Serializable
