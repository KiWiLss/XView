package com.kiwilss.xview.ui.util

import androidx.core.content.ContextCompat
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.test.ResUtils
import kotlinx.android.synthetic.main.activity_util.*

/**
 *@FileName: UtilsActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/10/17
 * @desc   : {DESCRIPTION}
 */
class UtilsActivity : BaseActivity(R.layout.activity_util) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {

        val color = ResUtils.getColor(R.color.colorAccent)
        tv_util_color.setTextColor(color)

        val string = ResUtils.getString(R.string.app_name)
        tv_util_color.text = string


        val drawable = getDrawable(R.drawable.ic_user_center_appbar_iv)
        iv_util_drawable.setImageDrawable(drawable)



    }
}