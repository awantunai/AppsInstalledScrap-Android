package com.awantunai.appsintalledscrap

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log


class MyLocationListener(context: Context, private val listener: MyListener) : LocationListener {

    private var mContext: Context? = null
    private var locationManager: LocationManager? = null

    fun startTracking() {
        locationManager = mContext?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        try {
            locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, this)
        } catch(ex: SecurityException) {
            Log.d("myTag", "Security Exception, no location available")
        }
    }

    override fun onLocationChanged(p0: Location?) {
        finishTracking(p0)
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {

    }

    override fun onProviderEnabled(p0: String?) {

    }

    override fun onProviderDisabled(p0: String?) {

    }

    interface MyListener {
        fun onLocationReceiver(location: Location?)
    }

    init {
        mContext = context
    }



    private fun finishTracking(location: Location?) {
        if (location != null) {
            locationManager?.removeUpdates(this)
            listener.onLocationReceiver(location)
        }
    }
}