package id.ac.polbeng.depandi.sportappmade.ui.sport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.polbeng.depandi.sportappmade.R

class SportFragment : Fragment() {

    private lateinit var sportViewModel: SportViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        sportViewModel =
                ViewModelProvider(this).get(SportViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sport, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        sportViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}