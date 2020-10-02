package sid.app.retrorecycler.data

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("userId")
    var userID: String,

    @SerializedName("id")
    var ID: String,

    @SerializedName("title")
    var PostTitle: String,

    @SerializedName("body")
    var PostBody: String
)