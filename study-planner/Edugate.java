import java.util.Scanner;

public class Edugate {
    public static void main(String[] args) {
        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        while (running) {
            printMenu();

            String choice = scanner.nextLine();
            

            switch (choice) {
                case "1" -> Tasks.handleTasks();
            }

        }
        
        
        
    }
    
    public static void printMenu() {
        System.out.println("Välkommen till Edugate!");
        System.out.println("Vad för tjänst vill du använda?");
    }
}

