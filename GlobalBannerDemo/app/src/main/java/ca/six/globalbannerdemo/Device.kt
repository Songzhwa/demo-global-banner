package ca.six.globalbannerdemo

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager

object Device {
    fun isOnline(context: Context?): Boolean {
        if (context == null) return false
        val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val ni = cm.getActiveNetworkInfo()
        return ni != null && ni.isConnected()
    }
}