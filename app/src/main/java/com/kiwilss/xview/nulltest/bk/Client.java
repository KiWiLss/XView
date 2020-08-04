package com.kiwilss.xview.nulltest.bk;

public class Client {

    public static void test(DependencyBase dependencyBase) {
        Factory.get(dependencyBase).Operation();
    }

    public static void main(String[] args) {
        System.out.println("------------");
        Dependency dependency = new Dependency();
        test(dependency);
        //dependency.Operation();
    }
}