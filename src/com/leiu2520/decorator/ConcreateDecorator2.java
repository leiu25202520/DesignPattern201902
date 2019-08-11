package com.leiu2520.decorator;

public class ConcreateDecorator2 extends Decorator{

    public ConcreateDecorator2(Component component) {
        super(component);
    }

    @Override
    public void functionA() {
        super.functionA();
        this.functionC();
    }
    //根据自己的需要扩展
    private void functionC() {
        System.out.println("function C");
    }
}
