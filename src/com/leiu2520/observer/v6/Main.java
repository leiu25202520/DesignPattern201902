package com.leiu2520.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 很多时候，观察者需要根据事件的具体情况来处理
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

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(),"bed");

        for(Observer o : observers){
            o.actionOnWakeUp(event);
        }
    }
}

interface Observer{
    void actionOnWakeUp(wakeUpEvent event);
}

class Dad implements Observer {
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        System.out.println("dad feeding...");
    }
}

class Mum implements Observer {
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        System.out.println("mum hugging...");
    }
}

class Dog implements Observer {
    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        System.out.println("dog wang...");
    }
}

class wakeUpEvent{
    String loc;
    long timestamp;

    public wakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }



}

public class Main {
    public static void main(String[] args){
        Child c = new Child();
        c.wakeUp();
    }
}
