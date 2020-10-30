package com.kiwilss.xview.widget.tag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kiwilss.xview.R;
import com.kiwilss.xview.utils.Utils;

/**
 * @author : Lss Administrator
 * @FileName: TagUtils
 * @e-mail : kiwilss@163.com
 * @time : 2020/10/30
 * @desc : {DESCRIPTION}
 */
public class TagUtils {
    public static void addTagToTextView(Context context,TextView target, String title, String tag) {
        if (TextUtils.isEmpty(title)) {
            title = "";
        }

        String content = title + tag;
        /**
         * 创建TextView对象，设置drawable背景，设置字体样式，设置间距，设置文本等
         * 这里我们为了给TextView设置margin，给其添加了一个父容器LinearLayout。不过他俩都只是new出来的，不会添加进任何布局
         */
        LinearLayout layout = new LinearLayout(context);
        TextView textView = new TextView(context);
        textView.setText(tag);
//        textView.setBackground(context.getResources().getDrawable(R.drawable.weight_topic_essence));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,context.getResources().getDimensionPixelSize(R.dimen.m15));
        textView.setTextColor(Color.parseColor("#ffffff"));
        textView.setIncludeFontPadding(false);
        textView.setPadding(Utils.INSTANCE.dip2px(context,6), 0,
                Utils.INSTANCE.dip2px(context,6), 0);
        textView.setHeight(Utils.INSTANCE.dip2px(context,17));
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setBackgroundResource(R.drawable.bg_yellow_all_fillet_10);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置左间距
        layoutParams.leftMargin = Utils.INSTANCE.dip2px(context,6);
        // 设置下间距，简单解决ImageSpan和文本竖直方向对齐的问题
        layoutParams.bottomMargin = Utils.INSTANCE.dip2px(context,3);

        layout.addView(textView, layoutParams);

        /**
         * 第二步，测量，绘制layout，生成对应的bitmap对象
         */
        layout.setDrawingCacheEnabled(true);
        layout.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        // 给上方设置的margin留出空间
        layout.layout(0, 0, textView.getMeasuredWidth() + Utils.INSTANCE.dip2px(context, (6 + 3)), textView.getMeasuredHeight());
        // 获取bitmap对象
        Bitmap bitmap = Bitmap.createBitmap(layout.getDrawingCache());
        //千万别忘最后一步
        layout.destroyDrawingCache();

        /**
         * 第三步，通过bitmap生成我们需要的ImageSpan对象
         */
        ImageSpan imageSpan = new ImageSpan(context, bitmap);


        /**
         * 第四步将ImageSpan对象设置到SpannableStringBuilder的对应位置
         */
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        //将尾部tag字符用ImageSpan替换
        ssb.setSpan(imageSpan, title.length(), content.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        target.setText(ssb);
    }

}

