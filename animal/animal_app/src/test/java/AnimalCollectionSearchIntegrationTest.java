import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AnimalCollectionSearchIntegrationTest {

  @Test
  public void testSearchByCommonNameOrScientificName() {
    // Set up the animal collection
    AnimalCollection animalCollection = new AnimalCollection();

    // Create some Endangered Mammals
    EndangeredMammal lion =
        new EndangeredMammal(
            "Lion",
            "Panthera leo",
            true,
            true,
            Arrays.asList(EndangermentReason.HABITAT_LOSS),
            "Africa");
    EndangeredMammal tiger =
        new EndangeredMammal(
            "Tiger",
            "Panthera tigris",
            true,
            true,
            Arrays.asList(EndangermentReason.POACHING),
            "Asia");
    EndangeredMammal panda =
        new EndangeredMammal(
            "Panda",
            "Ailuropoda melanoleuca",
            true,
            true,
            Arrays.asList(EndangermentReason.POACHING),
            "China");

    // Add animals to the collection
    animalCollection.addAnimal(lion);
    animalCollection.addAnimal(tiger);
    animalCollection.addAnimal(panda);

    // Simulate searching by common name
    List<EndangeredMammal> result = animalCollection.search("Lion");

    // Verify the search returns the Lion
    assertEquals(1, result.size());
    assertTrue(result.stream().anyMatch(animal -> animal.getCommonName().equals("Lion")));

    // Simulate searching by scientific name
    result = animalCollection.search("Panthera tigris");

    // Verify the search returns the Tiger
    assertEquals(1, result.size());
    assertTrue(
        result.stream().anyMatch(animal -> animal.getScientificName().equals("Panthera tigris")));

    // Simulate a search that returns no results (non-existing animal)
    result = animalCollection.search("Elephant");

    // Verify no results are found
    assertTrue(result.isEmpty());
  }
}