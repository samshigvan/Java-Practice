package com.company.exception;

public class DemoException1 {

    public void method(){
//        throw new IOException();
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        DemoException1 obj = new DemoException1();
        obj.method();
    }
}
