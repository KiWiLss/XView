package com.kiwilss.xview.ui.anim.transition.two.shared

import android.transition.ChangeBounds
import android.transition.Slide
import android.view.Gravity
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.anim.transition.bean.Sample
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: ShareElementFgActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/15
 * @desc   : {DESCRIPTION}
 */
class ShareElementFgActivity: BaseActivity(R.layout.activity_share_element_fg) {
    override fun initData() {

    }

    override fun initEvent() {
        iv_layout_toolbar_back?.setOnClickListener {
//            finishAfterTransition()
            onBackPressed()
        }
    }

    override fun initInterface() {

        val sample = intent.getSerializableExtra("sample") as Sample
        setupLayout(sample)

    }

    private fun setupLayout(sample: Sample) {
        // Transition for fragment1
        val slideTransition = Slide(Gravity.LEFT)
        slideTransition.duration = 500

        val fragment = ShareFg1.newInstance(sample)
        fragment.reenterTransition = slideTransition
        fragment.exitTransition = slideTransition
        fragment.sharedElementEnterTransition = ChangeBounds()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_share_elementfg_fg,fragment)
            .commit()

    }
}