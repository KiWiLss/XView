package com.kiwilss.xview.ui.anim.transition.test

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.help.TransitionHelper
import com.kiwilss.xview.utils.test.ResUtils
import kotlinx.android.synthetic.main.activity_transition_demolist.*

/**
 *@FileName: TransitionDemoListActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/21
 * @desc   : {DESCRIPTION}
 */
class TransitionDemoListActivity: BaseActivity(R.layout.activity_transition_demolist) {

    val mAdapter by lazy { TransitionDemoListAdapter() }

    override fun initData() {
        val list = arrayListOf<String>("1","1","1","1","1","1","1","1","1","1","1","1","1","1","1")
        mAdapter.setList(list)
    }

    override fun initEvent() {

    }

    override fun initInterface() {
        rv_transition_demolist_list?.run {
            layoutManager = GridLayoutManager(this@TransitionDemoListActivity,2)
            adapter = mAdapter
        }
    }
}

class TransitionDemoListAdapter : BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_transition_demolist){
    override fun convert(holder: BaseViewHolder, item: String) {

        val ivPic = holder.getView<View>(R.id.iv_item_transition_demolist_pic)
        val ivHeader = holder.getView<View>(R.id.iv_item_transition_demolist_header)
        val tvName = holder.getView<View>(R.id.tv_item_transition_demolist_name)


        holder.itemView.setOnClickListener {
            goToDetail(ivPic,ivHeader,tvName)
        }

    }

    private fun goToDetail(ivPic: View, ivHeader: View, tvName: View) {
        val intent = Intent(context,TransitionDemoDetailActivity::class.java)
        val pairs = TransitionHelper.createSafeTransitionParticipants(
            context as Activity,true,
            Pair(ivPic,ResUtils.getString(R.string.transition_demo_pic)),
            Pair(ivHeader,ResUtils.getString(R.string.transition_demo_header)),
            Pair(tvName,ResUtils.getString(R.string.transition_demo_nickname))
        )
        transitionTo(intent, *pairs)
    }

     fun transitionTo(i: Intent?,vararg pairs: Pair<View, String>) {
        //val pairs: Array<Pair<View, String>> = TransitionHelper.createSafeTransitionParticipants(this,true)
        val transitionActivityOptions: ActivityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, *pairs)
        context.startActivity(i, transitionActivityOptions.toBundle())
    }
}