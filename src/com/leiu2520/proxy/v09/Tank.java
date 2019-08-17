package com.leiu2520.proxy.v09;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

//v09: 横切代码与业务逻辑代码分离 AOP
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Tank tank = new Tank();

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new TimeProxy(tank)
                );

        m.move();
    }
}

class TimeProxy implements InvocationHandler{
    Movable m;

    public TimeProxy(Movable m) {
        this.m = m;
    }

    public void before(){
        System.out.println("method start..");
    }

    public void after(){
        System.out.println("method end..");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(m,args);
        after();

        return o;
    }
}

interface Movable{
    void move();
}
