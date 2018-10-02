package com.andreitudorionescu.algos;

public class BinarySearch {

    // Returns index of element if it is present in array[left..right], else returns -1
    static int binarySearch(int array[], int left, int right, int element) {
        if (right >= left) {
            int middle = left + (right - left) / 2;

            // If element is present at middle, return it
            if (array[middle] == element)
                return middle;

            // If element is smaller than middle, check the left subarray
            if (array[middle] > element)
                return binarySearch(array, left, middle - 1, element);

            // If element is greater than middle, check the right subarray
            return binarySearch(array, middle + 1, right, element);
        }

        // Element is not present in the array
        return -1;
    }

}
