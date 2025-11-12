import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lec {
    public static void main(String[] args) {
        int[] testArr = {1,2,3};

        System.out.println(testArr.length);
        System.out.println(Arrays.toString(testArr));

        int[] newArr = new int[testArr.length];
        System.out.println(Arrays.toString(newArr));

        int[] xy = new int[2];
        System.out.println(Arrays.toString(xy));
        
        printer();
    }


    static void printer() {
        int treeHeight = 10;
        int spacing = treeHeight;
        Random rand = new Random();

        for (int i = 0; i < treeHeight; i++) {
            int rowWidth;
            if (i == 0)
                rowWidth = 1;
            else
                rowWidth = 1 + 2*(i);

            
            int randomInt = rand.nextInt(rowWidth);
            int randomInt2 = rand.nextInt(rowWidth);
            if (rowWidth != 1) {
                while (randomInt == randomInt2) {
                    randomInt2 = rand.nextInt(rowWidth);
                }
            }
            

            System.out.print(" ".repeat(spacing));
            
            for (int z = 0; z < rowWidth; z++) {
                if (randomInt == z || randomInt2 == z)
                    System.out.print("0");
                else
                    System.out.print("*");
            }
            System.out.print("\n");
        
            spacing -= 1;

        }
        System.out.println(testReturn());

    }

    private static int testReturn() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};

        System.out.println(Arrays.equals(arr1,arr2));
        System.out.println(arr1.equals(arr2));

        String str1 = "hej";
        String str2 = "hej";

        System.out.println(str1.equals(str2));

        ArrayList<String> cars = new ArrayList<>();

        cars.add("Testing");

        System.out.println("\n" + cars.get(0));




        ArrayList <String> studentNames = new ArrayList<>();

        ArrayList <Integer> testList = new ArrayList<>(Arrays.asList(1,2,3));

        

        return 3;
    }
}