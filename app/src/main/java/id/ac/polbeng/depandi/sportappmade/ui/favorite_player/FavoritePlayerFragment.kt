package id.ac.polbeng.depandi.sportappmade.ui.favorite_player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.polbeng.depandi.sportappmade.R

class FavoritePlayerFragment : Fragment() {

    private lateinit var favoritePlayerViewModel: FavoritePlayerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        favoritePlayerViewModel =
                ViewModelProvider(this).get(FavoritePlayerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favorite_player, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        favoritePlayerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}