package ca.six.globalbannerdemo.global_banner

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import ca.six.globalbannerdemo.ext.extractActivity

class LocationBannerLifecycleObserver(val bgColor : Int, val marginTop: Int) : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        val activity = owner.extractActivity()

        // the first time showing the banner depends on the LocationBannerDelayHelper
        LocationBannerDelayHelper.attach(activity)
        LocationBannerDelayHelper.globalBannerBackgroundColor = bgColor
        LocationBannerDelayHelper.marginTop = marginTop
        LocationBannerDelayHelper.startTimeoutForBanner()

        // once LocationBannerDelayHelper shows the banner once, the activity can normally show the banner as we expected
        if(!LocationBannerDelayHelper.isFirstShowBanner) {
            LocationBannerViewController.showGlobalBanner(activity, bgColor, marginTop)
        }
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        val activity = owner.extractActivity()
        LocationBannerViewController.dismissGlobalBanner(activity)
    }

}