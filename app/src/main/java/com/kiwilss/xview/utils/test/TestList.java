package com.kiwilss.xview.utils.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
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

        //searchAllFor();
        //searchAllIndex();
        //removeList();

        testBreak2();

    }




    public static void testBreak2(){
        ArrayList<Integer> list = new ArrayList<>();
         for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                if (i1 == 3){
                    continue;
                }
                list.add(i1);
            }
        }
        System.out.println(list);
    }

    public static void testBreak(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (i == 3){
                //break , 结果[0, 1, 2], 跳出for循环
                //continue , 结果[0, 1, 2, 4, 5] ,跳出此次循环
                //return  整个结束
                return;
            }
            list.add(i);
        }
        System.out.println(list);
    }

    public static void removeList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = list.size() - 1; i >= 6; i--) {
            list.remove(i);
        }
        System.out.println(list);
    }

    static String str = "开发中遇到要将某些字符文本使用SpannableStringBuilder替换成一个表情";
    static String key = "字符";

    private static void searchAllIndex() {
        long start = System.currentTimeMillis();
        System.out.println(start + "--start--\t");
        int a = str.indexOf(key);//*第一个出现的索引位置
        while (a != -1) {
            System.out.print(a + "\t");
            a = str.indexOf(key, a + 1);//*从这个索引往后开始第一个出现的位置
        }
        System.out.println((System.currentTimeMillis() - start) + "--end--\t");
    }

    public static void searchAllFor(){
        long start = System.currentTimeMillis();
        System.out.println(start + "--start--\t");
        for(int i = 0;  i < str.length(); i ++) {
            int at = str.indexOf(key, i);
//            if(at < 0) {
//                break;
//            }
            System.out.println(key + "@" + at);
            i = at;
        }
        System.out.println((System.currentTimeMillis() - start) + "--end--\t");
    }


    public static String stringToString2(String a){
        double d = 0.00;
        try {
            d = Double.parseDouble(a);
        }catch (Exception e){

        }
        DecimalFormat df = new DecimalFormat("##0.00");//此为保留1位小数，若想保留2位小数，则填写#.00  ，以此类推
        return df.format(d);
    }

    private static <E> void swap(List<E> list,int index1,int index2) {
        //定义第三方变量
        E e=list.get(index1);
        //交换值
        list.set(index1, list.get(index2));
        list.set(index2, e);
    }
}

