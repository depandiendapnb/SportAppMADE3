package id.ac.polbeng.depandi.sportappmade.ui.sport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.ac.polbeng.depandi.sportappmade.R
import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import id.ac.polbeng.depandi.sportappmade.databinding.FragmentSportBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SportFragment : Fragment(), SportFragmentCallback {

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
            val sportAdapter = SportAdapter(this)
            with(binding.rvSport) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = sportAdapter
            }
            sportViewModel.sportList.observe(viewLifecycleOwner, { sports ->
                if (sports != null) {
                    when (sports) {
                        is Resource.Loading -> {
                            showLoading(true)
                        }
                        is Resource.Success -> {
                            showLoading(false)
                            showInfo(false)
                            sportAdapter.setSportList(sports.data)
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            showInfo(true)
                        }
                    }
                }
            })
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun showInfo(state: Boolean){
        if (state) {
            binding.rvSport.visibility = View.GONE
            binding.viewInfo.root.visibility = View.VISIBLE
            binding.viewInfo.tvInfo.text = getString(R.string.data_empty)
        } else {
            binding.rvSport.visibility = View.VISIBLE
            binding.viewInfo.root.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(sport: Sport) {
        Snackbar.make(binding.root, "You have click ${sport.strSport}", Snackbar.LENGTH_SHORT).show()
    }
}