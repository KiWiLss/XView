package com.kiwilss.xview.ui.copy;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.kiwilss.xview.R;
import com.kiwilss.xview.nulltest.enumtest.Coupon;
import com.kiwilss.xview.utils.LogUtils;
import com.kiwilss.xview.utils.Utils;
import com.kiwilss.xview.widget.tag.TextViewTag;
import com.kiwilss.xview.widget.tag.WeightHotTopicList;
import com.kiwilss.xview.widget.textview.TagTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lss Administrator
 * @FileName: MTActivity
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/27
 * @desc : {测试各种难以处理的布局}https://github.com/xiaozhiguang/TagTextView
 *
 */
public class MTActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rl_test);
        View btnCamera = findViewById(R.id.btn_rl_camera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                 Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                 intent.putExtra("android.intent.extras.CAMERA_FACING", 2); // 调用前置摄像头
//                 startActivityForResult(intent, 1);
                 Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 intent.putExtra("camerasensortype", 2); // 调用前置摄像头
                 intent.putExtra("autofocus", true); // 自动对焦
                 intent.putExtra("fullScreen", false); // 全屏
                 intent.putExtra("showActionIcons", false);
                 startActivityForResult(intent, 2);
             }
         });

        Coupon coupon = new Coupon(9,"hello");
        LogUtils.e(coupon.isBeanShort());

        btnCamera.post(new Runnable() {
            @Override
            public void run() {
                int height = btnCamera.getHeight();
                LogUtils.e("height= " + height);
            }
        });

        //


        String name = "# 前面加一个标签";
        TextView tvStartTag = (TextView) findViewById(R.id.tv_start_tag);

        Drawable drawable = ContextCompat.getDrawable(this,R.drawable.weight_topic_recommend);
        drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.m15), getResources().getDimensionPixelSize(R.dimen.m15));
        ImageSpan imgSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(name);
        spannableString.setSpan(imgSpan, 0 , 1 , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvStartTag.setText(spannableString);





        TagTextView tvTag =  findViewById(R.id.tv_rl_test_tag);
        List<String> tags = new ArrayList<>();
        tags.add("置顶");
        tags.add("置顶1");
        tags.add("置顶2");
        tvTag.setContentAndTag("凌宇是个大帅逼",tags);

        //
        TextViewTag tvTag1 = (TextViewTag) findViewById(R.id.tag_one);
        TextViewTag tvTag2 = (TextViewTag) findViewById(R.id.tag_two);
        TextViewTag tvTag3 = (TextViewTag) findViewById(R.id.tag_three);
        TextViewTag tvTagLast = (TextViewTag) findViewById(R.id.tag_last);

        WeightHotTopicList topicItem = new WeightHotTopicList();
        topicItem.is_essence = 1;
        tvTag1.setTextTag("这是最棒的精华帖这是最棒的精华帖这是最棒的精华帖这是最棒的精华帖这是最棒的精华帖", TextViewTag.START, getTagDrawableIdList(topicItem));
        topicItem.is_recommend = 1;
        tvTag2.setTextTag("这是最棒的精华帖和推荐帖这是最棒的精华帖和推荐帖这是最棒的精华帖和推荐帖这是最棒的精华帖和推荐帖", TextViewTag.START, getTagDrawableIdList(topicItem));
        topicItem.is_best = 1;
        tvTag3.setTextTag("这是最棒的精华帖、推荐帖和优秀贴", TextViewTag.START, getTagDrawableIdList(topicItem));
        topicItem.is_solve = 1;
//        tvSolve.setTextTag("这个问答帖是精华帖、推荐帖和优秀贴，并且已经被解决了", TextViewTag.START, getTagDrawableIdList(topicItem));
        tvTagLast.setTextTag("这个问答帖是精华帖、推荐帖和优秀贴，并且已经被解决了", TextViewTag.END, getTagDrawableIdList(topicItem));


        //自己计算
        TextView tvTagOne = (TextView) findViewById(R.id.tv_rl_test_tag1);
        TextView tvTagEmpty = (TextView) findViewById(R.id.tv_rl_test_tagEmpty);
        TextView tvNormal = (TextView) findViewById(R.id.tv_rl_test_normal);
        String tag = tvTagOne.getText().toString();
        StringBuffer sb = new StringBuffer("\t");
        for (int i = 0; i < tag.length(); i++) {
            sb.append("\t\t");
        }
        sb.append("正常的文本内容正常的文本内容正常的文本内容正常的文本内容正常的文本内" +
                "容正常的文本内容内容正常的文本内容正常的文本内容正常的文本内容文本内容内容正常的文本内容正常的文本内容正常的文本内容");
        tvNormal.setText(sb.toString());


        TextView tvTestOne = (TextView) findViewById(R.id.tv_rl_test_one);
//            tvTestOne.post(new Runnable() {
//                @Override
//                public void run() {
//                    String text = tvTestOne.getText().toString();
//                    int lineMaxNumber = StringLengthsUtil.getLineMaxNumber(text, tvTestOne.getPaint(), tvTestOne.getWidth());
//                    LogUtils.e(lineMaxNumber,"-------------lines-->");
//                }
//            });
//        TagUtils.addTagToTextView(this,tvTestOne,"正常的文本内容正常的文本内容正常的文本内容正常的文本内容正常的文本","标签");
        String line = getLine(tvTestOne, 1);
        //限制显示两行,后面跟随一个标签
        //要显示的数据源
        String tagSrc = "文字是人类用表意符号记录表达信息以传之久远的方式和工具。现代文字大多是记录语言的工具。人类往往先有口头的语言后产生书面文字，很多小语种，有语言但没有文字。文字的不同体现了国家和民族的书面表达的方式和思维不同。文字使人类进入有历史记录的文明社会。";
        TextView tvTagOnes = (TextView) findViewById(R.id.tv_rl_test_tagOne);
        TextView tvTagTwo = (TextView) findViewById(R.id.tv_rl_test_tagTwo);
        tvTagOnes.setText(tagSrc);
        tvTestOne.setText(tagSrc);
        //判断第一行是否可以完整显示
        tvTagOnes.post(new Runnable() {
            @Override
            public void run() {
                //获取第一个 textview 显示的内容
                String lineContent = Utils.INSTANCE.getTextLineContent(tvTagOnes, 0, tagSrc);
                LogUtils.e(tagSrc + "---------" + lineContent);
                if (TextUtils.equals(tagSrc,lineContent)){//可以显示完整
                    tvTagOnes.setVisibility(View.GONE);
                    tvTagTwo.setText(tagSrc);
                }else {//显示不完整,需要分行
                    tvTagOnes.setVisibility(View.VISIBLE);
                    String srcTwoContent = tagSrc.substring(lineContent.length(), tagSrc.length());
                    tvTagTwo.setText(srcTwoContent);
                }
            }
        });

        //前面加标签
        TextView tvFront = (TextView) findViewById(R.id.tv_rl_test_tagFront);
        TextView tvFrontOne =  findViewById(R.id.tv_rl_test_frontOne);
        TextView tvFrontTwo =  findViewById(R.id.tv_rl_test_frontTwo);

        tvFrontOne.setText(tagSrc);
        //获取tvFrontOne显示的内容
        tvFrontOne.post(new Runnable() {
            @Override
            public void run() {
                //获取第一行显示的内容
                String lineContent = Utils.INSTANCE.getTextLineContent(tvFrontOne, 0, tagSrc);
                if (TextUtils.equals(lineContent,tagSrc)){
                    //一行可以完整显示
                    tvFrontTwo.setVisibility(View.GONE);
                }else {
                    //需要多行才能显示
                    tvFrontTwo.setVisibility(View.VISIBLE);
                    String nextContent = tagSrc.substring(lineContent.length(), tagSrc.length());
                    tvFrontTwo.setText(nextContent);
                }
            }
        });




    }

    public String getLine(TextView textView, int line){
        final String[] result = {""};
        textView.post(new Runnable() {
            @Override
            public void run() {
                Layout layout = textView.getLayout();
                int lineCount = textView.getLineCount();
                String src = textView.getText().toString();
                StringBuilder sb = new StringBuilder(src);
                LogUtils.e(lineCount,"linecount-->");
                for (int i = 0; i < lineCount; i++) {
                    //使用getLineStart 和 getLineEnd 得到指定行的开始和结束的坐标，坐标范围是SrcStr整个字符串范围内。
                    String lineStr = sb.subSequence(layout.getLineStart(i),layout.getLineEnd(i)).toString();
                    Log.d("MMM",lineStr);
                }
                result[0] = sb.subSequence(layout.getLineStart(line),layout.getLineEnd(line)).toString();
                LogUtils.e(result[0],"result--->");
            }
        });
        return result[0];
    }

    public List<Integer> getTagDrawableIdList(WeightHotTopicList topicItem) {
        List<Integer> drawIdList = new ArrayList<Integer>();
        if (1 == topicItem.is_recommend) {// 推荐
            drawIdList.add(R.drawable.weight_topic_recommend);
        }
        if (1 == topicItem.is_essence) {// 精华
            drawIdList.add(R.drawable.weight_topic_essence);
        }
        if (1 == topicItem.is_best) {// 优
            drawIdList.add(R.drawable.weight_topic_excellent);
        }
        if (1 == topicItem.is_solve) {// 已解决
            drawIdList.add(R.drawable.topic_solve_icon);
        }
        return drawIdList;
    }
}

