package sid.app.retrorecycler.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sid.app.retrorecycler.data.Post

interface API {
    @GET("posts")
    suspend fun getPostByUser(
        @Query("userId") uId : Int
    ) : Response<List<Post>>

    @GET("posts/{postNumber}")
    suspend fun getPost(
        @Path("postNumber") number : Int
    ) : Response<Post>
}