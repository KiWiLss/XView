package com.kiwilss.xview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.kiwilss.xview.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mTitles = listOf<String>("约束布局")
    val mActivitys = listOf<AppCompatActivity>()

    val mAdapter by lazy { MainAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val channel = Utils.getUMChannelName(this)
        Log.e("MMM", ": ---$channel" );

      rv_main_grid.layoutManager = GridLayoutManager(this,4)
        rv_main_grid.adapter = mAdapter
        mAdapter.setOnItemClickListener { adapter, view, position ->

        }

    }
}