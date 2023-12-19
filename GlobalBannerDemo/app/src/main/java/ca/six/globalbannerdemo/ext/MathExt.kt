package ca.six.globalbannerdemo.ext

import android.content.res.Resources

fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Int.pxToDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

fun Float.dpToPx(): Float = this * Resources.getSystem().displayMetrics.density

fun Float.pxToDp(): Float = this / Resources.getSystem().displayMetrics.density

