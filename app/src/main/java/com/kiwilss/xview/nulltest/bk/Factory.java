package com.kiwilss.xview.nulltest.bk;

public class Factory {
    public static DependencyBase get(Nullable dependencyBase) {
        if (dependencyBase == null) {
            System.out.println("dependency == null");
            return new NullObject();
        }
        return new Dependency();
    }
}