package com.qfedu.entity;

public class Num {
    private int i;

    @Override
    public String toString() {
        return "Num{" +
                "i=" + i +
                '}';
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Num() {
    }

    public Num(int i) {
        this.i = i;
    }
}
