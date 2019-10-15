package com.github.szyrudnicki.poznanbikes.ui.stations.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.szyrudnicki.poznanbikes.R
import com.github.szyrudnicki.poznanbikes.model.StationDomainModel
import kotlin.properties.Delegates

class StationsAdapter(private val onClickListener: (StationDomainModel) -> Unit) : RecyclerView.Adapter<StationViewHolder>() {

    var stations: List<StationDomainModel> by Delegates.observable(listOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        StationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_station, parent, false)
        )

    override fun getItemCount() = stations.size

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        holder.bind(stations[position], onClickListener)
    }
}