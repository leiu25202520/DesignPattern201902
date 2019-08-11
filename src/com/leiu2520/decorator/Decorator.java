package com.leiu2520.decorator;

//抽象装饰者角色
public class Decorator implements Component{

    //抽象构件角色的引用
    private Component component;

    public Decorator(Component component)
    {
        this.component = component;
    }

    @Override
    public void functionA() {
        component.functionA();
    }
}
