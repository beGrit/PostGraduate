package org.yan.portal.service;

public class Test2 extends Test1 {
    static {
        System.out.println("Test2 静态代码块");
    }
    {
        System.out.println("Test2 代码块");
    }
    public Test2() {
        super(1);
        System.out.println("Test2 无参数构造方法" + super.toString());
    }
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.method1();
    }
}
