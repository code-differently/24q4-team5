package com.team5.animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalCollection {
    private List<EndangeredMammal> animals;

    public AnimalCollection() {
        animals = new ArrayList<>();
    }

    // Add an endangered mammal to the collection
    public void addAnimal(EndangeredMammal animal) {
        animals.add(animal);
    }

    // Display the list of endangered mammals by common name
    public void displayAnimals() {
        sortByCommonName(); 
        System.out.println("List of Endangered Mammals:");
        for (EndangeredMammal animal : animals) {
            System.out.println(animal.getCommonName());
        }
    }

    // Sort animals by their common name alphabetically
    public void sortByCommonName() {
        Collections.sort(animals, (animal1, animal2) -> animal1.getCommonName().compareTo(animal2.getCommonName()));
    }

    // Filter mammals by endangerment reason
    public List<EndangeredMammal> filterByEndangermentReason(EndangermentReason reason) {
        return animals.stream()
                      .filter(animal -> animal.getEndangermentReasons().contains(reason))
                      .collect(Collectors.toList());
    }

    // Filter mammals by geographic region
    public List<EndangeredMammal> filterByRegion(String region) {
        return animals.stream()
                      .filter(animal -> animal.getRegion().equalsIgnoreCase(region))  // Assuming `getRegion()` exists
                      .collect(Collectors.toList());
    }

    // Search by common name or scientific name
    public List<EndangeredMammal> search(String query) {
        return animals.stream()
                      .filter(animal -> animal.getCommonName().toLowerCase().contains(query.toLowerCase()) ||
                                        animal.getScientificName().toLowerCase().contains(query.toLowerCase()))
                      .collect(Collectors.toList());
    }

    public List<EndangeredMammal> getAnimals() {
        return animals;
    }
}
