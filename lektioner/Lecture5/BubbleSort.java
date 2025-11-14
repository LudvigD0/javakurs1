package Lecture5;


import java.util.Arrays;

public class BubbleSort {
    /** Sorts an array in ascending order.
     * @param arr a non-null array to be sorted
     * 
      */

    public static void bubbleSort(int[] arr) {

        System.out.println(Arrays.toString(arr));

        for (int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped = true;
                }
            }
            if(!swapped)
                return;
        }
        
    }

    public static void main(String[] args) {
        int[] testArr = {1,2,3,4};

        bubbleSort(testArr);
    }
}
