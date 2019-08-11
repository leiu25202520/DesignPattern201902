package com.leiu2520.decorator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Component component = new ConcreateDecorator2(new ConcreateDecorator1(
                new ConcreateComponent()));
        component.functionA();
    }
}
