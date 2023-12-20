package ca.six.globalbannerdemo.global_banner

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import ca.six.globalbannerdemo.R
import kotlinx.android.synthetic.main.view_update_location_permission.view.*

class UpdateLocationPermissionBannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_update_location_permission, this, true)

        tvUpdateLocationInfo.text = "Change your location access to precise and always, so we can notify you about Instant Rewards when you shop."

        ivUpdateLocationDismiss.setOnClickListener {
            if(context is Activity) {
                LocationBannerViewController.dismissGlobalBanner(context)
            }
        }

        btnUpdateLocationPermission.setOnClickListener {
        }

        btnLearnMore.setOnClickListener {
        }
    }

    fun setBannerBackgroundColor(@ColorInt color: Int){
        flayGlobalLocationBanner.setBackgroundColor(color)
    }
}