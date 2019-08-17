package com.leiu2520.proxy.v07;

import java.util.Random;

/**06：
 * 问题： 我想记录坦克的移动事件
 * 最简单的办法：修改代码，记录事件
 * 问题2:如果无法修改源码呢？
 * 用继承？
 * v05：使用代理
 * v06：代理有各种类型
 * 问题：如何实现代理的各种组合？继承?Decorator?
 * V07:代理的对象改成movable类型-越来越像decorator了
 * v08：如果有stop方法需要代理。。。
 * 如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型 Object
 * （毕竟日志计算，时间计算是很多方法都需要的东西），这是该怎么办呢？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
 */
public class Tank implements Movable{

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
        Tank t = new Tank();
        TankTimeProxy ttp = new TankTimeProxy(t);
        TankLogProxy tlp = new TankLogProxy(ttp);
        tlp.move();

    }
}

class TankTimeProxy implements Movable{
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class TankLogProxy implements Movable{
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        System.out.println("stopped!");
    }
}

interface Movable{
    void move();
}
