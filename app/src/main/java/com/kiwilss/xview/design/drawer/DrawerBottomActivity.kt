package com.kiwilss.xview.design.drawer

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.snackbar.Snackbar
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_drawer_bottom.*

/**
 *@FileName: DrawerBottomActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/24
 * @desc   : {DESCRIPTION}
 */
class DrawerBottomActivity: AppCompatActivity(R.layout.activity_drawer_bottom) {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tb_drawer_bottom_toolbar.title = "简单抽屉"
        tb_drawer_bottom_toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.blue_74D3FF))

        setSupportActionBar(tb_drawer_bottom_toolbar)
        //创建返回键，并实现打开关/闭监听
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,dl_drawer_bottom_drawer,tb_drawer_bottom_toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        actionBarDrawerToggle.syncState()
        dl_drawer_bottom_drawer.addDrawerListener(actionBarDrawerToggle)

        //抽屉打开关闭监听
        dl_drawer_bottom_drawer.addDrawerListener(object :DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(newState: Int) {

            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

            }

            override fun onDrawerClosed(drawerView: View) {

            }

            override fun onDrawerOpened(drawerView: View) {

            }

        })

        //侧滑抽屉点击监听
        nv_drawer_bottom_navigation.run {
            //设置每个文字和图片颜色变化
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                itemTextColor = resources.getColorStateList(R.drawable.nav_menu_text_color, null)
                itemIconTintList = resources.getColorStateList(R.drawable.nav_menu_text_color, null)
            }
            //设置默认选中
            setCheckedItem(R.id.nav_home)
            setNavigationItemSelectedListener {
                Snackbar.make(nv_drawer_bottom_navigation, "hello", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                dl_drawer_bottom_drawer.close()
                true
            }
        }


    }


}