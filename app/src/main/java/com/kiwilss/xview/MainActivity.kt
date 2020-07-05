package com.kiwilss.xview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kiwilss.xview.utils.Utils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val channel = Utils.getUMChannelName(this)
        Log.e("MMM", ": ---$channel" );
    }
}