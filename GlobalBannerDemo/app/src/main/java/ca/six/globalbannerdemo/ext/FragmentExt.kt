package ca.six.globalbannerdemo.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.replace(target: Fragment, container: Int, isRecord: Boolean = true) {
    val transaction = this.supportFragmentManager.beginTransaction()
    if (isRecord) {
        val currentFragment = getCurrentFragment(container)
        transaction.addToBackStack("${currentFragment?.javaClass?.name} -> ${target.javaClass.name}")
    }
    transaction.replace(container, target)
    transaction.commitAllowingStateLoss()
}

fun FragmentActivity.getCurrentFragment(container: Int): Fragment? {
    return this.supportFragmentManager.findFragmentById(container)
}