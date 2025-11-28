package Lecture10;

public class Talserier {
    public static void main (String[] args) {
        Ones ones = new Ones();

        printN(ones, 5);

    
        System.out.println();

        Incrementing inc = new Incrementing();
        
        printN(inc, 5);
     
     
    }

    public static void printN(Talserie inter, int n)  {
        for (int i = 0; i < n; i++) {
            System.out.println(inter.next());
        }   

    }
}



