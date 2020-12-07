package com.kiwilss.xview.ui.anim

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.anim.activity.AnimCutInActivity
import com.kiwilss.xview.ui.anim.fragment.AnimFragmentActivity
import com.kiwilss.xview.ui.anim.layout.LayoutActivity
import com.kiwilss.xview.ui.anim.property.PropertyActivity
import com.kiwilss.xview.ui.anim.viewanim.AnimViewActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_anim.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 *@FileName: AnimActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/27
 * @desc   : {DESCRIPTION}
 */
class AnimActivity: BaseActivity(R.layout.activity_anim) {

    override fun initData() {

    }

    override fun initEvent() {
        //对标题栏处理
        tv_layout_toolbar_right.visibility = View.VISIBLE
        tv_layout_toolbar_right.text = "测试"
        tv_layout_toolbar_right.setOnClickListener {
            LogUtils.e("test")
            Snackbar.make(tv_layout_toolbar_right,"测试通用标题栏",Snackbar.LENGTH_SHORT)
                .setAction("点击") {
                Toast.makeText(this, "点击了snackbar", Toast.LENGTH_SHORT).show()
            }.show()
        }
        btn_anim_fragment.setOnClickListener {
            startActivity(Intent(this,AnimFragmentActivity::class.java))
        }
        btn_anim_view.setOnClickListener {
            startActivity(Intent(this,AnimViewActivity::class.java))
        }
        btn_anim_activity.setOnClickListener {
            startActivity(Intent(this,AnimCutInActivity::class.java))
        }
        btn_anim_property.setOnClickListener {
            startActivity(Intent(this,PropertyActivity::class.java))
        }
        btn_anim_layout.setOnClickListener {
            startActivity(Intent(this,LayoutActivity::class.java))
        }

    }

    override fun initInterface() {

    }

    override fun initIsToolbar(): Boolean {
        return true
    }

    override fun onReload() {

    }

}