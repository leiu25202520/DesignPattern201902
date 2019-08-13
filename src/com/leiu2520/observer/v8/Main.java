package com.leiu2520.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * 很多时候，观察者需要根据事件的具体情况来处理
 * 大多数时候，我们处理事物的时候，需要事件源对象
 * 事件也可以形成继承体系
 */
class Child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<Observer>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
        observers.add((e)->{
            System.out.println("ppp");
        });
    }


    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(),"bed",this);

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

abstract class Event<T>{
    abstract T getSource();
}

class wakeUpEvent extends Event<Child>{
    String loc;
    long timestamp;
    Child source;

    public wakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

public class Main {
    public static void main(String[] args){
        Child c = new Child();
        c.wakeUp();
    }
}
