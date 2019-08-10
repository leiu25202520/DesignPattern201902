package com.leiu2520.singleton;

/**
 * 静态内部类方式
 * jvm保证单例
 * 加载外部类时，不会加载内部类，这样可以实现懒加载
 */
public enum Mgr08 {

    INSTANCE;

    public void m(){

    }

    public static void main(String[] args){
        for(int i =0; i < 100 ; i++){
            new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
