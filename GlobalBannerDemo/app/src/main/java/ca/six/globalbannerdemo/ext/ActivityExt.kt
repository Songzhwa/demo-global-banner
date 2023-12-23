package ca.six.globalbannerdemo.ext

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View


inline fun <reified T : Activity> Activity.nav(data: Bundle? = null, flags : Int = -1) {
    val it = Intent(this, T::class.java)
    if(data != null) it.putExtras(data)
    if(flags != -1) it.addFlags(flags)
    startActivity(it)
}

fun Activity.displayContentUnderStatusBar() {
    window?.statusBarColor = Color.TRANSPARENT
    window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
}