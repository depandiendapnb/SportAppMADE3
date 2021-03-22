package id.ac.polbeng.depandi.sportappmade.ui.sport

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.polbeng.depandi.sportappmade.R
import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.databinding.FragmentSportBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SportFragment : Fragment() {

    private val sportViewModel: SportViewModel by viewModel()

    private var _binding: FragmentSportBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            sportViewModel.sportList.observe(viewLifecycleOwner, { sports ->
                if (sports != null) {
                    when (sports) {
                        is Resource.Loading -> {

                        }
                        is Resource.Success -> {
                            Log.d("SportFragment", sports.data?.size.toString())
                        }
                        is Resource.Error -> {

                        }
                    }
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}