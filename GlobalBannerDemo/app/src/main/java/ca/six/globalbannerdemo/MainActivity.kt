package ca.six.globalbannerdemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import ca.six.globalbannerdemo.core.BaseFragment
import ca.six.globalbannerdemo.core.BasePage
import ca.six.globalbannerdemo.ext.nav
import ca.six.globalbannerdemo.ext.replace
import kotlinx.android.synthetic.main.actv_test_global_banner_one.*
import kotlinx.android.synthetic.main.actv_test_global_banner_two.*
import kotlinx.android.synthetic.main.frag_tv.*

// Global Banner
class TestGlobalBannerPage1 : BasePage(R.layout.actv_test_global_banner_one) {
    override val isGlobalBannerEnabled: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnTestGB.text = "next(true)"
        btnTestGB.setOnClickListener {
            println("szw -> page2 button clicked")
            nav<TestGlobalBannerPage2>()
        }

    }
}

class SomeRightPart : BaseFragment(R.layout.actv_btn) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(Color.GRAY)
    }
}


class TestGlobalBannerPage2 : BasePage(R.layout.actv_test_global_banner_two) {
    override val isGlobalBannerEnabled: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvBottomText.text = "next(true)"
        tvBottomText.setOnClickListener { nav<TestGlobalBannerPage3>() }
    }
}

class TestGlobalBannerPage3 : BasePage(R.layout.actv_test_global_banner_two) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvBottomText.setOnClickListener { nav<TestGlobalBannerPage4>() }
    }
}


// - - - - - - - - - - Activity with Fragments - - - - - - - - - -
class TestGlobalBannerPage4 : BasePage(R.layout.actv_test_global_banner_three) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.replace(TgbFragment1(), R.id.content, false)
    }
}

class TgbFragment1 : BaseFragment(R.layout.frag_tv) {
    override val isGlobalBannerEnabled: Boolean = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 1 (true)"
        btnFrag4.setOnClickListener {
            activity?.replace(TgbFragment2(), R.id.content)
        }
    }
}

class TgbFragment2 : BaseFragment(R.layout.frag_tv) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 2"
        btnFrag4.setOnClickListener {
            activity?.replace(TgbFragment3(), R.id.content)
        }
    }
}

class TgbFragment3 : BaseFragment(R.layout.frag_tv) {
    override val isGlobalBannerEnabled: Boolean = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 3 (true)"
        btnFrag4.setOnClickListener {
            activity?.replace(TgbFragment4(), R.id.content)
        }
    }
}

class TgbFragment4 : BaseFragment(R.layout.frag_tv) {
    override val isGlobalBannerEnabled: Boolean = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 4 (true)"
        btnFrag4.setOnClickListener {
            activity?.replace(TgbFragment5(), R.id.content)
        }
    }
}

class TgbFragment5 : BaseFragment(R.layout.frag_tv) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 5"
        btnFrag4.setOnClickListener {
            activity?.replace(TgbFragment6(), R.id.content)
        }
    }
}

class TgbFragment6 : BaseFragment(R.layout.frag_tv) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 6"
        btnFrag4.setOnClickListener {
            activity?.replace(TgbFragment7(), R.id.content)
        }
    }
}

class TgbFragment7 : BaseFragment(R.layout.frag_tv) {
    override val isGlobalBannerEnabled: Boolean = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 7 (true)"
        btnFrag4.setOnClickListener {
            activity?.replace(TgbFragment8(), R.id.content)
        }
    }
}

class TgbFragment8 : BaseFragment(R.layout.frag_tv) {
    override val isGlobalBannerEnabled: Boolean = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFrag.text = "Fragment 8 (true)"
        btnFrag4.setOnClickListener {
            activity?.nav<TestGlobalBannerPage2>()
        }
    }
}

