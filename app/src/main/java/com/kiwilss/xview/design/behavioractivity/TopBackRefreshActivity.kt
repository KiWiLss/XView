/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TopBackRefreshActivity
 * Author:   Administrator
 * Date:     2020/8/18 15:02
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.behavioractivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.kiwilss.xview.R
import com.kiwilss.xview.design.appbar.AppBarStateChangeListener
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_refresh.*
import kotlinx.android.synthetic.main.activity_top_back2.*

/**
 *@FileName: TopBackRefreshActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/18
 * @desc   : {DESCRIPTION}
 */
class TopBackRefreshActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_back2)

        //刷新
        srl_top_back2_refresh.setOnRefreshListener {
            srl_top_back2_refresh.postDelayed({
                srl_top_back2_refresh.isRefreshing = false
            },1000)
        }
        srl_top_back2_refresh.isRefreshing = false
        //监听折叠滚动
        appbar_top_back2_appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?, i: Int) {
                if( state == State.EXPANDED ) {
                    //展开状态
                    srl_top_back2_refresh.isEnabled = true
                }else if(state == State.COLLAPSED){
                    //折叠状态
                    srl_top_back2_refresh.isEnabled = false
                }else {
                    //中间状态
                    srl_top_back2_refresh.isEnabled = false
                }
                LogUtils.e(state)
                LogUtils.e(i)
                //alpha 0 - 1
                rl_top_back2_red.background.alpha = i
            }



        })

    }
}