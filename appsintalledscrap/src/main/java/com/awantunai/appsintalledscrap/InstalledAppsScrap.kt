package com.awantunai.appsintalledscrap

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import com.awantunai.appsintalledscrap.model.ApplicationsItem
import com.awantunai.appsintalledscrap.model.DeviceInfoRequest

fun getInstalledApllication(packageManager : PackageManager?, context : Context) : MutableList<ApplicationsItem>{

    var appList : MutableList<ApplicationsItem> = mutableListOf()
    val apps = packageManager?.getInstalledApplications(0)
    val installedApps = ArrayList<ApplicationInfo>()
    apps?.forEachIndexed{ index, element ->
        when {
            element.flags and ApplicationInfo.FLAG_UPDATED_SYSTEM_APP != 0 -> installedApps.add(element)
            element.flags and ApplicationInfo.FLAG_SYSTEM != 0 -> {
            }else -> installedApps.add(element)
        }
        val label = packageManager.getApplicationLabel(element)
        val installed = context
            .packageManager
            .getPackageInfo(element.packageName, 0)
            .firstInstallTime

        appList.add(index, ApplicationsItem(label.toString(), installed.toString()))
    }
    return appList.toMutableList()
}

@SuppressLint("MissingPermission")
fun getDeviceInfo(id : String, telephonyManager: TelephonyManager) : DeviceInfoRequest {
    var imei = ""
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        imei = telephonyManager.imei
    } else {
        imei = telephonyManager.deviceId
    }
    val brand = Build.BRAND
    val manufacturer = Build.MANUFACTURER
    val model = Build.MODEL
    val os = Build.VERSION.RELEASE

    return DeviceInfoRequest(id, 0, imei, manufacturer, model, brand, os)
}

@SuppressLint("MissingPermission")
fun getDeviceId(telephonyManager: TelephonyManager) : String{
    var imei = ""
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        imei = telephonyManager.imei
    } else {
        imei = telephonyManager.deviceId
    }
    return imei
}

