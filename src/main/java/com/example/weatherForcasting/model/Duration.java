package com.example.weatherForcasting.model;

public enum Duration {
    Daily(24);

    int value;

    Duration(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
