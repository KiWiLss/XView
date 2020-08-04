package com.kiwilss.xview.nulltest.enumtest;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lss Administrator
 * @FileName: MapTest
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
public class MapTest {

    //Map<?, Function<?> action> actionMappings = new HashMap<>(); // 这里泛型 ? 是为方便演示，实际可替换为你需要的类型

    public static Map<Integer, String> init(){
        Map<Integer, String> maps = new HashMap<>();
        maps.put(1,"status == 1");
        maps.put(2,"status == 2");
        maps.put(3,"status == 3");
        return maps;
    }

    public static String getMaps(int status){
        SparseArray<String> map = new SparseArray<>();
        map.put(1,  "status == 1");
        map.put(2,  "status == 2");
        map.put(3,  "status == 3");
        return map.get(status);
    }

}

