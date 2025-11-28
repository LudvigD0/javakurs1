import java.util.ArrayList;

public class HandleTasks {
    public ArrayList<Object> list = new ArrayList<>(); 

    public static void handleTasks() {

        boolean runningTasks = true;
        while (runningTasks) {
            System.out.println();
            System.out.println("Vad vill du göra?");
        }



       

    }

    public void listTasks() {

    }

    public void addTask(String task) {
        list.add({task});
    }

    public void deleteTask() {

    }
}
