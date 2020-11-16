package com.kiwilss.xview.utils.view;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;

public class TvUtils {

    /**
     * 富文本设置字体大小
     *
     * @param srcString
     * @param tartgetString
     * @param txtSize
     * @return
     */
    public static SpannableString setTextPartTextSize(String srcString, String tartgetString, int txtSize) {
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new AbsoluteSizeSpan(txtSize, false), position, position + tartgetString.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    /**富文本设置字体颜色和大小
     * @param srcString
     * @param tartgetString
     * @param targetColor
     * @param txtSizeDp
     * @return
     */
    public static SpannableString setTextPartTextSize(String srcString, String tartgetString, int targetColor, int txtSizeDp) {
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new AbsoluteSizeSpan(txtSizeDp, true), position, position + tartgetString.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mSp.setSpan(new ForegroundColorSpan(targetColor), position, position + tartgetString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    /**富文本设置部分文字颜色
     * @param srcString
     * @param tartgetString
     * @param targetColor
     * @return
     */
    public static SpannableString setTextPartColor(String srcString,String tartgetString,int targetColor){
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new ForegroundColorSpan(targetColor), position, position + tartgetString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    public static SpannableString setTextPartColor(String srcString,String tartgetString, String target2,int targetColor){
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new ForegroundColorSpan(targetColor), position, position + tartgetString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        int position2 = srcString.indexOf(target2);
        if (position2 >= 0) {
            mSp.setSpan(new ForegroundColorSpan(targetColor), position2, position2+ target2.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    /**富文本设置部分文字背景色
     * @param srcString
     * @param tartgetString
     * @param targetColor
     * @return
     */
    public static SpannableString setTextPartBg(String srcString,String tartgetString,int targetColor){
        int position = srcString.indexOf(tartgetString);
        SpannableString mSp = new SpannableString(srcString);
        if (position >= 0) {
            mSp.setSpan(new BackgroundColorSpan(targetColor), position, position + tartgetString.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }

    /**设置中划线
     * @param src
     * @param start
     * @param end
     * @return
     */
    public static SpannableString setStrikethrough(String src,int start,int end){
        SpannableString spannableString = new SpannableString(src);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, start,end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**设置下划线
     * @param src
     * @param start
     * @param end
     * @return
     */
    public static SpannableString setUnderline(String src,int start,int end){
        SpannableString spannableString = new SpannableString(src);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan, start,end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**同时设置下划线和中划线
     * @param src
     * @param up
     * @param down
     * @return
     */
    public static SpannableString setUpDownLine(String src,String up,String down){
        int uPosition = src.indexOf(up);
        int dPosition = src.indexOf(down);
        SpannableString mSp = new SpannableString(src);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        if (uPosition >= 0) {
            mSp.setSpan(strikethroughSpan, uPosition,uPosition+up.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        if (dPosition >= 0) {
            mSp.setSpan(underlineSpan, dPosition,dPosition+down.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        return mSp;
    }


    /**设置上标
     * @param src
     * @param start
     * @param end
     * @return
     */
    public static SpannableString setUpScript(String src,int start,int end){
        SpannableString spannableString = new SpannableString(src);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        spannableString.setSpan(superscriptSpan, start,end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**设置下标
     * @param src
     * @param start
     * @param end
     * @return
     */
    public static SpannableString setDownScript(String src,int start,int end){
        SpannableString spannableString = new SpannableString(src);
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        spannableString.setSpan(subscriptSpan, start,end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**设置部分文字加粗
     * @param src
     * @param start
     * @param end
     * @return
     */
    public static SpannableString setTextBold(String src,int start,int end){
        SpannableString spannableString = new SpannableString(src);
        StyleSpan styleSpan_B  = new StyleSpan(Typeface.BOLD);
        //StyleSpan styleSpan_I  = new StyleSpan(Typeface.ITALIC);
        spannableString.setSpan(styleSpan_B, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        spannableString.setSpan(styleSpan_I, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        textView.setHighlightColor(Color.parseColor("#36969696"));
//        textView.setText(spannableString);
        return spannableString;
    }

    /**设置部分文字倾斜
     * @param src
     * @param start
     * @param end
     * @return
     */
    public static SpannableString setTextItalic(String src,int start,int end){
        SpannableString spannableString = new SpannableString(src);
        //StyleSpan styleSpan_B  = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan_I  = new StyleSpan(Typeface.ITALIC);
        //spannableString.setSpan(styleSpan_B, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(styleSpan_I, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        textView.setHighlightColor(Color.parseColor("#36969696"));
//        textView.setText(spannableString);
        return spannableString;
    }

    public static SpannableString setTextIcon(String src, int start, int end, Drawable drawable){
        SpannableString spannableString = new SpannableString("在文本中添加表情（表情）");
        //Drawable drawable = getResources().getDrawable(R.mipmap.icon_one);
        drawable.setBounds(0, 0, 42, 42);
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannableString.setSpan(imageSpan, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

}