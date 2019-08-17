package com.leiu2520.proxy.v10;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * v10: 通过反射观察生成的代理对象
 * jdk反射生成代理必须面向接口，这是由Proxy的内部实现决定的
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving claclacla....");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Tank tank = new Tank();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");


        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new TankProxy(tank)
                );

        m.move();

    }

}

class TankProxy implements InvocationHandler{
    Movable m ;

    public TankProxy(Movable m) {
        this.m = m;
    }

    public void before(){
        System.out.println("method start..");
    }

    public void after(){
        System.out.println("method stop..");
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
