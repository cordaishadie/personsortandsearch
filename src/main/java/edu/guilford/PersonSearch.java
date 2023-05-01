package edu.guilford;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PersonSearch {
    public static void main(String[] args) {

        // import a scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Today, you will be working with arrays of Person objects.");
        System.out.println("How many Person objects would you like to generate?");
        int numPeople = scan.nextInt();

        // create an array of Person objects with the size of numPeople
        Person[] people = new Person[numPeople];

        // populate the array with Person objects
        for (int i = 0; i < numPeople; i++) {
            people[i] = new Person();
        }

        // print the array of Person objects
        System.out.println("Here are the people you generated:");
        for (int i = 0; i < numPeople; i++) {
            // System.out.println(people[i].toString());
        }
        // print a blank line
        System.out.println();

        // sort the array of Person objects by name using the O(n^2) selection sort
        // algorithm
        // and time how long it takes to sort the array
        long startTime = System.nanoTime();
        PersonSortandSearch.selectionSortByName(people);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
         System.out.println(
                "Here is the array of Person objects sorted by name using the O(n^2) selection sort algorithm:");
        for (int i = 0; i < numPeople; i++) {
            // System.out.println(people[i].toString());
        } 
        System.out.println("It took " + (duration / 1.e6)
                + " milliseconds to sort the array of Person objects by name using the O(n^2) selection sort algorithm.");
        // print a blank line
        System.out.println();

        // shuffle the array of Person objects
        shuffle(people);
        // sort the array of Person objects by name using the O(log2n) quick sort
        // algorithm
        // and time how long it takes to sort the array
        startTime = System.nanoTime();
        PersonSortandSearch.quickSort(people, 0, people.length - 1);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out
                .println("Here is the array of Person objects sorted by name using the O(log2n) quick sort algorithm:");
        for (int i = 0; i < numPeople; i++) {
            // System.out.println(people[i].toString());
        } 
        System.out.println("It took " + (duration / 1.e6)
                + " milliseconds to sort the array of Person objects by name using the O(log2n) quick sort algorithm.");

        // shuffle the array of Person objects
        shuffle(people);
        // search for a Person object by name using the O(n) linear search algorithm
        // and time how long it takes to search for the Person object
        System.out.println("What name would you like to search for? \nFirst Name: ");
        String firstName = scan.next();
        System.out.println("Last Name: ");
        String lastName = scan.next();
        String name = firstName + " " + lastName;
        startTime = System.nanoTime();
        int index = PersonSortandSearch.linearSearchByName(people, firstName, lastName);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        if (index == -1) {
            System.out.println("The name " + name + " was not found in the array of Person objects.");
        } else {
            System.out
                    .println("The name " + name + " was found at index " + index + " in the array of Person objects.");
        }
        System.out.println("It took " + (duration / 1.e6) + " milliseconds to search for the name " + name
                + " in the array of Person objects using the linear search algorithm.");

        // binary search only works on sorted arrays, so do not shuffle the array of
        // Person objects, but sort it
        // search for a Person object by name using binary search algorithm
        // and time how long it takes to search for the Person object
        PersonSortandSearch.selectionSortByName(people);
        startTime = System.nanoTime();
        index = PersonSortandSearch.binarySearchByName(people, firstName, lastName);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        if (index == -1) {
            System.out.println("The name " + name + " was not found in the array of Person objects.");
        } else {
            System.out
                    .println("The name " + name + " was found at index " + index + " in the array of Person objects.");
        }
        System.out.println("It took " + (duration / 1.e6) + " milliseconds to search for the name " + name
                + " in the array of Person objects using the binary search algorithm.");
    }

    // add a sttic method to shuffle the array of Person objects
    public static void shuffle(Person[] people) {
        // loop over all elements in the array
        for (int i = 0; i < people.length; i++) {
            // generate a random number between 0 and people.length - 1
            int randomIndex = (int) (Math.random() * people.length);
            // swap the current element with the element at the random index
            swap(people, i, randomIndex);
        }
    }

    // add a static method to swap two elements in an array
    public static void swap(Person[] people, int i, int j) {
        Person temp = people[i];
        people[i] = people[j];
        people[j] = temp;
    }

}
