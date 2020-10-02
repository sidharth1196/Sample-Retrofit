package sid.app.retrorecycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_post.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [PostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostFragment : Fragment() {
    val args : PostFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        view.txtUserID.text = args.UserID.toString()
        view.txtID.text = args.ID.toString()
        view.txtTitle.text = args.Title
        view.txtBody.text = args.Body
        view.btnDone.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_postFragment_to_homeFragment)
        }
        return view
    }
}