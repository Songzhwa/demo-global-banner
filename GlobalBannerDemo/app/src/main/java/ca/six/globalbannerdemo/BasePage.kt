package ca.six.globalbannerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.globalbannerdemo.core.IGlobalBanner

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