package com.kiwilss.xview.ui.view.scrollview.scroll

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.scrollview.widget.zoom.ScrollZoomUtil
import kotlinx.android.synthetic.main.activity_zoom_scroll.*

/**
 *@FileName: ZoomScrollActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/25
 * @desc   : {https://blog.csdn.net/zgcqflqinhao/article/details/83374247}
 */
class ZoomScrollActivity : BaseActivity(R.layout.activity_zoom_scroll) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {

        ScrollZoomUtil.scrollZoom(sv_zoom_scroll_outer, iv_zoom_scroll_icon)

        

    }

}