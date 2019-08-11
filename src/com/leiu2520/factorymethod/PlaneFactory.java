package com.leiu2520.factorymethod;

public class PlaneFactory {
    public Moveable create(){
        System.out.println("a plane create!");
        return new Plane();
    }
}
