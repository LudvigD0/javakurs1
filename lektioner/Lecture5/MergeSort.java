package Lecture5;

import java.util.Arrays;

public class MergeSort {
    /** Sorts the elements of arr in ascending order. 
     * @param arr a non-null array to be sorted
     * @return a copy of arr that contains the same elements in ascending order
    */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) 
            return arr.clone();

        int mid = arr.length/2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
        int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);

        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        return merge(arr1, arr2);


    }
    
    /** Merges two sorted arrays, maintaining sortedness
     * @param arr1 a non-null sorted array
     * @param arr2 another non-null sorted array
     * @return a sorted array containing all elements from arr1 and arr2
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;

        int[] arr3 = new int[arr1.length + arr2.length];

        while (i + j < arr3.length) {
            if (i >= arr1.length) { //vi har plockat färdigt från arr1
                arr3[i+j] = arr2[j];
                j++;
            } else if (j >= arr2.length) { //vi har plockat färdigt från arr1
                arr3[i+j] = arr1[i];
                j++;
            } else if(arr1[i] < arr2[j]) {
                arr2[i+j] = arr1[i];
                i++;
            } else {
                arr3[i+j] = arr2[j];
                j++;
            }
        }
        return arr3;
    }
}