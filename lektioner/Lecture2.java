

public class Lecture2 {
    public static void main(String[] args) { // 
        int x = Testing();
        System.out.println(x);
        //System.out.println(args[0]);

        Testingg();
    }

    public static int Testing() {
        int a = 5;
        System.out.println("test");
        return (a+a);
    }
    
    public static void Testingg() {
        int i = 0;
        while (i < 0) {
            System.out.println(" :)");
            i = i + 1;
        };
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hej jag heter " + name + " och jag är " + age + " år gammal");
    }

    public void haveBirthday() {
        age++;
        System.out.println(name + " fyllde år! Ny ålder: " + age);
    }
}