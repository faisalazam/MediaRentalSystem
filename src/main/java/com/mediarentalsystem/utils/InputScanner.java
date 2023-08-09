package com.mediarentalsystem.utils;

import java.util.Scanner;

public class InputScanner {
    // Static variable reference of single_instance of type Singleton
    private static Scanner singleInstance = null;

    // Constructor
    // Here we will be creating private constructor restricted to this class itself
    private InputScanner() {
    }

    // Static method to create instance of Singleton class
    public static synchronized Scanner getInstance() {
        if (singleInstance == null) {
            singleInstance = new Scanner(System.in);
        }
        return singleInstance;
    }
}
