package com.kiwilss.xview.ui.view.recyclerview.basequick.drag

import android.graphics.Canvas
import android.os.Handler
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.listener.OnItemDragListener
import com.chad.library.adapter.base.listener.OnItemSwipeListener
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_drag_delete.*

/**
 *@FileName: DragDeleteActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class DragDeleteActivity: BaseActivity(R.layout.activity_drag_delete) {

    var page = 1

    val mAdapter by lazy { DragDeleteAdapter() }

    private val mHandler = Handler()

    override fun initData() {
        //默认加载获取数据
        mLoadingHelper.showLoadingView()
        mHandler.postDelayed({
            mLoadingHelper.showContentView()
            val datas = arrayListOf<DragBean>()
            var bean : DragBean
            for (i in 0..19){
                bean = DragBean("标题数$i","页码$page")
                datas.add(bean)
            }
            if (srl_drag_delete_refresh.isRefreshing) {
                srl_drag_delete_refresh.isRefreshing = false
            }
            mAdapter.loadMoreModule.loadMoreComplete()
            if (page == 1){
                mAdapter.setList(datas)
            }else{
                mAdapter.addData(datas)
            }
        },1000)
    }

    override fun initEvent() {
        srl_drag_delete_refresh.setOnRefreshListener {
            page = 1
            initData()
        }

    }

    override fun initInterface() {

        rv_drag_delete_list?.run {
            layoutManager = LinearLayoutManager(this@DragDeleteActivity)
            adapter = mAdapter
        }

        //item点击
        mAdapter.setOnItemClickListener { adapter, view, position ->
            val data = mAdapter.data[position]
            LogUtils.e("position=$position ------------data = ${data.title} - ${data.test}")
        }
        //加载更多
        mAdapter.loadMoreModule.setOnLoadMoreListener {
            if (page <= 6){
                page ++
                initData()
            }else{
                mAdapter.loadMoreModule.loadMoreEnd()
            }
        }
        //设置拖拽
        mAdapter.draggableModule.isDragEnabled = true
        //设置侧滑
        mAdapter.draggableModule.isSwipeEnabled = true
        //设置左右都可以侧滑
        mAdapter.draggableModule.itemTouchHelperCallback.setSwipeMoveFlags(ItemTouchHelper.START or ItemTouchHelper.END)

        //拖拽监听,可以在这里做拖拽时的动画
//        mAdapter.draggableModule.setOnItemDragListener(object : OnItemDragListener{
//            override fun onItemDragMoving(
//                source: RecyclerView.ViewHolder?,
//                from: Int,
//                target: RecyclerView.ViewHolder?,
//                to: Int
//            ) {
//
//            }
//
//            override fun onItemDragStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
//
//            }
//
//            override fun onItemDragEnd(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
//
//            }
//
//        })

        //侧滑监听,可以在这里处理背景
//        mAdapter.draggableModule.setOnItemSwipeListener(object :OnItemSwipeListener{
//            override fun clearView(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
//
//            }
//
//            override fun onItemSwiped(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
//
//            }
//
//            override fun onItemSwipeStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
//
//            }
//
//            override fun onItemSwipeMoving(
//                canvas: Canvas?,
//                viewHolder: RecyclerView.ViewHolder?,
//                dX: Float,
//                dY: Float,
//                isCurrentlyActive: Boolean
//            ) {
//
//            }
//
//        })

    }
}