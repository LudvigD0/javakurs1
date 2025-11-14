package Lecture4;

import java.util.ArrayList;
import java.util.Arrays;


public class Lec4 {
    public static void main(String[] args) {
        System.out.println(max(3,4));
        int[] intArray = {1,2,3};
        System.out.println(Test.findIndex(intArray, 2));


        final int[] finalArr = {4,6,2,5,8,5,2};
        
        ArrayList<String> testArr = new ArrayList<>();

        
        for (int i = 0; i < finalArr.length; i++) {
            testArr.add(String.valueOf((int)Math.pow(finalArr[i], 2)));
            System.out.println(Math.min(finalArr[i], finalArr[i == finalArr[finalArr.length-2] ? i : i+1]));
        }
        
        System.out.println(testArr);
        System.out.println(Arrays.toString(finalArr));
    }
    public static int max(int x, int y) {
        if(x > y)
            return x;
        return y;

    }
}


class Test {
    public static int findIndex(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) 
              return i;
        }
        return -1;
    }

}