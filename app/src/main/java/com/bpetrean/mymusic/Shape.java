package com.bpetrean.mymusic;

public abstract class Shape {
    String color;

    public Shape(String name) {
        this.color=name;
    }

    public abstract float getArea();
}
