package Lecture5;

public class BinarySearch {
    /** Find the position of an element in a sorted array.
     * @param arr a non-null array, sorted inascending order
     * @param x element to search for
     * @return a position at which x occurs i arr if it does, 
     * otherwise -1
    */
    public static int binarySearch(int[] arr, int x) {
        /* Vi tittar alltid på ett intervall i arrayen.
        Tänk igenom: på vilken sida är intervallet öppet resp stängt.
         */

        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low+high)/2;
            if(arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,5,7,9};
        //Om alla utskrifter blev true så funkade testerna korrekt
        System.out.println(binarySearch(arr,0) == -1);
        System.out.println(binarySearch(arr,1) == 0);
        System.out.println(binarySearch(arr,2) == -1);
        System.out.println(binarySearch(arr,3) == 1);
        System.out.println(binarySearch(arr,4) == -1);
        System.out.println(binarySearch(arr,5) == 2);
        System.out.println(binarySearch(arr,6) == -1);
        System.out.println(binarySearch(arr,7) == 3);
        System.out.println(binarySearch(arr,8) == -1);
        System.out.println(binarySearch(arr,9) == 4);
        System.out.println(binarySearch(arr,0) == -1);


    }

}
