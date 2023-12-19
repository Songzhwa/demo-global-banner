package ca.six.globalbannerdemo.core

import androidx.lifecycle.Lifecycle
import ca.six.globalbannerdemo.MyApp
import ca.six.globalbannerdemo.R

interface IGlobalBanner {
    val isGlobalBannerEnabled: Boolean
    val globalBannerBackgroundColor: Int
        get() = MyApp.app().getColor(R.color.cash)

    fun addGlobalBanner(lifecycle: Lifecycle) {
        if (isGlobalBannerEnabled) {
            val globalBanners = LocationBannerLifecycleObserver(globalBannerBackgroundColor)
            lifecycle.addObserver(globalBanners)
        } else {
            LocationBannerDelayHelper.stopTimeoutForBanner()
        }
    }
}