package com.leiu2520.factorymethod;

public class Main {
    public static void main(String[] args){

        Moveable m = new CarFactory().create();
        Moveable p = new PlaneFactory().create();
        Moveable b = new BroomFactory().create();

        m.go();
        p.go();
        b.go();
    }
}
