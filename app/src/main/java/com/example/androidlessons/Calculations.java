package com.example.androidlessons;

import android.widget.TextView;

import java.io.Serializable;

public class Calculations implements Serializable {
    private int number1;
    private int number2;
    private int result;
    private int lastNumber;
    private String operator;

    public Calculations() {
        number1 = 0;
        number2 = 0;
        result = 0;
        lastNumber = 0;
        this.operator = operator;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(int lastNumber) {
        this.lastNumber = lastNumber;
    }
}
