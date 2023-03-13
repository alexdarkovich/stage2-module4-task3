package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.event.RectangleEvent;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        int id = rectangle.getId();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        double square = sideA * sideB;
        double perimeter = (sideA + sideB) * 2;
        System.out.println("square = " + square);
        System.out.println("perimeter = " + perimeter);

    }
    // Write your code here!
}
