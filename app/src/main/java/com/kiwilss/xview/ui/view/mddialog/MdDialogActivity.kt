/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: MdDialogActivity
 * Author:   kiwilss
 * Date:     2020/8/3 16:46
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.mddialog

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.mddialog.adapter.ListDialogAdapter
import com.kiwilss.xview.ui.view.mddialog.dialog.FullListDialog
import com.kiwilss.xview.ui.view.mddialog.dialog.ListDialog
import com.kiwilss.xview.ui.view.mddialog.dialog.SimpleDialog
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_mddialog.*

/**
 *@FileName: MdDialogActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/3
 * @desc   : {DESCRIPTION}
 */
class MdDialogActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mddialog)

        btn_mddialog_baidu.setOnClickListener {
            startActivity(Intent(this,FBaiDuMapActivity::class.java))
        }

        //bottomdialog test
        btn_mddialog_bottomdialog.setOnClickListener {
            showBottomDialog()
        }
        btn_mddialog_bottomdialog2.setOnClickListener {
            val dialog = SimpleDialog(this)
            //dialog.window!!.setDimAmount(0f)//;设置窗体背景透明
            //设置背景透明,以便显示圆角背景
            dialog.window!!.findViewById<View>(R.id.design_bottom_sheet)
                .setBackgroundColor(Color.TRANSPARENT)

            dialog.show()
        }

        btn_mddialog_list.setOnClickListener {
            val dialog = ListDialog(this)
            dialog.show()
        }
        btn_mddialog_listFull.setOnClickListener {
            val dialog = FullListDialog(this)
            dialog.show()
        }

        //把这个底部菜单和一个BottomSheetBehavior关联起来
        val behavior = BottomSheetBehavior.from(ll_mddialog_bottom)
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                //LogUtils.e(newState)
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
               LogUtils.e(slideOffset)
                vBg.alpha = slideOffset * 0.6f
//                if (slideOffset >= 0.01){
//                    tv_mddialog_bottomDialog.setBackgroundResource(R.drawable.bg_blue_fillet_10)
//                }else{
//                    tv_mddialog_bottomDialog.setBackgroundResource(R.drawable.bg_yellow_fillet_10)
//                }
                if (slideOffset > 0){
                    rlBg.visibility = View.GONE
                    tv_mddialog_bottomDialog.setBackgroundResource(R.drawable.bg_blue_fillet_10)
                }else{
                    rlBg.visibility = View.VISIBLE
                    tv_mddialog_bottomDialog.setBackgroundResource(R.drawable.bg_yellow_fillet_10)
                }

            }

        })
        //底部对话框展开点击
        btn_mddialog_expande.setOnClickListener {
            if(behavior.state == BottomSheetBehavior.STATE_EXPANDED) {//展开不管
                return@setOnClickListener
            }else{
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
        }
        //底部对话框隐藏点击
        btn_mddialog_hide.setOnClickListener {
            //behavior.setState(BottomSheetBehavior.STATE_HIDDEN)
        }
        //底部对话框关闭
        btn_mddialog_collose.setOnClickListener {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        }
        //初始化底部对话框列表
        initBottomList()

    }

    val list = arrayListOf<String>("测试数据一","测试数据二","测试数据三","测试数据四"
        ,"测试数据一","测试数据二","测试数据三","测试数据四")
    val mAdapter by lazy { ListDialogAdapter() }
    private fun initBottomList() {
        rv_mddialog_bottom?.run {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
        mAdapter.setList(list)
    }

    private fun showBottomDialog() {//可以滑动,向下滑动关闭
        val dialog = BottomSheetDialog(this)
        //dialog.setCanceledOnTouchOutside(true)//设置点击空白处是否消失
        val view = layoutInflater.inflate(R.layout.dialog_bottom_simple, null)
        dialog.setContentView(view)
        dialog.setCancelable(false)//设置是否可以滑动关闭
        dialog.setCanceledOnTouchOutside(true)//设置点击空白处是否消失
        view.findViewById<TextView>(R.id.tv_dialog_bottom_simple_title)
            .text = "第一条标签"
        dialog.show()
        //view.tv_dialog_bottom_simple_title
    }
}