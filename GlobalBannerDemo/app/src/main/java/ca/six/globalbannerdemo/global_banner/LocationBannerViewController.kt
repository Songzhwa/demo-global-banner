package ca.six.globalbannerdemo.global_banner

import android.app.Activity
import android.content.res.Resources
import android.graphics.Color
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import ca.six.globalbannerdemo.R
import ca.six.globalbannerdemo.ext.dpToPx
import ca.six.globalbannerdemo.ext.setMarginsTop

object LocationBannerViewController {
    private val showAnim: TranslateAnimation

    // this flag will ensure the animation will only show once per session
    var needToShowAnimation = true

    init {
        val bannerHeight = 183.dpToPx().toFloat()
        showAnim = TranslateAnimation(0f, 0f, -bannerHeight, 0f)
        showAnim.duration = 1000
    }

    fun showGlobalBanner(activity: Activity?, @ColorInt bannerBackgroundColor: Int = Color.WHITE, isImmersive: Boolean = false) {
        if (activity == null) return
        val contentLayout = getContentLinearLayout(activity) ?: return
        val isBannerAdded = isGlobalBannerAdded(activity)
//        val isDismissedBefore = preferences.hasDismissedGlobalLocationBanner
//        val isAtLeastSecondAppSession = preferences.appSessionCount >= 3 // for the sign up and login, the second app session count would be 3+
        val isPartialPermitted = true
        //val isYesOnPrimeModalSelected = preferences.selectionOnPrimeModal == AppConstants.SELECT_YES_PLEASE_ON_PRIME_MODAL
        if (!isBannerAdded && isPartialPermitted){
            val child = UpdateLocationPermissionBannerView(activity)
            child.setBannerBackgroundColor(bannerBackgroundColor)
            child.setImmersiveEffect(isImmersive)
            contentLayout.addView(child, 0)

            if (needToShowAnimation) {
                contentLayout.startAnimation(showAnim)
                needToShowAnimation = false
            }
        }
    }

    fun dismissGlobalBanner(activity: Activity?) {
        if (activity == null) return
        val contentLayout = getContentLinearLayout(activity) ?: return
        val isBannerAdded = isGlobalBannerAdded(activity)
        if (isBannerAdded) {
            contentLayout.removeViewAt(0)
        }
    }

    private fun isGlobalBannerAdded(activity: Activity?): Boolean {
        if (activity == null) return false
        val contentLayout = getContentLinearLayout(activity)
        if (contentLayout is LinearLayout) {
            val firstChild = contentLayout.getChildAt(0)
            if (firstChild is UpdateLocationPermissionBannerView) {
                return true
            }
        }
        return false
    }

    private fun getContentLinearLayout(activity: Activity): LinearLayout? {
        val decorView = activity.window.decorView as ViewGroup
        val contentLayout = decorView.getChildAt(0)
        if (contentLayout is LinearLayout) {
            return contentLayout
        }
        return null
    }
}