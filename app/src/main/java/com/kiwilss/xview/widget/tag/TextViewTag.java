/*
 * Copyright (c) 2016 The MaMaHelp_small_withReceiver_7.0 Project,
 *
 * 深圳市新网智创科技有限公司. All Rights Reserved.
 */

package com.kiwilss.xview.widget.tag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.List;

/**
 * 本地图片放在文本前边或后边
 *
 * @author zhongwr
 */
@SuppressLint("AppCompatCustomView")
public class TextViewTag extends TextView {

    private int fontSize;
    private Context context;

    public TextViewTag(Context context) {
        this(context, null);
    }

    public TextViewTag(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    /**
     * 图片放在文本前边
     */
    public static final int START = 0;
    /**
     * 图片放在文本后边
     */
    public static final int END = 1;

    /**
     * 下午6:05:56
     *
     * @param tagIconPosition 图片标签位置
     * @param tagDrawablIds   标签的图片资源id集合
     */
    public void setTextTag(String text, int tagIconPosition, List<Integer> tagDrawablIds) {
        if (tagDrawablIds == null || tagDrawablIds.size() == 0) {
            setText(text);
            return;
        }
        // 先将表情或icon占位，通过设置charSequence
        setEmojiAndTagText(text, tagIconPosition, tagDrawablIds);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMaxLines(Integer.MAX_VALUE);

        // Measure
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getLineCount() >= 2) {
            setMaxLines(2);
        } else {
            setMaxLines(1);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 先将标签转换，在加载图片 下午6:05:56
     *
     * @param tagIconPosition 图片标签位置
     * @param tagDrawablIds   标签的图片id集合  resDrawIds;
     */
    private void setEmojiAndTagText(final String text, final int tagIconPosition, final List<Integer> tagDrawablIds) {
        fontSize = (int) getTextSize();
        addTagText(tagIconPosition, tagDrawablIds, text);
        // 在子线程中加载表情 ----注，若是有标签或者表情图片之类的，可以通过这个网络下载图片
        /*executorService.execute(new Runnable() {
            @Override
            public void run() {
                // 格式化表情：将所有的表情符转换成html类可以识别的格式:<img src="ef0265ef"/>
                String temp_title = EmojiUtils.convertTag3(text, context);
                // 创建ImageGetter对象
                ImageGetter imageGetter = new ImageGetter() {
                    @Override
                    public Drawable getDrawable(String source) {
                        Drawable emoji = null;
                        // 表情路径，其中source的格式为：ef0265ef
                        String url = Define.emoji_prefix + source + ".png";
                        Bitmap bm = imageLoader.loadImageSync(url, options_565);
                        if (null != bm) {
                            // 利用ImageLoader对象加载图片，并转换成Drawable格式
                            emoji = new BitmapDrawable(bm);
                        }
                        if (null == emoji) {
                            return null;
                        }
                        emoji.setBounds(0, 0, fontSize, fontSize);
                        return emoji;
                    }
                };
                try {
                    // 利用Html类格式化字符串
                    CharSequence emojiText = Html.fromHtml(temp_title, imageGetter, null);
                    Message msg = emojiHandler.obtainMessage();
                    msg.obj = addTagText(tagIconPosition, tagDrawablIds, emojiText);
                    emojiHandler.sendMessage(msg);
                }catch (Exception e){

                }

            }

        });*/
    }

    /**
     * 添加标签
     *
     * @param tagIconPosition   将标签放在文本的前面或者后边
     * @param tagDrawableIdList 本地标签的drawableId集合
     */
    private CharSequence addTagText(final int tagIconPosition, final List<Integer> tagDrawableIdList, CharSequence emojiText) {
        if (tagDrawableIdList == null || tagDrawableIdList.size() == 0) {
            return emojiText;
        }
        setText(emojiText);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");

        for (int i = 0; i < tagDrawableIdList.size(); i++) {
            spannableStringBuilder.append("t ");// 图片占位符
        }

        for (int i = 0; i < tagDrawableIdList.size(); i++) {
            int resourceId = tagDrawableIdList.get(i);
            TagSpan tagSpanned = new TagSpan(context, resourceId, fontSize, TagSpan.ALIGN_BASELINE, fontSize);
            // 将占位符（两个字符t ）替换成图片转成的文本
            spannableStringBuilder.setSpan(tagSpanned, i * 2, i * 2 + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        CharSequence sepText = getText();
        if (tagIconPosition == START) {//icon显示在前面
            spannableStringBuilder.append(sepText);
        } else {
            //
            spannableStringBuilder.insert(0, sepText);
            //插入的文本长度
//            spannableStringBuilder.append(sepText, 0, sepText.length());
        }
        setText(spannableStringBuilder);//最后设置文本内容
        return spannableStringBuilder;
    }
}
