package com.team5.animal;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class EndangeredMammalIntegrationTest {

  @Test
  public void testDisplayAndSortAnimals() {
    // Set up the animal collection
    AnimalCollection animalCollection = new AnimalCollection();

    // Create some endangered mammals
    EndangeredMammal lion = new EndangeredMammal("Lion", "Panthera leo", Arrays.asList(EndangermentReason.POACHING), "Africa");
        EndangeredMammal elephant = new EndangeredMammal("Elephant", "Loxodonta", Arrays.asList(EndangermentReason.HABITAT_LOSS), "Africa");
        EndangeredMammal tiger = new EndangeredMammal("Tiger", "Panthera tigris", Arrays.asList(EndangermentReason.POLLUTION), "Asia");
    EndangeredMammal panda =
        new EndangeredMammal(
            "Panda", "Ailuropoda melanoleuca", Arrays.asList(EndangermentReason.HABITAT_LOSS), "China");

    // Add animals to the collection
    animalCollection.addAnimal(lion);
    animalCollection.addAnimal(elephant);
    animalCollection.addAnimal(tiger);
    animalCollection.addAnimal(panda);

    // Test display (without sorting)
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    animalCollection.displayAnimals();

    String expectedBeforeSort = "List of Endangered Mammals:\nLion\nElephant\nTiger\nPanda\n";
    assertTrue(outContent.toString().contains(expectedBeforeSort));

    // Test sorting animals alphabetically by common name
    animalCollection.sortByCommonName();

    // Reset the output stream to check sorted results
    outContent.reset();

    animalCollection.displayAnimals();

    String expectedAfterSort = "List of Endangered Mammals:\nElephant\nLion\nPanda\nTiger\n";
    assertTrue(outContent.toString().contains(expectedAfterSort));
  }
}