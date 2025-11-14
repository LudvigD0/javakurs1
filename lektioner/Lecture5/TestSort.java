package Lecture5;

import java.util.Random;

public class TestSort {
    public static void testArr(int[] arr) {
        long m1 = System.currentTimeMillis();
        MergeSort.mergeSort(arr);
        long m2 = System.currentTimeMillis();
        BubbleSort.bubbleSort(arr);
        long m3 = System.currentTimeMillis();

        System.out.println("Merge sort längd" + arr.length + ": " + (m2-m1) + "ms");
        System.out.println("Bubble sort längd" + arr.length + ": " + (m3-m2) + "ms");
    }

    public static void testLength(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt();

        }
        testArr(arr);

    }

    public static void main(String[] args) {
        testLength(10);
        testLength(1000);
        testLength(10000);


    }
}