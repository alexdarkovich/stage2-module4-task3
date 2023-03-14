package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RectangleObserver implements Observer {
    private Map<Integer, RectangleValues> rectangleWarehouse;

    public RectangleObserver() {
        rectangleWarehouse = new HashMap<>();
    }

    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        int rectangleId = rectangle.getId();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();

        double square = sideA * sideB;
        double perimeter = 2 * (sideA + sideB);

        RectangleValues values = new RectangleValues(square, perimeter);
        rectangleWarehouse.put(rectangleId, values);
    }

    public Map<Integer, RectangleValues> getRectangleWarehouse() {
        return Collections.unmodifiableMap(rectangleWarehouse);
    }
    // Write your code here!
}
