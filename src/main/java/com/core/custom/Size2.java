package com.core.custom;

import java.util.ArrayList;

public class Size2 {
    ArrayList<String> options = new ArrayList<>();
    public Size2()
    {
        for (int i = 30; i <= 60; i++)
        {
            options.add(String.valueOf(i));
        }
    }
}
