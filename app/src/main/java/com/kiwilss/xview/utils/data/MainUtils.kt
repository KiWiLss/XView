/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: MainUtils
 * Author:   Administrator
 * Date:     2020/8/10 17:31
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.utils.data

import com.kiwilss.xview.design.DesignActivity
import com.kiwilss.xview.model.main.MainBean
import com.kiwilss.xview.ui.banner.BannerActivity
import com.kiwilss.xview.ui.copy.MTActivity
import com.kiwilss.xview.ui.glide.glidej.GlideJActivity
import com.kiwilss.xview.ui.optimization.viewstub.ViewStubActivity
import com.kiwilss.xview.ui.startforresulthelp.HelpActivity
import com.kiwilss.xview.ui.view.constraint.ConstraintActivity
import com.kiwilss.xview.ui.view.dialog.DialogActivity
import com.kiwilss.xview.ui.view.mddialog.MdDialogActivity
import com.kiwilss.xview.ui.view.popup.PopupActivity
import com.kiwilss.xview.ui.view.recyclerview.RecyclerViewActivity
import com.kiwilss.xview.ui.view.shaw.ShawActivity
import com.kiwilss.xview.ui.view.shawshape.ShawShapeActivity
import com.kiwilss.xview.ui.view.textview.TextViewActivity
import com.kiwilss.xview.ui.view.viewpager.ViewPageActivity

/**
 *@FileName: MainUtils
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/10
 * @desc   : {DESCRIPTION}
 */
object MainUtils {
    fun getMainData() =
        arrayListOf<MainBean>(
            MainBean("约束布局", ConstraintActivity::class.java),
            MainBean("ViewStub", ViewStubActivity::class.java),
            MainBean("Glide java", GlideJActivity::class.java),
            MainBean("TextView", TextViewActivity::class.java),
            MainBean("MeiTuan", MTActivity::class.java),
            MainBean("Banner", BannerActivity::class.java),
            MainBean("RecyclerView", RecyclerViewActivity::class.java),
            MainBean("Dialog", MdDialogActivity::class.java),
            MainBean("ViewPager2", ViewPageActivity::class.java),
            MainBean("PopupWindow", PopupActivity::class.java),
            MainBean("ShawLayout", ShawActivity::class.java),
            MainBean("ShawShape", ShawShapeActivity::class.java),
            MainBean("Dialog", DialogActivity::class.java),
            MainBean("Design", DesignActivity::class.java),
            MainBean("ActivityHelp", HelpActivity::class.java)
        )


}