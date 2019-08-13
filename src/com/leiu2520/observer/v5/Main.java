package com.leiu2520.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者和被观察者
 */
class Child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<Observer>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }


    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        for(Observer o : observers){
            o.actionOnWakeUp();
        }
    }
}

interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer{
    @Override
    public void actionOnWakeUp() {
        System.out.println("dad feeding...");
    }
}

class Mum implements Observer{
    @Override
    public void actionOnWakeUp() {
        System.out.println("mum hugging...");
    }
}

class Dog implements Observer{
    @Override
    public void actionOnWakeUp() {
        System.out.println("dog wang...");
    }
}

public class Main {
    public static void main(String[] args){
        Child c = new Child();
        c.wakeUp();
    }
}
