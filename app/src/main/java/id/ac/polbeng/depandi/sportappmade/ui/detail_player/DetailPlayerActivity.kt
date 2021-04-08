package id.ac.polbeng.depandi.sportappmade.ui.detail_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ac.polbeng.depandi.sportappmade.R
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import id.ac.polbeng.depandi.sportappmade.databinding.ActivityDetailPlayerBinding
import id.ac.polbeng.depandi.sportappmade.databinding.ContentDetailPlayerBinding
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class DetailPlayerActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val DATA_N_A = "N/A"
    }

    private val detailPlayerViewModel: DetailPlayerViewModel by viewModel()

    private lateinit var binding: ActivityDetailPlayerBinding
    private lateinit var playerContentBinding: ContentDetailPlayerBinding
    private var isFavoritePlayer: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPlayerBinding.inflate(layoutInflater)
        playerContentBinding = binding.contentDetailPlayer
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val player = intent.getParcelableExtra<Player>(EXTRA_DATA)
        if (player != null) {
            showDetailPlayer(player)
        }
    }

    private fun showDetailPlayer(player: Player){
        detailPlayerViewModel.getFavoritePlayer(player)
        detailPlayerViewModel.isFavoritePlayer.observe(this, {result ->
            isFavoritePlayer = result
            setStatusFavorite(isFavoritePlayer)
        })
        player.let {
            supportActionBar?.title = player.strPlayer
            Glide.with(this@DetailPlayerActivity)
                .load(player.strThumb + "/preview")
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(binding.imgPoster)
            val sport = chekNullData(player.strSport)
            playerContentBinding.tvSport.text = getString(R.string.athlete, sport)
            playerContentBinding.tvPosition.text = chekNullData(player.strPosition)
            playerContentBinding.tvTeam.text = chekNullData(player.strTeam)
            playerContentBinding.tvNationality.text = chekNullData(player.strNationality)
            val birthLocation = chekNullData(player.strBirthLocation)
            val dateBorn = chekNullData(player.dateBorn)
            playerContentBinding.tvBirth.text = getString(R.string.birth_data, birthLocation, dateBorn)
            playerContentBinding.tvGender.text = chekNullData(player.strGender)
            playerContentBinding.tvHeight.text = chekNullData(player.strHeight)
            playerContentBinding.tvWeight.text = chekNullData(player.strHeight)
            playerContentBinding.tvDescription.text = chekNullData(player.strDescriptionEN)
            playerContentBinding.tvFacebook.text = chekNullData(player.strFacebook)
            playerContentBinding.tvTwitter.text = chekNullData(player.strTwitter)
            playerContentBinding.tvInstagram.text = chekNullData(player.strInstagram)
            binding.fab.setOnClickListener {
                if(isFavoritePlayer){
                    detailPlayerViewModel.deleteFavoritePlayer(player)
                }else {
                    lifecycleScope.launch {
                        detailPlayerViewModel.insertFavoritePlayer(player)
                    }
                }
                setStatusFavorite(!isFavoritePlayer)
            }
        }
    }

    private fun chekNullData(data: String?) : String{
        if(data == null || data == ""){
            return DATA_N_A
        }else{
            return data
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}