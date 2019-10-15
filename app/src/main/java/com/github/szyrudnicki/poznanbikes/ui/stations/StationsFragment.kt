package com.github.szyrudnicki.poznanbikes.ui.stations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.szyrudnicki.poznanbikes.R
import com.github.szyrudnicki.poznanbikes.extensions.observe
import com.github.szyrudnicki.poznanbikes.model.StationDomainModel
import com.github.szyrudnicki.poznanbikes.ui.stations.recycler.StationsAdapter
import kotlinx.android.synthetic.main.fragment_stations.*

class StationsFragment : Fragment() {

    private val viewModel by viewModels<StationsViewModel>()

    private val stationsAdapter = StationsAdapter(::showStationDetails)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_stations, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(viewModel) {
            getStations()
            observe(stationsLiveData, ::loadStations)
        }
    }

    private fun loadStations(stations: List<StationDomainModel>) {
        stationsAdapter.stations = stations
    }
    private fun setupRecyclerView() {
        stations_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = stationsAdapter
        }
    }

    private fun showStationDetails(station: StationDomainModel) {
        findNavController().navigate(R.id.action_stationFragment_to_stationDetailsFragment)
    }
}
