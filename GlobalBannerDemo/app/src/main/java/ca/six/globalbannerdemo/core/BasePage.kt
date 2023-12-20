package ca.six.globalbannerdemo.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.globalbannerdemo.global_banner.IGlobalBanner

open class BasePage : AppCompatActivity, IGlobalBanner {
    // 支持两种构造函数
    constructor() : super()
    constructor(resId: Int) : super(resId)

    override val isGlobalBannerEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addGlobalBanner(lifecycle)
    }
}