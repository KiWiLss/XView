package com.kiwilss.xview.ui.view.recyclerview.stick.test

import android.text.TextUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.view.recyclerview.decoration.LinearItemDecoration
import com.kiwilss.xview.ui.view.recyclerview.stick.CategoryBean
import kotlinx.android.synthetic.main.activity_stick_test.*

/**
 *@FileName: StickTestActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class StickTestActivity : BaseActivity(R.layout.activity_stick_test) {

    val mAdapter by lazy { StickTestAdapter() }

    override fun initData() {
        rv_stick_test_list.postDelayed({

            val lists = arrayListOf<CategoryBean>()
            lists.add(
                CategoryBean(
                    "A",
                    "哎"
                )
            )
            lists.add(
                CategoryBean(
                    "A",
                    "爱"
                )
            )
            lists.add(
                CategoryBean(
                    "A",
                    "昂"
                )
            )
            lists.add(
                CategoryBean(
                    "B",
                    "beautiful"
                )
            )
            lists.add(
                CategoryBean(
                    "B",
                    "beak"
                )
            )
            lists.add(
                CategoryBean(
                    "B",
                    "but"
                )
            )
            lists.add(
                CategoryBean(
                    "B",
                    "bring"
                )
            )
            lists.add(
                CategoryBean(
                    "C",
                    "category"
                )
            )
            lists.add(
                CategoryBean(
                    "C",
                    "can"
                )
            )
            lists.add(
                CategoryBean(
                    "C",
                    "captive"
                )
            )
            lists.add(
                CategoryBean(
                    "C",
                    "computer"
                )
            )
            lists.add(
                CategoryBean(
                    "D",
                    "default"
                )
            )
            lists.add(
                CategoryBean(
                    "D",
                    "diver"
                )
            )
            lists.add(
                CategoryBean(
                    "D",
                    "deline"
                )
            )
            mAdapter.setList(lists)

        },2000)

    }

    override fun initEvent() {

    }

    override fun initInterface() {

        val itemDivider = LinearItemDecoration.Builder(this)
            .setColorResource(R.color.black_333333)
            .setLeftPadding(R.dimen.m10)
            .build()
        rv_stick_test_list?.run {
            layoutManager = LinearLayoutManager(this@StickTestActivity)

            //加上分割线
            addItemDecoration(itemDivider)
            adapter = mAdapter

        }

//设置吸顶标题itemdecoration
        rv_stick_test_list.addItemDecoration(
            SectionDecoration(
                mAdapter.data,
                this,
                object : SectionDecoration.DecorationCallback {
                    override fun getGroupFirstLine(position: Int): String {
                        val tag = mAdapter.data[position].tag
                        if (tag.isNullOrEmpty()) {
                            return "-1"
                        }
                        return tag
                    }

                    override fun getGroupId(position: Int): String {
                        val tag = mAdapter.data[position].tag
                        if (tag.isNullOrEmpty()) {
                            return ""
                        }
                        return tag
                    }

                })
        )


    }
}