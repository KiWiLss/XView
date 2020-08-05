package com.kiwilss.xview.main


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.format.DateUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.chad.library.adapter.base.BaseQuickAdapter
import com.kiwilss.xview.R
import com.kiwilss.xview.model.main.MainBean
import com.kiwilss.xview.ui.banner.BannerActivity
import com.kiwilss.xview.ui.copy.MTActivity
import com.kiwilss.xview.ui.glide.glidej.GlideJActivity
import com.kiwilss.xview.ui.view.constraint.ConstraintActivity
import com.kiwilss.xview.ui.optimization.viewstub.ViewStubActivity
import com.kiwilss.xview.ui.view.mddialog.MdDialogActivity
import com.kiwilss.xview.ui.view.popup.PopupActivity
import com.kiwilss.xview.ui.view.recyclerview.RecyclerViewActivity
import com.kiwilss.xview.ui.view.shaw.ShawActivity
import com.kiwilss.xview.ui.view.textview.TextViewActivity
import com.kiwilss.xview.ui.view.viewpager.ViewPageActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mTitles = listOf("约束布局","ViewStub","Glide java")
    private val mActivitys = listOf(ConstraintActivity::class.java,ViewStubActivity::class.java,
        GlideJActivity::class.java)

    private val mData = arrayListOf<MainBean>(
        MainBean("约束布局",ConstraintActivity::class.java),
        MainBean("ViewStub",ViewStubActivity::class.java),
        MainBean("Glide java",GlideJActivity::class.java),
        MainBean("TextView",TextViewActivity::class.java),
        MainBean("MeiTuan",MTActivity::class.java),
        MainBean("Banner",BannerActivity::class.java),
        MainBean("RecyclerView",RecyclerViewActivity::class.java),
        MainBean("Dialog",MdDialogActivity::class.java),
        MainBean("ViewPager2",ViewPageActivity::class.java),
        MainBean("PopupWindow",PopupActivity::class.java),
        MainBean("ShawLayout",ShawActivity::class.java)
    )

    //test
    private val mAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val channel = Utils.getUMChannelName(this)
//        Log.e("MMM", ": ---$channel" )

      rv_main_grid.layoutManager = GridLayoutManager(this,4)
        rv_main_grid.adapter = mAdapter
        mAdapter.setDiffCallback(DiffCallback())
        mAdapter.animationEnable = true
        mAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.AlphaIn)
        mAdapter.setOnItemClickListener { _, _, position ->
            val mainBean = mData[position]
            startActivity(Intent(this,mainBean.activity))
        }
        //初始化数据
//        val datas = arrayListOf<MainBean>()
//        var mainBean: MainBean
//        for (index in mTitles.indices){
//            mainBean = MainBean(mTitles[index],mActivitys[index])
//            datas.add(mainBean)
//        }
        //Log.e("MMM", ": ${datas.size}");
//        mAdapter.setNewInstance(datas)
        mAdapter.setDiffNewData(mData)


        btn_main_new.setOnClickListener {
            //setNewData()
        }


    }

//    private fun setNewData() {
//        val datas = arrayListOf<MainBean>()
//        var mainBean: MainBean
//        for (index in mTitles.indices){
//            mainBean = MainBean(mTitles[index],mActivitys[index])
//            datas.add(mainBean)
//            datas.add(mainBean)
//        }
//        //mAdapter.addData(datas)
//        mAdapter.setDiffNewData(datas)
////        mAdapter.setNewInstance(datas)
//    }

}