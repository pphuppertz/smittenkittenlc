package net.dnlcore.smittenkitten.models;

public enum Environment {
    INDOOR("indoor"), OUTDOOR("outdoor"), BOTH("both");

    private final String displayValue;

    private Environment(String displayValue) {
         this.displayValue = displayValue;
    }

     public String getDisplayValue() {
         return displayValue;
     }
}
