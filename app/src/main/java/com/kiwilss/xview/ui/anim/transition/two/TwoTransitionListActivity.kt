package com.kiwilss.xview.ui.anim.transition.two

import android.annotation.SuppressLint
import android.content.Intent
import android.transition.Slide
import android.view.Gravity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.help.TransitionHelper

import com.kiwilss.xview.ui.anim.transition.bean.Sample
import com.kiwilss.xview.ui.anim.transition.two.transition.TransitionActivity1
import kotlinx.android.synthetic.main.activity_two_transition_list.*
import kotlinx.android.synthetic.main.item_two_transition_list.view.*

/**
 *@FileName: TwoTransitionListActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/14
 * @desc   : {DESCRIPTION}
 */
class TwoTransitionListActivity : BaseActivity(R.layout.activity_two_transition_list) {

    val mAdapter by lazy { TwoTransitionListAdapter() }

    private var samples: List<Sample>? = null
    @SuppressLint("ResourceType")
    override fun initData() {
         samples = listOf(
            Sample(ContextCompat.getColor(this, R.color.red), "Transitions"),
            Sample(ContextCompat.getColor(this, R.color.blue_74D3FF), "Shared Elements"),
            Sample(ContextCompat.getColor(this, R.color.green_07C0C2), "View animations"),
            Sample(ContextCompat.getColor(this, R.color.yellow_FF9B52), "Circular Reveal Animation")
        )
        mAdapter.setList(samples)
    }

    override fun initEvent() {
    }

    override fun initInterface() {
        setupWindowAnimations()
        rv_two_transition_list_list?.let {
           it.layoutManager = LinearLayoutManager(this)
            it.adapter = mAdapter
        }
        mAdapter.setOnItemClickListener { adapter, view, position ->
            val sample = mAdapter.data[position]
            when(position){
                0 -> {
                    transitionToOneActivity(TransitionActivity1::class.java,sample)
                }
                1 -> {

                }
                2 -> {

                }
                3 -> {

                }
            }

        }
    }

    private fun transitionToOneActivity(java: Class<TransitionActivity1>, sample: Sample) {
        val pairs = TransitionHelper.createSafeTransitionParticipants(this, true)
        startActivity(java,sample, *pairs)
    }

    private fun startActivity(
        target: Class<*>,
        sample: Sample,
        vararg pairs: Pair<View,String>
    ) {
        val i = Intent(this, target)
        val transitionActivityOptions: ActivityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this, *pairs)
        i.putExtra("sample", sample)
       startActivity(i, transitionActivityOptions.toBundle())
    }

    private fun setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        val slideTransition = Slide()
        slideTransition.slideEdge = Gravity.LEFT
        slideTransition.duration = 500
        window.reenterTransition = slideTransition
        window.exitTransition = slideTransition
    }
}





class TwoTransitionListAdapter: BaseQuickAdapter<Sample,BaseViewHolder>(R.layout.item_two_transition_list){
    override fun convert(holder: BaseViewHolder, item: Sample) {
        holder.run {
            setText(R.id.tv_item_two_transition_list_name,item.name)
        }
        holder.itemView.iv_item_two_transition_list_icon.setColorFilter(item.color)
    }

}