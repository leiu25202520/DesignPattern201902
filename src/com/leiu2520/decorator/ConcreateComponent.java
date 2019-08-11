package com.leiu2520.decorator;

public class ConcreateComponent implements  Component {
    @Override
    public void functionA() {
        System.out.println("base function A");
    }
}
