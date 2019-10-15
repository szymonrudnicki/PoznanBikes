package com.github.szyrudnicki.poznanbikes.ui.stations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.szyrudnicki.poznanbikes.model.ModelMapper
import com.github.szyrudnicki.poznanbikes.model.StationDomainModel
import com.github.szyrudnicki.poznanbikes.rest.MapAPIService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class StationsViewModel : ViewModel() {
    private val apiService by lazy { MapAPIService.create() }

    private val compositeDisposable = CompositeDisposable()

    val stationsLiveData = MutableLiveData<List<StationDomainModel>>()

    fun getStations() {
        compositeDisposable.add(
            apiService.getBicycleStations()
                .subscribeOn(Schedulers.io())
                .map(ModelMapper::mapResponseToDomain)
                .subscribe { stations ->
                    stationsLiveData.postValue(stations)
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
