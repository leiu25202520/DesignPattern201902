package com.leiu2520.factorymethod;

public class CarFactory {
    public Moveable create(){
        System.out.println("a car create!");
        return new Car();
    }
}
