package ca.six.globalbannerdemo.global_banner


import android.app.Activity
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.os.Message
import ca.six.globalbannerdemo.core.Device
import ca.six.globalbannerdemo.core.MyApp
import java.lang.ref.WeakReference

object LocationBannerDelayHelper {
    const val FIRST_SHOW_GLOBAL_LOCATION_BANNER_WITH_ANIMATION = 1321
    private const val TIMEOUT = 7000L //TODO make it bigger to test the animation delay easier

    var activityRef: WeakReference<Activity> = WeakReference(null)
    var globalBannerBackgroundColor = Color.WHITE
    var marginTop = 0

    // animation only show it once per session. So set this to false once the animation has shown.
    var isFirstShowBanner = true

    val timer = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if(msg.what != FIRST_SHOW_GLOBAL_LOCATION_BANNER_WITH_ANIMATION) return
            val activity = activityRef.get()
            if (activity != null) {
                LocationBannerViewController.showGlobalBanner(activity, globalBannerBackgroundColor, marginTop)
                isFirstShowBanner = false
            }
        }
    }

    fun attach(activity: Activity?) {
        activityRef = WeakReference(activity)
    }

    fun startTimeoutForBanner() {
        val isNotRunningTaskAlready = !timer.hasMessages(FIRST_SHOW_GLOBAL_LOCATION_BANNER_WITH_ANIMATION)
        val isOnline = Device.isOnline(MyApp.app())
        if (isNotRunningTaskAlready && isFirstShowBanner && isOnline) {
            timer.sendEmptyMessageDelayed(FIRST_SHOW_GLOBAL_LOCATION_BANNER_WITH_ANIMATION, TIMEOUT)
        }
    }

    fun stopTimeoutForBanner() {
        // cancel timing, to reset
        timer.removeMessages(FIRST_SHOW_GLOBAL_LOCATION_BANNER_WITH_ANIMATION)
    }

}