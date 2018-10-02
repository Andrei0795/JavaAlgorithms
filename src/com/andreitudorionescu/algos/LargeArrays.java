package com.andreitudorionescu.algos;
import java.util.Scanner;
import java.io.*;

public class LargeArrays {

    //Warning. Seems like 5 million and 10 million array elements will throw a stackoverflow error
    public static int[] makeLargeArray500K() {
        return makeLargeArray(500000);
    }

    public static int[] makeLargeArray(int size) {
        int [] array = new int[size];
        try {
            File file = new File("resources/data500k");
            Scanner s = new Scanner(file);
            int count = 0;
            array[0] = Integer.parseInt(s.next());
            count++;

            while (s.hasNextLine()) {
                array[count] = Integer.parseInt(s.next());
                s.nextLine();
                count++;

            }
            return array;
        } catch (Exception e) {
            System.out.println(e + "There was a problem with the file and getting the array!");
            array = new int[1];
            return array;
        }

    }
}
