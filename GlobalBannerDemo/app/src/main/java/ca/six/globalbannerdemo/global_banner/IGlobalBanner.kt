package ca.six.globalbannerdemo.global_banner

import androidx.lifecycle.Lifecycle
import ca.six.globalbannerdemo.core.MyApp
import ca.six.globalbannerdemo.R

interface IGlobalBanner {
    val isGlobalBannerEnabled: Boolean
    val globalBannerBackgroundColor: Int
        get() = MyApp.app().getColor(R.color.cash)
    val globalBannerMarginTop: Int
        get() = 0

    fun addGlobalBanner(lifecycle: Lifecycle) {
        if (isGlobalBannerEnabled) {
            val globalBanners = LocationBannerLifecycleObserver(globalBannerBackgroundColor, globalBannerMarginTop)
            lifecycle.addObserver(globalBanners)
        } else {
            LocationBannerDelayHelper.stopTimeoutForBanner()
        }
    }
}