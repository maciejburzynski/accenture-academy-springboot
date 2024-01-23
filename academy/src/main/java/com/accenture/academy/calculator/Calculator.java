package com.accenture.academy.calculator;

public class Calculator {
    public Integer add(int x, int y) {
        return x + y;
    }

    public Integer subtract(int x, int y) {
        return x - y;
    }

    public Integer multiply(int x, int y) {
        return x * y;
    }

    public Integer divide(int x, int y) {
        if (y == 0){
            throw new IllegalArgumentException("You can't divide by 0");
        }
        return x / y;
    }


}
