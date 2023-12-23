package ca.six.globalbannerdemo.ext

import android.view.View
import android.view.ViewGroup

fun View.setMarginsTop(marginTopInDp: Int) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val lp = layoutParams as ViewGroup.MarginLayoutParams
        val top = marginTopInDp.dpToPx()
        lp.setMargins(lp.leftMargin, top, lp.rightMargin, lp.bottomMargin)
    }
}