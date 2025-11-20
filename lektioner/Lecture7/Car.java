package Lecture7;


/** A class that represent an abstract model of a car.
 * <p> Cars have a registration number, colour, speed and current position.
 * <p> Cars can never have anegative speed, nor a speed above 240. 
 */

public class Car {
    private String regPlate;
    private String colour;
    private int speed;
    private int position;



    /** Checks if speed is less than 0 or above 240 
     * @param speed speed that shall be checked
      */
    private static void checkSpeed(int speed) {
        if (speed < 0 || speed > 240) {
            throw new IllegalArgumentException("Ogiltligt värde på hastighet " + speed);
        }
    }

    /** Creates a new black car with speed and position 0.
     * @param regPlate Registration number for the new car.
      */
    public Car(String regPlate) {
        this.colour = "black";
        this.speed = 0;
        this.position = 0;
        this.regPlate = regPlate;
    }

    public Car(String regPlate, String colour, int speed, int position) {
        checkSpeed(speed);

        this.colour = colour;
        this.speed = speed;
        this.position = position;
        this.regPlate = regPlate;
    }
    /** Presents a car as a String
     * @return a string representing this car
     */

    public String toString() {
        return "Car: [colour";

    }

    /** Sets the colour of this car
     * @param colour the new colour
     */

    public void setColour(String colour) {

    }

    /** Sets the speed of this car
     * @param speed the new speed
     * @throws error 
     */

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void drive() {

    }
}
