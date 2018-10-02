package com.andreitudorionescu.algos;

public class QuickSort {
    static int partition(int array[], int low, int high)
    {
        int pivot = array[high];
        //Smaller element index
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }

    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int partitionIndex = partition(arr, low, high);

            sort(arr, low, partitionIndex-1);
            sort(arr, partitionIndex+1, high);
        }
    }


}
