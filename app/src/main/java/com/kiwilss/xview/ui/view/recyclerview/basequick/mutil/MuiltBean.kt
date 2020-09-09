package com.kiwilss.xview.ui.view.recyclerview.basequick.mutil

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 *@FileName: MuiltBean
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
data class MuiltBean(val first: String, val second: String, override val itemType: Int,var spanSize: Int): MultiItemEntity {

    companion object{
        //线性布局,文字
        const val TEXT = 1
        //线性布局,图片
        const val IMG = 2
        //网格布局,文字
        const val Span = 3
    }

    //var spanSize : Int = 1


}