package ca.six.globalbannerdemo.core

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import ca.six.globalbannerdemo.R

class UpdateLocationPermissionBannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_update_location_permission, this, true)

        val alwaysAndPreciseText = context.getString(R.string.location_banner_permission)
            .font(R.font.poppins_semibolditalic)
            .color(Color.parseColor("#55DCB8"))
        val rawDescription = context.getString(R.string.location_banner_description).formatSpanned(alwaysAndPreciseText)
        tvUpdateLocationInfo.text = rawDescription

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