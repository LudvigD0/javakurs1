package other.ClassesAndObjects;



public class Pokemon {
    
    String name;
    int level;
    
    Pokemon() {
        level = 1;
    }

    Pokemon(String pName, int pLevel) {
        this.name = name;
        this.level = level;
       
    }

    void attack() {
        System.out.println(name + "attack!");
    }
}
