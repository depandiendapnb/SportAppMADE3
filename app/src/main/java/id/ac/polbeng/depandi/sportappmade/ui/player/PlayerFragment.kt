package id.ac.polbeng.depandi.sportappmade.ui.player

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.ac.polbeng.depandi.sportappmade.R
import id.ac.polbeng.depandi.sportappmade.core.data.Resource
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.core.ui.PlayerAdapter
import id.ac.polbeng.depandi.sportappmade.core.ui.PlayerFragmentCallback
import id.ac.polbeng.depandi.sportappmade.databinding.FragmentPlayerBinding
import org.koin.android.viewmodel.ext.android.viewModel

class PlayerFragment : Fragment(), PlayerFragmentCallback {

    private val playerViewModel: PlayerViewModel by viewModel()

    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val playerAdapter = PlayerAdapter(this)
            with(binding.rvPlayer) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = playerAdapter
            }

            showInfo(true, getString(R.string.player_search))

            binding.btnSearch.setOnClickListener {
                val query = binding.etSearch.text.trim().toString()
                if (query == ""){
                    Snackbar.make(binding.root, getString(R.string.player_search), Snackbar.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val searchQuery = query.replace(" ", "_")
                playerViewModel.getPlayerByName(searchQuery)
                playerViewModel.listPlayer.observe(viewLifecycleOwner, { result ->
                    Log.d("PlayerFragment", result.data.toString())
                    if (result != null) {
                        when (result) {
                            is Resource.Loading -> showLoading(true)
                            is Resource.Success -> {
                                showLoading(false)
                                showInfo(false, "")
                                playerAdapter.setPlayerList(result.data)
                            }
                            is Resource.Error -> {
                                showLoading(false)
                                showInfo(true, getString(R.string.data_empty))
                            }
                        }
                    }
                })
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.viewInfo.root.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun showInfo(state: Boolean, info: String){
        if (state) {
            binding.rvPlayer.visibility = View.GONE
            binding.viewInfo.root.visibility = View.VISIBLE
            binding.viewInfo.tvInfo.text = info
        } else {
            binding.viewInfo.root.visibility = View.GONE
            binding.rvPlayer.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(player: Player) {
        /*val intent = Intent(activity, DetailPlayerActivity::class.java)
        intent.putExtra(DetailPlayerActivity.EXTRA_DATA, player)
        startActivity(intent)*/
    }
}