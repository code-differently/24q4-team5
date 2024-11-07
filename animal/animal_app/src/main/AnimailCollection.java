package com.team5.animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        System.out.println("List of Endangered Mammals:");
        for (EndangeredMammal animal : animals) {
            System.out.println(animal.getCommonName());
        }
    }

    // Sort animals by their common name alphabetically
    public void sortByCommonName() {
        Collections.sort(animals, new Comparator<EndangeredMammal>() {
            @Override
            public int compare(EndangeredMammal animal1, EndangeredMammal animal2) {
                return animal1.getCommonName().compareTo(animal2.getCommonName());
            }
        });
    }
}
