package com.github.szyrudnicki.poznanbikes.ui.station_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.szyrudnicki.poznanbikes.R
import com.github.szyrudnicki.poznanbikes.model.StationDomainModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_station_details.*

private const val MAP_ZOOM = 15f

class StationDetailsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var station: StationDomainModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_station_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        station = StationDetailsFragmentArgs.fromBundle(arguments!!).station
        station_view.setup(station)
        with(google_map) {
            onCreate(savedInstanceState)
            onResume()
            getMapAsync(this@StationDetailsFragment)
        }
    }

    override fun onMapReady(map: GoogleMap) {
        val stationLocation = LatLng(station.latitude, station.longitude)
        map.addMarker(MarkerOptions().position(stationLocation))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(stationLocation, MAP_ZOOM))
    }
}