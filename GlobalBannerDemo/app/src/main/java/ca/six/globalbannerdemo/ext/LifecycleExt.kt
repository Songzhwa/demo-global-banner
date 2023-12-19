package ca.six.globalbannerdemo.ext

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

fun LifecycleOwner.extractActivity(): Activity? {
    var activity: Activity? = null
    if (this is Activity) {
        activity = this
    } else if (this is Fragment) {
        activity = this.activity
    }
    return activity
}