package com.kiwilss.xview.ui.anim.transition.two.shared

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.anim.transition.bean.Sample
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.fg_share_element1.*

/**
 *@FileName: ShareFg1
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/15
 * @desc   : {DESCRIPTION}
 */
class ShareFg1 : Fragment() {


    companion object{
        const val EXTRA_SAMPLE = "sample"
        fun newInstance(sample: Sample): ShareFg1{
            val bundle = Bundle()
            bundle.putSerializable(EXTRA_SAMPLE,sample)
            val fg = ShareFg1()
            fg.arguments = bundle
            return fg
        }
    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fg_share_element1,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sample: Sample = arguments?.getSerializable(EXTRA_SAMPLE) as Sample
        //点击切换操作
        square_blue.setColorFilter(sample.color)

        sample2_button1.setOnClickListener {
            addNextFragment(sample, square_blue, false)
        }

        sample2_button2.setOnClickListener {
            addNextFragment(sample, square_blue, true)
        }

//        requireActivity().finishAfterTransition()
        //监控返回,什么都不写相当于拦截返回
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                LogUtils.e("onback")
                activity?.finishAfterTransition()
            }

        })
    }

    private fun addNextFragment(sample: Sample, squareBlue: ImageView?, overlap: Boolean) {

        val fg = ShareFg2.newInstance(sample)

        val slideTransition = Slide(Gravity.RIGHT)
        slideTransition.duration = 500

        val changeBoundsTransition = ChangeBounds()
        changeBoundsTransition.duration = 500

        fg.enterTransition = slideTransition
        fg.allowEnterTransitionOverlap = overlap
        fg.allowReturnTransitionOverlap = overlap
        fg.sharedElementEnterTransition = changeBoundsTransition

        parentFragmentManager.beginTransaction()
            .replace(R.id.fl_share_elementfg_fg, fg)
            .addToBackStack(null)
            .addSharedElement(squareBlue!!, getString(R.string.square_blue_name))
            .commit()


    }
}