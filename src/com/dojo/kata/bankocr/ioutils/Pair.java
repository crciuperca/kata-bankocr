package com.dojo.kata.bankocr.ioutils;

public class Pair<T, T1> {
    T a;
    T1 b;

    public Pair(T a, T1 b) {
        this.a = a;
        this.b = b;
    }

    public T a() {
        return a;
    }

    public T1 b() {
        return b;
    }
}
