package id.ac.polbeng.depandi.sportappmade.ui.sport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ac.polbeng.depandi.sportappmade.R
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Sport
import id.ac.polbeng.depandi.sportappmade.databinding.ItemListSportBinding
import java.util.ArrayList

class SportAdapter(private val callback: SportFragmentCallback): RecyclerView.Adapter<SportAdapter.ListViewHolder>() {

    private var sportList = ArrayList<Sport>()

    fun setSportList(newSportList: List<Sport>?) {
        if (newSportList == null) return
        sportList.clear()
        sportList.addAll(newSportList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_sport, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = sportList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = sportList.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListSportBinding.bind(itemView)
        fun bind(sport: Sport) {
            with(binding) {
                itemView.setOnClickListener {
                    callback.onItemClick(sport)
                }
                Glide.with(itemView.context)
                    .load(sport.strSportThumb)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgThumb)
                tvItemName.text = sport.strSport
                tvItemFormat.text = sport.strFormat
            }
        }
    }
}