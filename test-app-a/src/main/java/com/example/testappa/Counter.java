package com.example.testappa;

import lombok.Getter;
import lombok.Setter;

public class Counter {
    
    @Getter 
    @Setter
    private int count = 0;
    private static Counter instance;

    private Counter() {

    }

    public static Counter getInstance() {
        if(Counter.instance == null) {
            Counter.instance = new Counter();  
        } return Counter.instance;
    }
}
