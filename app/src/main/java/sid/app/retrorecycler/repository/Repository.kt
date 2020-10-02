package sid.app.retrorecycler.repository

import retrofit2.Response
import retrofit2.Retrofit
import sid.app.retrorecycler.api.RetrofitInstance
import sid.app.retrorecycler.data.Post

class Repository {
    suspend fun getPost(id : Int) : Response<Post>{
        return RetrofitInstance.api.getPost(id)
    }
    suspend fun getPostByUser(id : Int) : Response<List<Post>>{
        return RetrofitInstance.api.getPostByUser(id)
    }
}