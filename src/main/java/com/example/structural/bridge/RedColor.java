package com.example.structural.bridge;

/**
 * 具体实现化：红色。
 */
public class RedColor implements Color {

    @Override
    public void fillColor(String shapeName) {
        System.out.println("将 " + shapeName + " 填充为红色");
    }
}
