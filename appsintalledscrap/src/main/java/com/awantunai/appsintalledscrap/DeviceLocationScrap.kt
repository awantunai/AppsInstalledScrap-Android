package com.awantunai.appsintalledscrap

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import com.awantunai.appsintalledscrap.model.DeviceLocationRequest

private var deviceLocationRequest : DeviceLocationRequest? = null
private var lat  = ""
private var long = ""
private var radius  = ""

fun getDeviceLocation(locationManager: LocationManager?, tm : TelephonyManager) : DeviceLocationRequest{
    try {
        locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, loacationListener)
    } catch(ex: SecurityException) {
        Log.d("myTag", "Security Exception, no location available")
    }
    return DeviceLocationRequest(lat, long, radius)
}

private val loacationListener : LocationListener = object : LocationListener{
    override fun onLocationChanged(location: Location) {
        lat = location.latitude.toString()
        long = location.longitude.toString()
        radius = location.accuracy.toString()
        //deviceLocationRequest = DeviceLocationRequest(long, lat, radius)
    }
    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
    override fun onProviderEnabled(provider: String) {}
    override fun onProviderDisabled(provider: String) {}
}

