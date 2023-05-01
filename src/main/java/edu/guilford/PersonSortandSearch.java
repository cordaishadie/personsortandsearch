package edu.guilford;

public class PersonSortandSearch {

    // methods that sorts an array of Person objects by name
    // this method uses the O(n^2) selection sort algorithm to sort an array of
    // Person
    // by name
    public static void selectionSortByName(Person[] people) {
        // loop through the array of Person objects
        for (int i = 0; i < people.length - 1; i++) {
            // set the index of the Person object with the smallest name to i
            int minIndex = i;
            // loop through the array of Person objects starting at index i + 1
            for (int j = i + 1; j < people.length; j++) {
                // if the name of the Person object at index j is less than the name of the
                // Person object at index minIndex
                if (people[j].getLastName().compareTo(people[minIndex].getLastName()) < 0) {
                    // set minIndex to j
                    minIndex = j;
                }
                // if the people have the same last name, sort by first name
                else if (people[j].getLastName().compareTo(people[minIndex].getLastName()) == 0) {
                    // if the first name of the Person object at index j is less than the first
                    // name of the Person object at index minIndex
                    if (people[j].getFirstName().compareTo(people[minIndex].getFirstName()) < 0) {
                        // set minIndex to j
                        minIndex = j;
                    }
                }
            }
            // swap the Person object at index i with the Person object at index minIndex
            swap(people, i, minIndex);
        }
    }

    // this method uses the 0(log n) quick sort algorithm
    // the quickSort method takes an array of Person objects as a parameter and
    // sorts the array using the quick sort algorithm
    public static void quickSort(Person[] people) {
        // call the quickSort method with the array of Person objects, 0, and the length
        // of the array of Person objects - 1
        quickSort(people, 0, people.length - 1);
    }

    // the quickSort method takes an array of Person objects, a start index,
    // and an end index as parameters and sorts the array using the quick sort
    // algorithm
    // *recursive method*
    public static void quickSort(Person[] people, int start, int end) {
        // if the start index is less than the end index
        if (start < end) {
            // set the pivot index to the index returned by the partition method
            int pivotIndex = partition(people, start, end);
            // call the quickSort method with the array of Person objects, the start index,
            // and the pivot index - 1
            quickSort(people, start, pivotIndex - 1);
            // call the quickSort method with the array of Person objects, the pivot index +
            // 1, and the end index
            quickSort(people, pivotIndex + 1, end);
        }
    }

    // the partition method takes an array of Person objectsa as a parameter
    // and partitions the array using the quick sort algorithm
    public static int partition(Person[] people, int start, int end) {
        // set the pivot to the Person object at the end index
        Person pivot = people[end];
        // set the partition index to the start index
        int partitionIndex = start;
        // loop through the array of Person objects from the start index to the end
        // index
        for (int i = start; i < end; i++) {
            // if the last name of the Person object at index i is less than the last name
            // of the pivot
            if (people[i].getLastName().compareTo(pivot.getLastName()) < 0) {
                // swap the Person object at index i with the Person object at the partition
                // index
                swap(people, i, partitionIndex);
                // increment the partition index
                partitionIndex++;
            }
            // if the last name of the Person object at index i is the same as the last name
            // of the pivot
            else if (people[i].getLastName().compareTo(pivot.getLastName()) == 0) {
                // if the first name of the Person object at index i is less than the first name
                // of the pivot
                if (people[i].getFirstName().compareTo(pivot.getFirstName()) < 0) {
                    // swap the Person object at index i with the Person object at the partition
                    // index
                    swap(people, i, partitionIndex);
                    // increment the partition index
                    partitionIndex++;
                }
            }
        }
        // swap the Person object at the partition index with the Person object at the
        // end index
        swap(people, partitionIndex, end);
        // return the partition index
        return partitionIndex;
    }

    // let's create a method that will swap two elements in an array
    public static void swap(Person[] people, int i, int j) {
        // create a temporary Person object to hold the Person object at index i
        Person temp = people[i];
        // set the Person object at index i to the Person object at index j
        people[i] = people[j];
        // set the Person object at index j to the Person object at index i
        people[j] = temp;
    }

    // this method uses the linear search algorithm to search for a Person object by
    // first and last name
    public static int linearSearchByName(Person[] people, String firstName, String lastName) {
        // loop through the array of Person objects
        for (int i = 0; i < people.length; i++) {
            // if the first name of the Person object at index i is the same as the first
            // name we are searching for
            if (people[i].getFirstName().compareTo(firstName) == 0) {
                // if the last name of the Person object at index i is the same as the last name
                // we are searching for
                if (people[i].getLastName().compareTo(lastName) == 0) {
                    // return the index of the Person object
                    return i;
                }
            }
        }
        // if the name we are searching for is not in the array of Person objects,
        // return -1
        return -1;
    }

    // this method uses the binary search algorithm to search for a Person object by
    // first and last name
    public static int binarySearchByName(Person[] people, String firstName, String lastName) {
        // set the low index to 0
        int low = 0;
        // set the high index to the length of the array of Person objects - 1
        int high = people.length - 1;
        // loop through the array of Person objects
        while (low <= high) {
            // set the middle index to the average of the low and high indices
            int middle = (low + high) / 2;
            // if the first name of the Person object at index middle is the same as the
            // first name we are searching for
            if (people[middle].getFirstName().compareTo(firstName) == 0) {
                // if the last name of the Person object at index middle is the same as the last
                // name we are searching for
                if (people[middle].getLastName().compareTo(lastName) == 0) {
                    // return the index of the Person object
                    return middle;
                }
                // if the last name of the Person object at index middle is alphabetically after
                // the last name we are searching for
                else if (people[middle].getLastName().compareTo(lastName) > 0) {
                    // set the high index to middle - 1
                    high = middle - 1;
                }
                // if the last name of the Person object at index middle is alphabetically
                // before
                // the last name we are searching for
                else {
                    // set the low index to middle + 1
                    low = middle + 1;
                }
            }
            // if the first name of the Person object at index middle is alphabetically
            // after
            // the first name we are searching for
            else if (people[middle].getFirstName().compareTo(firstName) > 0) {
                // set the high index to middle - 1
                high = middle - 1;
            }
            // if the first name of the Person object at index middle is alphabetically
            // before
            // the first name we are searching for
            else {
                // set the low index to middle + 1
                low = middle + 1;
            }
        }
        // if the name we are searching for is not in the array of Person objects,
        // return -1
        return -1;
    }
}
