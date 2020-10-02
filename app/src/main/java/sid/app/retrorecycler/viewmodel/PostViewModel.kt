package sid.app.retrorecycler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import sid.app.retrorecycler.data.Post
import sid.app.retrorecycler.repository.Repository

class PostViewModel(val repository: Repository) : ViewModel(){
    var postListResponse : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var postResponse : MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost(id : Int){
        viewModelScope.launch {
            val data = repository.getPost(id)
            postResponse.value = data
        }
    }

    fun getPostByUser(id: Int){
        viewModelScope.launch {
            val data = repository.getPostByUser(id)
            postListResponse.value = data
        }
    }
}