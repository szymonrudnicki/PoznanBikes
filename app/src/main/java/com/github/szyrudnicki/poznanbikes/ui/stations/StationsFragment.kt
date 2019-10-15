package com.github.szyrudnicki.poznanbikes.ui.stations

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.github.szyrudnicki.poznanbikes.R
import com.github.szyrudnicki.poznanbikes.extensions.observe
import com.github.szyrudnicki.poznanbikes.model.StationDomainModel

class StationsFragment : Fragment() {

    private val viewModel by viewModels<StationsViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.main_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(viewModel) {
            getStations()
            observe(stationsLiveData, ::loadStations)
        }
    }

    private fun loadStations(stations: List<StationDomainModel>) {
        Toast.makeText(requireContext(), stations.toString(), Toast.LENGTH_LONG).show()
    }
}
