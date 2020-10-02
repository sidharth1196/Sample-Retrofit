package sid.app.retrorecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import sid.app.retrorecycler.repository.Repository
import sid.app.retrorecycler.viewmodel.PostViewModel
import sid.app.retrorecycler.viewmodel.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}