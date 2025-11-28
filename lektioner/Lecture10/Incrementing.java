package Lecture10;

public class Incrementing implements Talserie {
    private int current;

    public Incrementing() {
        this.current = 1;    
    }

    public int Incrementing(int current) {
        this.current = current;

        return 1;
    }

    public int next() {
        int tmp = current;
        current ++;
        return tmp;
    }
}