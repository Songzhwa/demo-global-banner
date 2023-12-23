package ca.six.globalbannerdemo.global_banner

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import ca.six.globalbannerdemo.ext.extractActivity

class LocationBannerLifecycleObserver(val bgColor : Int, val isImmersive: Boolean) : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        val activity = owner.extractActivity()

        // the first time showing the banner depends on the LocationBannerDelayHelper
        LocationBannerDelayHelper.attach(activity)
        LocationBannerDelayHelper.globalBannerBackgroundColor = bgColor
        LocationBannerDelayHelper.isImmersive = isImmersive
        LocationBannerDelayHelper.startTimeoutForBanner()

        // once LocationBannerDelayHelper shows the banner once, the activity can normally show the banner as we expected
        if(!LocationBannerDelayHelper.isFirstShowBanner) {
            LocationBannerViewController.showGlobalBanner(activity, bgColor, isImmersive)
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        val activity = owner.extractActivity()
        LocationBannerViewController.dismissGlobalBanner(activity)
    }

}