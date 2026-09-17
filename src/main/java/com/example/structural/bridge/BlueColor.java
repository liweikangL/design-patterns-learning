package com.example.structural.bridge;

/**
 * 具体实现化：蓝色。
 */
public class BlueColor implements Color {

    @Override
    public void fillColor(String shapeName) {
        System.out.println("将 " + shapeName + " 填充为蓝色");
    }
}
