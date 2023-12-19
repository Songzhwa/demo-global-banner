package ca.six.globalbannerdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import ca.six.globalbannerdemo.core.IGlobalBanner

open class BaseFragment(xmlRes: Int) : Fragment(xmlRes), IGlobalBanner {
    override val isGlobalBannerEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addGlobalBanner(lifecycle)
    }

}