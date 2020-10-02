package sid.app.retrorecycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.view.*
import sid.app.retrorecycler.repository.Repository
import sid.app.retrorecycler.viewmodel.PostViewModel
import sid.app.retrorecycler.viewmodel.PostViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    val args : ListFragmentArgs by navArgs()
    private lateinit var viewModel: PostViewModel
    private lateinit var layoutManager : LinearLayoutManager
    private  lateinit var adapter: PostAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val userId = args.UserID
        val repository = Repository()
        val viewModelFactory = PostViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
        viewModel.getPostByUser(userId)
        viewModel.postListResponse.observe(viewLifecycleOwner, Observer {response ->
            val data = response.body()!!
            layoutManager = LinearLayoutManager(view.context)
            view.postRecyclerView.layoutManager = layoutManager
            adapter = PostAdapter(view.context, data)
            view.postRecyclerView.adapter = adapter
        })
        return view
    }
}