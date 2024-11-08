package com.team5.animal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class AnimalCollectionIntegrationTest {

    @Test
    public void testFilterByRegionAndEndangermentReason() {
        AnimalCollection collection = new AnimalCollection();

        // Add some animals to the collection
        EndangeredMammal panda = new EndangeredMammal("Panda", "Ailuropoda melanoleuca", 
                Arrays.asList(EndangermentReason.HABITAT_LOSS), "China");
        EndangeredMammal tiger = new EndangeredMammal("Tiger", "Panthera tigris", 
                Arrays.asList(EndangermentReason.POACHING), "Asia");
        EndangeredMammal elephant = new EndangeredMammal("Elephant", "Loxodonta africana", 
                Arrays.asList(EndangermentReason.HABITAT_LOSS), "Africa");

        collection.addAnimal(panda);
        collection.addAnimal(tiger);
        collection.addAnimal(elephant);

        // Filter by region "China" and endangerment reason "HABITAT_DESTRUCTION"
        var filteredAnimals = collection.filterByRegion("China");
        filteredAnimals = collection.filterByEndangermentReason(EndangermentReason.HABITAT_LOSS);

        assertEquals(1, filteredAnimals.size());
        assertEquals("Panda", filteredAnimals.get(0).getCommonName());
    }
}

