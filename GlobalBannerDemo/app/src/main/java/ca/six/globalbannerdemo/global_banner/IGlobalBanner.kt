package ca.six.globalbannerdemo.global_banner

import androidx.lifecycle.Lifecycle
import ca.six.globalbannerdemo.core.MyApp
import ca.six.globalbannerdemo.R

interface IGlobalBanner {
    val isGlobalBannerEnabled: Boolean
    val globalBannerBackgroundColor: Int
        get() = MyApp.app().getColor(R.color.cash)
    val isImmersiveEffect : Boolean
        get() = false

    fun addGlobalBanner(lifecycle: Lifecycle) {
        if (isGlobalBannerEnabled) {
            val globalBanners = LocationBannerLifecycleObserver(globalBannerBackgroundColor, isImmersiveEffect)
            lifecycle.addObserver(globalBanners)
        } else {
            LocationBannerDelayHelper.stopTimeoutForBanner()
        }
    }
}