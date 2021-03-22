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
import org.koin.android.viewmodel.ext.android.viewModel

class PlayerFragment : Fragment() {

    private val playerViewModel: PlayerViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_player, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        playerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}