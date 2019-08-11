package com.leiu2520.factorymethod;

public class BroomFactory {
    public Moveable create(){
        System.out.println("a broom create!");
        return new Broom();
    }
}
