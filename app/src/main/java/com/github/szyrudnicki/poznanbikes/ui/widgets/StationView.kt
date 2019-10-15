package com.github.szyrudnicki.poznanbikes.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.szyrudnicki.poznanbikes.R
import com.github.szyrudnicki.poznanbikes.model.StationDomainModel
import kotlinx.android.synthetic.main.layout_station.view.*

class StationView(context: Context, attributeSet: AttributeSet) : FrameLayout(context, attributeSet) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_station, this, true)
    }

    fun setup(station: StationDomainModel) {
        station_label_text_view.text = station.label
        station_available_bikes_text_view.text = station.availableBikes.toString()
        station_available_places_text_view.text = station.freeRacks.toString()
    }
}