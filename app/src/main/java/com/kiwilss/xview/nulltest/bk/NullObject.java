package com.kiwilss.xview.nulltest.bk;

public class NullObject implements DependencyBase {

    @Override
    public void Operation() {
        System.out.println("is null");
    }

    @Override
    public boolean isNull() {
        return true;
    }
}