package com.andreitudorionescu.algos;
import java.io.*;
import java.util.Scanner;


public class Main {

    private static Scanner scanner;

    public enum AlgoType {
        BINARYSEARCH  (1),
        QUICKSORT(2),
        INSERTSORT(3),
        BUBBLESORT(4),
        MERGESORT   (5);


        private final int algoNumber;

        AlgoType(int algoNumber) {
            this.algoNumber = algoNumber;
        }

        public int getAlgoNumber() {
            return this.algoNumber;
        }

    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to Algorithms!");

        scanner = new Scanner(System.in);

        //  prompt for the user's name
        System.out.println("Please select from the following options:");
        for (AlgoType enumValue: AlgoType.values()) {
            System.out.printf("%s \t %d \n", enumValue.toString(), enumValue.getAlgoNumber());
        }
        // get their input as a String
        AlgoType algoSelected = insertANumber();

        switch (algoSelected) {
            case BINARYSEARCH:
                runBinarySearch();
                break;
            case BUBBLESORT:
                runBubbleSort();
                break;
            case QUICKSORT:
                runQuickSort();
                break;
            case MERGESORT:
                runMergeSort();
                break;
            default:
                break;
        }

    }

    public static AlgoType insertANumber() {
        int numberReturned;

        while (true) {

            try {
                System.out.print("My number is: ");
                String str = scanner.next();
                numberReturned=  Integer.parseInt(str);

                for (AlgoType enumValue: AlgoType.values()) {
                    if (numberReturned == enumValue.getAlgoNumber()) {
                        return  enumValue;
                    }
                }

                System.out.println("Please type a valid number from the list above:");

            }
            catch(Exception e) {
                System.out.println("Please type a valid number from the list above:");
            }

        }
    }

    static void printArray(int arr[], int size)
    {
        System.out.println("Sorted array: ");
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void runBinarySearch() {
        //Array must be sorted
        int array[] = {2,3,4,10,40, 50, 111, 120, 250, 560, 1220, 1245, 2405};
        int lastElement = array.length - 1;
        int element = 111;
        int result = BinarySearch.binarySearch(array,0,lastElement, element);
        if (result == -1)
            System.out.println("The element is not present");
        else
            System.out.println("Element was found at index " +
                    result);
    }

    public static void runBubbleSort() {
        //This is the optimised version of bubble sort
        int array[] = LargeArrays.makeLargeArray500K();
        int n = array.length;
        BubbleSort.bubbleSort(array, n);
        printArray(array, 100);
    }

    public static void runQuickSort() {
        int array[] = LargeArrays.makeLargeArray500K();
        int n = array.length;
        QuickSort.sort(array, 0, n-1);
        printArray(array, 200);
    }

    public static void runMergeSort() {
        int array[] = LargeArrays.makeLargeArray500K();
        int n = array.length;
        MergeSort.sort(array, 0, n-1);
        printArray(array, 200);
    }

}
