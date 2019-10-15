package com.github.szyrudnicki.poznanbikes.ui.stations.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.szyrudnicki.poznanbikes.model.StationDomainModel
import kotlinx.android.synthetic.main.item_station.view.*

class StationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(station: StationDomainModel) = with(itemView) {
        item_station_view.setup(station)
    }
}