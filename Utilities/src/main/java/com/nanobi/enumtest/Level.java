package com.nanobi.enumtest;

public enum Level {
    HIGH  (3,"p"),  //calls constructor with value 3
    MEDIUM(2,"ps"),  //calls constructor with value 2
    LOW   (1,"pp")   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private final int levelCode;
    private final String levelString;

    Level(int levelCode,String levelString) {
        this.levelCode = levelCode;
        this.levelString = levelString;
    }
    
    public int getLevelCode() {
        return this.levelCode;
    }
    public String getLevelString() {
        return this.levelString;
    }
    
}