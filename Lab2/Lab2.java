package Lab2;

public class Lab2 {

    public static void main(String[] args) {

        // rader som denna är kommentarer

        // vi deklarar en array som heter a
        int[] a = { 21, 19, 3,  15, 53, 33, 239, 233, 14, 97,
                    9,  8,  45, 35, 73, 55, 731,  81, 51, 49 };

        // skriver ut en hälsning och sedan element 1 av array a (dvs värdet 19)
        System.out.println("Hello!");
        System.out.println(a[1]);

        // lösning för del 1
        System.out.println("Del 1:");
        for (int i = 0; i < a.length; i = i + 1) {
            System.out.println(a[i]);
        }

        // lösning för del 2
        System.out.println("Del 2:");
        int bv = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > bv)
                bv = a[i];
        }
        System.out.println(bv);

        // lösning för del 3
        System.out.println("Del 3:");
        int sumOfEven = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sumOfEven = sumOfEven + a[i];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (sumOfEven < a[i])
                System.out.println(a[i]);
        }

        // frivilligt: lösning för del 4
        System.out.println("Del 4:");
        for (int i = 0; i < a.length; i++) {
            boolean isPrime = true;
            for (int z = 2; z <= Math.sqrt(a[i]); z++) {
                if (a[i] % z == 0) {
                    isPrime = false;
                    break;
                }

            }
            if (isPrime) {
                System.out.println(a[i]);
            }
            
        }

    }

}
