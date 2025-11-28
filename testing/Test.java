
public class Test {
/*     public static void main(String[] args) {
        
        while(true) {
            clearScreen();

            System.out.println("Test");

        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
 */


    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            clear();
            System.out.println("Frame: " + System.currentTimeMillis());
            Thread.sleep(100);
        }
    }
}

