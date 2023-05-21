package me.jaron.enitiys;

import java.awt.*;
import java.util.Random;

public class Squares {
    private boolean on;
    private int type = 0; // 1,2,3 // 0 means off
    private Color color;
    private double spreadChance;
    private int lifeTime = 100;
    private double age = 0;

    public Squares() {
        this.on = false;
    }

    public void changeColor(int x, int y) {
        if (on) {
            Random random = new Random();
            if (random.nextDouble() < 0.5) {
                color = Color.WHITE;
            } else {
                color = Color.BLACK;
            }
            System.out.println("Square " + x + "," + y + " has changed to " + on);
        } else {
            color = null;
        }
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getSpreadChance() {
        return spreadChance;
    }

    public void setSpreadChance(double spreadChance) {
        this.spreadChance = spreadChance;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
