package com.leiu2520.strategy;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);

    default void m(){
        System.out.println("m");
    }
}
