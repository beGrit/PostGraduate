package org.yan.portal.service;

import org.junit.jupiter.api.Test;

public class Test1 {
    static {
        System.out.println("Tes1 静态代码块");
    }

    {
        System.out.println("Test1 非静态代码块");
    }
    public Test1() {
        System.out.println("Test1 无参数构造方法");
    }

    public Test1(int i) {
        System.out.println("Test1 有参数构造函数");
    }
    public void method1() {
        System.out.println("Test1 method1");
    }
    @Test
    void test() {
        Test1 test1 = new Test1();
        test1.method1();
    }
}
