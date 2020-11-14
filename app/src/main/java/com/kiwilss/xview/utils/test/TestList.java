package com.kiwilss.xview.utils.test;

import java.util.List;

/**
 * @author : Lss Administrator
 * @FileName: TestList
 * @e-mail : kiwilss@163.com
 * @time : 2020/11/12
 * @desc : {DESCRIPTION}
 */
public class TestList {
    public static void main(String[] args) {
//        String one = "9";
//        double two = 10.69369;
//        System.out.println(Double.parseDouble(one));
//
//        DecimalFormat df = new DecimalFormat("#0.00");
//        String str = df.format(two);
//        System.out.println(str);
        String src = "就会很尴尬反光衣好好过过户籍卡就哈尴尬广告费好借好还GV";
        String target = "就会很尴尬反光衣好好过过";

        int index = src.indexOf(target);
        System.out.println(index);
        String substring = src.substring(target.length(), src.length());
        System.out.println(substring);
    }

    private static <E> void swap(List<E> list,int index1,int index2) {
        //定义第三方变量
        E e=list.get(index1);
        //交换值
        list.set(index1, list.get(index2));
        list.set(index2, e);
    }
}

