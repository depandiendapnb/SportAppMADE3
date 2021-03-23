package id.ac.polbeng.depandi.sportappmade.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ac.polbeng.depandi.sportappmade.core.R
import id.ac.polbeng.depandi.sportappmade.core.databinding.ItemListPlayerBinding
import id.ac.polbeng.depandi.sportappmade.core.domain.model.Player
import java.util.ArrayList

class PlayerAdapter (private val callback: PlayerFragmentCallback): RecyclerView.Adapter<PlayerAdapter.ListViewHolder>() {

    private var playerList = ArrayList<Player>()

    fun setPlayerList(newPlayerList: List<Player>?) {
        if (newPlayerList == null) return
        playerList.clear()
        playerList.addAll(newPlayerList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
            ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_player, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = playerList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = playerList.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListPlayerBinding.bind(itemView)
        fun bind(player: Player) {
            with(binding) {
                itemView.setOnClickListener {
                    callback.onItemClick(player)
                }
                Glide.with(itemView.context)
                        .load(player.strThumb)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                        .override(102, 102)
                        .centerCrop()
                        .into(imgThumb)
                tvPlayerName.text = player.strPlayer
                tvSport.text = player.strSport
                tvTeam.text = player.strTeam
            }
        }
    }
}