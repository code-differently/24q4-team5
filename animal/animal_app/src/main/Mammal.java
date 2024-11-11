package com.team5.animal;

public abstract class Mammal implements Animal {
    private String commonName;
    private String scientificName;
    private boolean hasHair;
    private boolean isWarmBlooded;

    // Constructor
    public Mammal(String commonName, String scientificName, boolean hasHair, boolean isWarmBlooded) {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.hasHair = hasHair;
        this.isWarmBlooded = isWarmBlooded;
    }

    // Getters
    public String getCommonName() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public boolean hasHair() {
        return hasHair;
    }

    public boolean isWarmBlooded() {
        return isWarmBlooded;
    }

    // Abstract method for movement, to be implemented by subclasses
    public abstract void move();
}
