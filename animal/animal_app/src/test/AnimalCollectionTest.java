package com.team5.animal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class AnimalCollectionTest {

    @Test
    public void testAddAnimal() {
        AnimalCollection animalCollection = new AnimalCollection();
        
        // Create EndangeredMammal with a proper EndangermentReason list
        EndangeredMammal lion = new EndangeredMammal("Lion", "Panthera leo", Arrays.asList(EndangermentReason.POACHING), "Africa");
        animalCollection.addAnimal(lion);
        
        // Check if the collection size has increased
        assertEquals(1, animalCollection.getAnimals().size());
        assertTrue(animalCollection.getAnimals().contains(lion));
    }

    @Test
    public void testSortByCommonName() {
        AnimalCollection animalCollection = new AnimalCollection();
        
        EndangeredMammal lion = new EndangeredMammal("Lion", "Panthera leo", Arrays.asList(EndangermentReason.POACHING), "Africa");
        EndangeredMammal elephant = new EndangeredMammal("Elephant", "Loxodonta", Arrays.asList(EndangermentReason.HABITAT_LOSS), "Africa");
        EndangeredMammal tiger = new EndangeredMammal("Tiger", "Panthera tigris", Arrays.asList(EndangermentReason.POLLUTION), "Asia");
        
        animalCollection.addAnimal(lion);
        animalCollection.addAnimal(elephant);
        animalCollection.addAnimal(tiger);
        
        // Sort by common name
        animalCollection.sortByCommonName();
        
        // Verify that the collection is sorted alphabetically by common name
        assertEquals("Elephant", animalCollection.getAnimals().get(0).getCommonName());
        assertEquals("Lion", animalCollection.getAnimals().get(1).getCommonName());
        assertEquals("Tiger", animalCollection.getAnimals().get(2).getCommonName());
    }

    @Test
    public void testDisplayAnimals() {
        AnimalCollection animalCollection = new AnimalCollection();
        
        EndangeredMammal lion = new EndangeredMammal("Lion", "Panthera leo", Arrays.asList(EndangermentReason.POACHING), "Africa");
        animalCollection.addAnimal(lion);
        
        // Capture the output of the display method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        animalCollection.displayAnimals();
        
        // Verify if the common name of the animal is displayed
        assertTrue(outContent.toString().contains("Lion"));
        
        // Reset the System.out stream to default
        System.setOut(System.out);
    }
}
