package id.ac.polbeng.depandi.sportappmade.ui.favorite_player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import id.ac.polbeng.depandi.sportappmade.R
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritePlayerFragment : Fragment() {

    private val favoritePlayerViewModel: FavoritePlayerViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favorite_player, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        favoritePlayerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}