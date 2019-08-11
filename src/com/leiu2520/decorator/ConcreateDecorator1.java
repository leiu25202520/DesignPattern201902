package com.leiu2520.decorator;

public class ConcreateDecorator1 extends Decorator{

    public ConcreateDecorator1(Component component) {
        super(component);
    }

    @Override
    public void functionA() {
        super.functionA();
        this.functionB();
    }
    //根据自己的需要扩展
    private void functionB() {
        System.out.println("function B");
    }
}
