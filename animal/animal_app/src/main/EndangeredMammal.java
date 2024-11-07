package com.team5.animal;

public class EndangeredMammal extends Mammal {
    private String commonName;
    private String scientificName;
    private String geographicRegion;
    private EndangermentReason[] endangermentReasons;

    public EndangeredMammal(String commonName, String scientificName, String geographicRegion, EndangermentReason[] endangermentReasons) {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.geographicRegion = geographicRegion;
        this.endangermentReasons = endangermentReasons;
    }

    // Getters
    public String getCommonNaåme() {
        return commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getGeographicRegion() {
        return geographicRegion;
    }

    public EndangermentReason[] getEndangermentReasons() {
        return endangermentReasons;
    }

    // Implement the abstract method from Mammal (if needed)
    @Override
    public void move() {
        System.out.println(commonName + " is moving!");
    }
}

