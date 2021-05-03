package com.example.androidlessons;

import android.widget.TextView;

import java.io.Serializable;

public class Calculations implements Serializable {
    private int number1;
    private int number2;
    private int result;
    String operator;

    public Calculations() {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
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
}
