package com.leiu2520.strategy;

import java.util.Arrays;

public class Main {
    public  static void main(String[] args){
        //int[] a = {9,2,3,5,7,1,4};
        Cat[] a = {new Cat(3,3),new Cat(1,1),new Cat(5,5)};
        Sorter<Cat> sorter = new Sorter();
        sorter.sort(a,new CatWeightComparetor());
        System.out.println(Arrays.toString(a));

        sorter.sort(a,new CatHeightComparetor());
        System.out.println(Arrays.toString(a));

        //Dog[] a = {new Dog(3),new Dog(5), new Dog(1)};
        //Sorter<Dog> sorter = new Sorter();
        //sorter.sort(a,new DogComparetor());
        //System.out.println(Arrays.toString(a));
    }
}
