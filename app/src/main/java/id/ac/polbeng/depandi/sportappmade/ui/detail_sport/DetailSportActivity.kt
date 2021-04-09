package id.ac.polbeng.depandi.sportappmade.ui.detail_sport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ac.polbeng.depandi.sportappmade.R
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import id.ac.polbeng.depandi.sportappmade.databinding.ActivityDetailSportBinding
import id.ac.polbeng.depandi.sportappmade.databinding.ContentDetailSportBinding

class DetailSportActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val DATA_N_A = "Data Unavailable"
    }

    private lateinit var binding: ActivityDetailSportBinding
    private lateinit var contentDetail: ContentDetailSportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSportBinding.inflate(layoutInflater)
        contentDetail = binding.contentDetailSport
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val sport = intent.getParcelableExtra<Sport>(EXTRA_DATA)
        showDetailSport(sport)
    }

    private fun showDetailSport(sport: Sport?){
        sport?.let {
            supportActionBar?.title = sport.strSport
            Glide.with(this@DetailSportActivity)
                .load(sport.strSportThumb)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(binding.imgPoster)
            val format = checkNullData(sport.strFormat)
            contentDetail.tvFormat.text = getString(R.string.sport_format, format)
            contentDetail.tvDescription.text = checkNullData(sport.strSportDescription)
        }
    }

    private fun checkNullData(data: String?) : String{
        return if(data == null || data == ""){
            DATA_N_A
        }else{
            data
        }
    }
}