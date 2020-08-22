package com.kiwilss.xview.ui.view.mddialog

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_fbaidu.*


/**
 *@FileName: FBaiDuMapActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/22
 * @desc   : {DESCRIPTION}
 */
class FBaiDuMapActivity : AppCompatActivity(R.layout.activity_fbaidu) {
    private var isSetBottomSheetHeight: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //关联
//        val behavior = BottomSheetBehavior.from(rl_fbaidu_bottom)
//        //设置展开时的标题相关,点击关闭对话框
//        rl_fbaidu_top.setOnClickListener {
//            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
//        }
//        behavior.addBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                if(bottomSheet.top <2*rl_fbaidu_top.height){
//                    rl_fbaidu_top.visibility = View.VISIBLE;
//                    rl_fbaidu_top.alpha = slideOffset
//                    rl_fbaidu_top.translationY =
//                        (bottomSheet.top -2*rl_fbaidu_top.height).toFloat();
//                } else{
//                    rl_fbaidu_top.visibility = View.VISIBLE
//                }
//            }
//
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                if(newState!=BottomSheetBehavior.STATE_COLLAPSED&&bottom_sheet_tv.visibility ==View.VISIBLE){
//                    bottom_sheet_tv.visibility = View.GONE
//                    bottom_sheet_iv.visibility = View.VISIBLE
//                }else if(newState==BottomSheetBehavior.STATE_COLLAPSED&&bottom_sheet_tv.visibility ==View.GONE){
//                    bottom_sheet_tv.visibility = View.VISIBLE
//                    bottom_sheet_iv.visibility = View.GONE
//                }
//            }
//
//        })
        setListener()
    }

    private fun setListener() {
        //val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        //setSupportActionBar(toolbar)

        val behavior = BottomSheetBehavior.from(design_bottom_sheet)
        //底栏状态改变的监听
        //底栏状态改变的监听
        behavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState != BottomSheetBehavior.STATE_COLLAPSED && bottom_sheet_tv.visibility === View.VISIBLE) {
                    bottom_sheet_tv.visibility = View.GONE
                    bottom_sheet_iv.visibility = View.VISIBLE
                    //mAdapter.setOnItemClickListener(null) //底栏展开状态下屏蔽RecyclerView item的点击
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED && bottom_sheet_tv.visibility === View.GONE) {
                    bottom_sheet_tv.visibility = View.VISIBLE
                    bottom_sheet_iv.visibility = View.GONE
                    //mAdapter.setOnItemClickListener(this@BottomSheetActivity) //底栏折叠状态下恢复RecyclerView item的点击
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if (bottomSheet.getTop() < 2 * design_bottom_sheet_bar.height) {
                    //设置底栏完全展开时，出现的顶部工具栏的动画
                    design_bottom_sheet_bar.visibility = View.VISIBLE
                    design_bottom_sheet_bar.alpha = slideOffset
                    design_bottom_sheet_bar.translationY =
                        (bottomSheet.getTop() - 2 * design_bottom_sheet_bar.height).toFloat()
                } else {
                    design_bottom_sheet_bar.visibility = View.INVISIBLE
                }
            }
        })

        design_bottom_sheet_bar.setOnClickListener {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED) //点击顶部工具栏 将底栏变为折叠状态
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //修改SetBottomSheet的高度 留出顶部工具栏的位置
//        if (!isSetBottomSheetHeight) {
//            val linearParams = rl_fbaidu_bottom.layoutParams
//            linearParams.height = cl_fbaidu_outer.height - rl_fbaidu_top.height
//            rl_fbaidu_bottom.layoutParams = linearParams
//            isSetBottomSheetHeight = true //设置标记 只执行一次
//        }
        if (!isSetBottomSheetHeight) {
            val linearParams =
                design_bottom_sheet.layoutParams as CoordinatorLayout.LayoutParams
            linearParams.height =
                bottom_sheet_demo_coordinatorLayout.getHeight() - design_bottom_sheet_bar.height
            design_bottom_sheet.layoutParams = linearParams
            isSetBottomSheetHeight = true
        }
    }

}