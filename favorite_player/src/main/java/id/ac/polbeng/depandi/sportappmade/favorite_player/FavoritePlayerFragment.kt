package id.ac.polbeng.depandi.sportappmade.favorite_player

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.polbeng.depandi.sportappmade.R
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.core.ui.PlayerAdapter
import id.ac.polbeng.depandi.sportappmade.core.ui.PlayerFragmentCallback
import id.ac.polbeng.depandi.sportappmade.di.favoritePlayerModule
import id.ac.polbeng.depandi.sportappmade.favorite_player.databinding.FragmentFavoritePlayerBinding
import id.ac.polbeng.depandi.sportappmade.ui.detail_player.DetailPlayerActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class FavoritePlayerFragment : Fragment(), PlayerFragmentCallback {

    private val favoriteViewModel: FavoritePlayerViewModel by viewModel()

    private var _binding: FragmentFavoritePlayerBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        loadKoinModules(favoritePlayerModule)
        _binding = FragmentFavoritePlayerBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val playerAdapter = PlayerAdapter(this)
        with(binding?.rvPlayer) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.setHasFixedSize(true)
            this?.adapter = playerAdapter
        }
        showLoading(true)
        favoriteViewModel.listPlayer.observe(viewLifecycleOwner, { result ->
            showLoading(false)
            if (result != null) {
                playerAdapter.setPlayerList(result)
                if(result.isEmpty()){
                    showInfo(true, getString(R.string.data_empty))
                }else{
                    showInfo(false, "")
                }
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding?.viewInfo?.root?.visibility = View.GONE
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
        }
    }

    private fun showInfo(state: Boolean, info: String){
        if (state) {
            binding?.rvPlayer?.visibility = View.GONE
            binding?.viewInfo?.root?.visibility = View.VISIBLE
            binding?.viewInfo?.tvInfo?.text = info
        } else {
            binding?.viewInfo?.root?.visibility = View.GONE
            binding?.rvPlayer?.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unloadKoinModules(favoritePlayerModule)
        _binding = null
    }

    override fun onItemClick(player: Player) {
        val intent = Intent(activity, DetailPlayerActivity::class.java)
        intent.putExtra(DetailPlayerActivity.EXTRA_DATA, player)
        startActivity(intent)
    }
}