package com.github.szyrudnicki.poznanbikes.rest

import com.github.szyrudnicki.poznanbikes.rest.model.MapAPIResponseModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MapAPIService {
    @GET("map_service.html?mtype=pub_transport&co=stacje_rowerowe")
    fun getBicycleStations(): Single<MapAPIResponseModel>

    companion object {
        fun create(): MapAPIService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.poznan.pl/mim/plan/")
                .build()

            return retrofit.create(MapAPIService::class.java)
        }
    }
}