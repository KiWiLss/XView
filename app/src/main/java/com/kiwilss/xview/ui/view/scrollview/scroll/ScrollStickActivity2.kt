package com.kiwilss.xview.ui.view.scrollview.scroll

import android.view.View
import android.view.ViewGroup
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_scroll_stick.*
import kotlinx.android.synthetic.main.activity_scroll_stick2.*

/**
 *@FileName: ScrollStickActivity2
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/8  https://blog.csdn.net/jkloshhm/article/details/78650081
 * @desc   : {缺点是当包裹内容布局中带有滑动特性的View（ListView，RecyclerView等)，
 * 我们需要额外处理滑动冲突，并且这种包裹方式，会使得它们的缓存模式失效。}
 */
class ScrollStickActivity2 : BaseActivity(R.layout.activity_scroll_stick2) {
    override fun initData() {

    }

    override fun initEvent() {

    }

    override fun initInterface() {
        //监听滚动
        sv_scroll_stick2_scroll.setScrollViewListener { scrollView, x, y, oldx, oldy ->
            val h = tv_scroll_stick2_header.height
            val height = ll_scroll_stick2_stick.top
            LogUtils.e("h = $h --- top = $height")
            if (y > 0 && y >= height){
                //addview
                if (rl_scroll_stick2_stick.parent != ll_scroll_stick2_title) {
                    ll_scroll_stick2_stick.removeView(rl_scroll_stick2_stick)
                    ll_scroll_stick2_title.addView(rl_scroll_stick2_stick)
                }
            }else{
               //remove view
                if (rl_scroll_stick2_stick.parent != ll_scroll_stick2_stick) {
                    ll_scroll_stick2_title.removeView(rl_scroll_stick2_stick)
                    ll_scroll_stick2_stick.addView(rl_scroll_stick2_stick)
                }
            }
        }

    }

    override fun onReload() {
    }
}