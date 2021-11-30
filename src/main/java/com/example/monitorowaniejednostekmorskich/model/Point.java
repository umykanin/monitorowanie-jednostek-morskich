package com.example.monitorowaniejednostekmorskich.model;

public class Point {

    private double x;
    private double y;
    private String name;
    private String destinations;

    public Point(double x, double y, String name, String destinations) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.destinations = destinations;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestinations() {
        return destinations;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }
}
