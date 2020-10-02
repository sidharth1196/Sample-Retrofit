package sid.app.retrorecycler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import sid.app.retrorecycler.repository.Repository
import sid.app.retrorecycler.viewmodel.PostViewModel
import sid.app.retrorecycler.viewmodel.PostViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var viewModel : PostViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val repository = Repository()
        val postViewModelFactory = PostViewModelFactory(repository)
        viewModel = ViewModelProvider(this, postViewModelFactory).get(PostViewModel::class.java)

        view.btnPost.setOnClickListener {
            val ipText = view.etPost.text
            if (ipText != null){
                viewModel.getPost(ipText.toString().toInt())
                viewModel.postResponse.observe(viewLifecycleOwner, Observer {response ->
                    if (response.isSuccessful){
                        val data = response.body()!!
                        Log.i("Response", "Successfully retrieved post data")
                        Log.i("Response", response.body()!!.ID)
                        val action = HomeFragmentDirections
                            .actionHomeFragmentToPostFragment(data.userID.toInt(),
                            data.ID.toInt(),
                            data.PostTitle,
                            data.PostBody)
                        Navigation.findNavController(view).navigate(action)
                    }
                })
            }
        }
        view.btnUser.setOnClickListener {
            val ipText = view.etPost.text
            if (ipText != null){
                /*viewModel.getPostByUser(ipText.toString().toInt())
                viewModel.postListResponse.observe(viewLifecycleOwner, Observer {response ->
                    if (response.isSuccessful){
                        Log.i("Response", "Successfully retrieved list of Posts")
                        Log.i("Response", response.body()!!.size.toString())
                    }
                })*/
                val action = HomeFragmentDirections.actionHomeFragmentToListFragment(ipText.toString().toInt())
                Navigation.findNavController(view).navigate(action)
            }
        }
        return view
    }
}