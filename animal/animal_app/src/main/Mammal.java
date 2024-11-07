package com.team5.animal;

public abstract class Mammal implements Animal {
    // Common properties for all mammals
    private boolean hasHair;
    private boolean isWarmBlooded;

    // Constructor
    public Mammal(boolean hasHair, boolean isWarmBlooded) {
        this.hasHair = hasHair;
        this.isWarmBlooded = isWarmBlooded;
    }

    // Getters
    public boolean hasHair() {
        return hasHair;
    }

    public boolean isWarmBlooded() {
        return isWarmBlooded;
    }

    // Abstract method for movement, to be implemented by subclasses
    public abstract void move();
}
