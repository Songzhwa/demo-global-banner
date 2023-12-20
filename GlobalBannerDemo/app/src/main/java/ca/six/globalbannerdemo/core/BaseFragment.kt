package ca.six.globalbannerdemo.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import ca.six.globalbannerdemo.global_banner.IGlobalBanner

open class BaseFragment(xmlRes: Int) : Fragment(xmlRes), IGlobalBanner {
    override val isGlobalBannerEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addGlobalBanner(lifecycle)
    }

}