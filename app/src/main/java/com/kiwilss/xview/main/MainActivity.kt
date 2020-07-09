package com.kiwilss.xview.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterViewAnimator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.kiwilss.xview.R
import com.kiwilss.xview.model.main.MainBean
import com.kiwilss.xview.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mTitles = listOf<String>("约束布局")
    val mActivitys = listOf(MainActivity::class.java)

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
        mAdapter.setOnItemClickListener { adapter, view, position ->
            //startActivity(Intent(this,mActivitys[position]::class.java))

        }
        //初始化数据
        val datas = arrayListOf<MainBean>()
        var mainBean: MainBean
        for (index in mTitles.indices){
            mainBean = MainBean(mTitles[index],mActivitys[index])
            datas.add(mainBean)
        }
        Log.e("MMM", ": ${datas.size}");
//        mAdapter.setNewInstance(datas)
        mAdapter.setDiffNewData(datas)


        btn_main_new.setOnClickListener {
            setNewData()
        }
    }

    private fun setNewData() {
        val datas = arrayListOf<MainBean>()
        var mainBean: MainBean
        for (index in mTitles.indices){
            mainBean = MainBean(mTitles[index],mActivitys[index])
            datas.add(mainBean)
            datas.add(mainBean)
        }
        //mAdapter.addData(datas)
        mAdapter.setDiffNewData(datas)
//        mAdapter.setNewInstance(datas)
    }

}