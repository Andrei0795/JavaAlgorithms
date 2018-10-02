package com.andreitudorionescu.algos;

public class MergeSort {

    private static void merge(int array[], int left, int middle, int right) {
        // Find sizes of two arrays to be merged
        int sizeLeftArray = middle - left + 1;
        int sizeRightArray = right - middle;

        //Create and copy data to arrays
        int leftArray[] = new int [sizeLeftArray];
        int rightArray[] = new int [sizeRightArray];

        for (int i=0; i<sizeLeftArray; ++i)
            leftArray[i] = array[left + i];
        for (int j=0; j<sizeRightArray; ++j)
            rightArray[j] = array[middle + 1+ j];


        /* Merge arrays */

        //Initial indexes for left and right arrays
        int i = 0, j = 0;

        int indexMergedArray = left;
        while (i < sizeLeftArray && j < sizeRightArray) {
            if (leftArray[i] <= rightArray[j]) {
                array[indexMergedArray] = leftArray[i];
                i++;
            }
            else {
                array[indexMergedArray] = rightArray[j];
                j++;
            }
            indexMergedArray++;
        }

        //Copy remaining elements of left array
        while (i < sizeLeftArray) {
            array[indexMergedArray] = leftArray[i];
            i++;
            indexMergedArray++;
        }

        //Copy remaining elements of right array
        while (j < sizeRightArray) {
            array[indexMergedArray] = rightArray[j];
            j++;
            indexMergedArray++;
        }
    }

    public static void sort(int array[], int left, int right) {
        if (left < right)
        {
            int middle = (left+right)/2;

            sort(array, left, middle);
            sort(array , middle+1, right);

            merge(array, left, middle, right);
        }
    }
}
