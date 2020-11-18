package com.kiwilss.xview.ui.watermark

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_watermark.*
import kotlinx.android.synthetic.main.rl_test.view.*
import java.util.zip.Inflater

/**
 *@FileName: WatermarkActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/18
 * @desc   : {DESCRIPTION}
 */
class WatermarkActivity: BaseActivity(R.layout.activity_watermark) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {


        iv_watermark_show.post {
            val drawMeasureView = WaterUtils.drawMeasureView(iv_watermark_show)
            drawMeasureView?.run {
                val inflate = layoutInflater.inflate(R.layout.bp_icon, null)
                val bitmap = WaterUtils.getBitmap(inflate, this@WatermarkActivity)
                val bp = ImageUtil.createWaterMaskLeftBottom(this@WatermarkActivity,drawMeasureView,bitmap,20,20)
                bp?.run {
                    iv_watermark_show2.setImageBitmap(this)
                }
            }
        }





    }
}