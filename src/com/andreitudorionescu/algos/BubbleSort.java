package com.andreitudorionescu.algos;

public class BubbleSort {
    static void bubbleSort(int arr[], int n)
    {
        int i, j, auxNumber;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    auxNumber = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = auxNumber;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, break
            if (swapped == false)
                break;
        }
    }
}
