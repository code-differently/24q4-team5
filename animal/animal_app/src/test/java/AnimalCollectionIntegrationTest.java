import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class AnimalCollectionIntegrationTest {

  @Test
  public void testFilterByRegionAndEndangermentReason() {
    AnimalCollection animalCollection = new AnimalCollection();
    // Add some animals to the collection
    EndangeredMammal panda =
        new EndangeredMammal(
            "Panda",
            "Ailuropoda melanoleuca",
            true,
            true,
            Arrays.asList(EndangermentReason.HABITAT_LOSS),
            "China");
    EndangeredMammal tiger =
        new EndangeredMammal(
            "Tiger",
            "Panthera tigris",
            true,
            true,
            Arrays.asList(EndangermentReason.POACHING),
            "Asia");
    EndangeredMammal elephant =
        new EndangeredMammal(
            "Elephant",
            "Loxodonta africana",
            true,
            true,
            Arrays.asList(EndangermentReason.HABITAT_LOSS),
            "Africa");

    animalCollection.addAnimal(panda);
    animalCollection.addAnimal(tiger);
    animalCollection.addAnimal(elephant);

    // First filter by region "China"
    List<EndangeredMammal> filteredByRegion = animalCollection.filterByRegion("China");

    // Now filter by endangerment reason "HABITAT_LOSS" from the region-filtered list
    List<EndangeredMammal> filteredAnimals =
        filteredByRegion.stream()
            .filter(
                animal -> animal.getEndangermentReasons().contains(EndangermentReason.HABITAT_LOSS))
            .collect(Collectors.toList());

    // Assertions
    assertEquals(1, filteredAnimals.size());
    assertEquals("Panda", filteredAnimals.get(0).getCommonName());
  }
}
