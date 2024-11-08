package com.team5.animal;

import java.util.List;

public class EndangeredMammal extends Mammal {
    private List<EndangermentReason> endangermentReasons;
    private String region;

    public EndangeredMammal(String commonName, String scientificName, List<EndangermentReason> endangermentReasons, String region) {
        super(commonName, scientificName);
        this.endangermentReasons = endangermentReasons;
        this.region = region;
    }

    public List<EndangermentReason> getEndangermentReasons() {
        return endangermentReasons;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public void move() {
        // Implement movement logic
    }
}
