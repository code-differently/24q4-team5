package com.team5.animal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnimalCollectionIntegrationTest {

    @Test
    public void testFilterByRegionAndEndangermentReason() {
        AnimalCollection animalCollection = new AnimalCollection();

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

        // First filter by region "China"
        List<EndangeredMammal> filteredByRegion = animalCollection.filterByRegion("China");

        // Now filter by endangerment reason "HABITAT_LOSS" from the region-filtered list
        List<EndangeredMammal> filteredAnimals = filteredByRegion.stream()
            .filter(animal -> animal.getEndangermentReasons().contains(EndangermentReason.HABITAT_LOSS))
            .collect(Collectors.toList());

        // Assertions
        assertEquals(1, filteredAnimals.size());
        assertEquals("Panda", filteredAnimals.get(0).getCommonName());
    }
}