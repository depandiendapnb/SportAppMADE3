package id.ac.polbeng.depandi.sportappmade.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.polbeng.depandi.sportappmade.R

class PlayerFragment : Fragment() {

    private lateinit var playerViewModel: PlayerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        playerViewModel =
                ViewModelProvider(this).get(PlayerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_player, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        playerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}