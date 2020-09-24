/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: TopBackActivity
 * Author:   Administrator
 * Date:     2020/8/18 9:12
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.behavioractivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_top_back.*

/**
 *@FileName: TopBackActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/18
 * @desc   : {DESCRIPTION}
 */
class TopBackActivity: AppCompatActivity() {

    val mAdapter by lazy { TopBackAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_back)
//        setContentView(R.layout.activity_top_back2)


        val list = arrayListOf<String>("1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4")
        rv_top_back_list?.run {
            layoutManager = LinearLayoutManager(this@TopBackActivity)
            adapter = mAdapter
        }
        mAdapter.setList(list)

        srl_top_back_refresh.isEnabled = false

    }
}

class TopBackAdapter : BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_sticky_two){
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item_sticky_two_text,item)
    }

}