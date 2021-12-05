package com.example.monitorowaniejednostekmorskich.track.model;

public class Point {

    private double y;
    private double x;
    private String name;
    private String destinations;

    public Point(double y, double x, String name, String destinations) {
        this.y = y;
        this.x = x;
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
