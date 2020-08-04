package com.kiwilss.xview.nulltest.bk;

public class Dependency implements DependencyBase, Nullable {

    @Override
    public void Operation() {
        System.out.println("Test!");
        System.out.println("---------operation--------");
    }

    @Override
    public boolean isNull() {
        return false;
    }
}