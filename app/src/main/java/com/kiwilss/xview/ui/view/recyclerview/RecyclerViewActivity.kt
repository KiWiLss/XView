/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerViewActivity
 * Author:   Administrator
 * Date:     2020/7/17 21:48
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.xview.ui.view.recyclerview

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.basequick.QucikHeaderFooterActivity
import com.kiwilss.xview.ui.view.recyclerview.basequick.SectionQuickActivity
import com.kiwilss.xview.ui.view.recyclerview.basequick.drag.DragDeleteActivity
import com.kiwilss.xview.ui.view.recyclerview.basequick.mutil.MuiltQuickActivity
import com.kiwilss.xview.ui.view.recyclerview.decoration_activity.RecyclerDecorationLinearActivity
import com.kiwilss.xview.ui.view.recyclerview.decoration_activity.RecyclerGideActivity
import com.kiwilss.xview.ui.view.recyclerview.decoration_activity.RecyclerIntervalActivity
import com.kiwilss.xview.ui.view.recyclerview.fixed.RecyclerItemFixedActivity
import com.kiwilss.xview.ui.view.recyclerview.fixed.RecyclerViewWrapActivity
import com.kiwilss.xview.ui.view.recyclerview.fixed.RecyclerWrapActivity
import com.kiwilss.xview.ui.view.recyclerview.flow.FlowActivity
import com.kiwilss.xview.ui.view.recyclerview.itemdecration.ItemDerationActivity
import com.kiwilss.xview.ui.view.recyclerview.loadmore.LoadMoreActivity
import com.kiwilss.xview.ui.view.recyclerview.stick.test.StickTestActivity
import com.kiwilss.xview.ui.view.recyclerview.stick.two.*
import com.kiwilss.xview.ui.view.recyclerview.swapadpter.SwapAdapterActivity
import com.kiwilss.xview.utils.ktx.IntentKtx.startActivity2
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlin.time.days

/**
 *@FileName: RecyclerViewActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/17
 * @desc   : {DESCRIPTION}
 */
class RecyclerViewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)


//        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
//        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
//// 请求结果，result 为 boolean true 代表已授权，false 代表未授权
//        }.launch(permission)



        btn_recycler_itemFixed.setOnClickListener {
            startActivity(Intent(this,
                RecyclerItemFixedActivity::class.java))
        }

        btn_recycler_itemWrap1.setOnClickListener {
            startActivity(Intent(this,
                RecyclerWrapActivity::class.java))
        }
        btn_recycler_itemWrap.setOnClickListener {
            startActivity(Intent(this,
                RecyclerViewWrapActivity::class.java))
        }

        btn_recycler_decoration.setOnClickListener {
            startActivity(Intent(this,
                RecyclerDecorationLinearActivity::class.java))
        }
        btn_recycler_decorationGrid.setOnClickListener {
            startActivity(Intent(this,
                RecyclerGideActivity::class.java))
        }
        btn_recycler_interval.setOnClickListener {
            startActivity(Intent(this,
                RecyclerIntervalActivity::class.java))
        }
        btn_recycler_add.setOnClickListener {
            startActivity(Intent(this,
                QucikHeaderFooterActivity::class.java))
        }
        btn_recycler_section.setOnClickListener {
            startActivity(Intent(this,
                SectionQuickActivity::class.java))
        }
        btn_recycler_muilt.setOnClickListener {
            startActivity(Intent(this,
                MuiltQuickActivity::class.java))
        }
        btn_recycler_delete.setOnClickListener {
            startActivity(Intent(this,
                DragDeleteActivity::class.java))
        }
        btn_recycler_stick.setOnClickListener {
            startActivity(Intent(this,
                StickTestActivity::class.java))
        }
        btn_recycler_flow.setOnClickListener {
            startActivity(Intent(this,
                FlowActivity::class.java))
        }
        btn_recycler_stick2.setOnClickListener {
            startActivity(Intent(this,
                StickyTwoActivity::class.java))
        }
        btn_recycler_stick3.setOnClickListener {
            startActivity(Intent(this,
                StickyTwoGridActivity::class.java))
        }
        btn_recycler_stick4.setOnClickListener {
            startActivity(Intent(this,
                StickyTwoCustomActivity::class.java))
        }
        btn_recycler_stick5.setOnClickListener {
            startActivity(Intent(this,
                StickyTwoCustomGridActivity::class.java))
        }
        btn_recycler_stick6.setOnClickListener {
            startActivity(Intent(this,
                AddressBookActivity::class.java))
        }
        btn_recycler_item.setOnClickListener {
            startActivity(Intent(this,
                ItemDerationActivity::class.java))
        }
        btn_recycler_swap.setOnClickListener {
            startActivity(Intent(this,
                SwapAdapterActivity::class.java))
        }
        btn_recycler_more.setOnClickListener {
            startActivity2<LoadMoreActivity>()
        }
    }
}