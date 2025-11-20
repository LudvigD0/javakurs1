
/** This class representing rational numbers and it contains useful functions
 * <p> A RatNum can hold a numerator and a denominator.
  */

public class RatNum {
    private int numerator;
    private int denominator;

    /** 
     * Creates the rational number 0/1
     */
    public RatNum() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * Creates the rational number a/1
     * @param a The numerator
      */
    public RatNum(int a) {
        this.numerator = a;
        this.denominator = 1;
    }

    /**
     * Creates the rational number <b>a/b</b>
     *  <ul>
     *      <li> Checks denominator != 0
     *      <li> To simplify, the numerator and denominator is divided by their gcd
     *      <li> Negative denominator makes the rational number * -1
     *  </ul>
     *  
     * @param a The numerator
     * @param b The denominator
      */
    public RatNum (int a, int b) {
        if (b == 0)
            throw new NumberFormatException("Denominator = 0");

        int gcd = gcd(a,b);

        this.numerator = a / gcd;
        this.denominator = b / gcd;

        if (b < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }
    
    /**
     * Copies the rational number and creates a new
     * @param r The rational number
      */
    public RatNum (RatNum r) {
        this.numerator = r.numerator;
        this.denominator = r.denominator;
    }

    /**
     * A getter for the numerator
     * @return
      */
    public int getNumerator() {
        return numerator;
    }

    /**
     * A getter for the denominator
     * @return
      */
    public int getDenominator() {
        return denominator;
    }
    
    /**
     * converts the rational number to a printable string
      */
    public String toString() {
        return (numerator + "/" + denominator);
 

        //return ((int)Math.floor(this.numerator/denominator) + " " + (this.numerator % denominator) + "/" + denominator);
    }

    /** Compares this rational number with another rational number
     * @param otherR The rational number we want to compare
     * @return <i>true</i> if this rational number is equal to <i>otherR</i>, otherwise  <i>false</i>
      */
    public boolean equals(Object otherR) {
        if (otherR == null) return false;
        //if (this == otherR) return true;
        if (otherR.getClass() != this.getClass()) return false;
        RatNum rat = (RatNum) otherR;   

        return rat.numerator == this.numerator && rat.denominator == this.denominator;
    }

    /**
     * Checks if our this rational number is smaller than the other rational number
     * @param otherR The rational number we want to check
     * @return Returns true or false
      */
    public boolean lessThan(RatNum otherR) {
        int newOtherRnum = (otherR.numerator * this.denominator);
        int newThisNum = (this.numerator * otherR.denominator);

        if (newThisNum < newOtherRnum) {
            return true;
        }

        return false;
    }

    /**
     * Adds our this rational number with the other rational number
     * @param otherR The other rational number
     * @return Returns the added rational number
      */
    public RatNum add(RatNum otherR) {
        int num = (otherR.numerator * this.denominator) + (this.numerator * otherR.denominator);
        int den = otherR.denominator * this.denominator;

        return new RatNum(num, den);
    }

    /**
     * Subtracts our this rational number with the other rational number
     * @param otherR The other rational number
     * @return Returns the subtracted rational number
      */
    public RatNum sub(RatNum otherR) {
        int num = (this.numerator * otherR.denominator) - (otherR.numerator * this.denominator);
        int den = otherR.denominator * this.denominator;
        
        return new RatNum(num,den);
    }

    /**
     * Multiplies our this rational number with the other rational number
     * @param otherR The other rational number
     * @return Returns the multiplied rational number
      */
    public RatNum mul(RatNum otherR) {
        int den = otherR.denominator * this.denominator;
        int num = otherR.numerator * this.numerator;

        return new RatNum(num, den);
    }
    
    /**
     * Divides our this rational number with the other rational number
     * @param otherR The other rational number
     * @return Returns the divided rational number
      */
    public RatNum div(RatNum otherR) {
        int num = this.numerator * otherR.denominator;
        int den = otherR.numerator * this.denominator;

        return new RatNum(num, den);
    }

   
    /** Calculates the greatest common divisor
     * @param m First whole number
     * @param n Second whole number
     * @return Returns the greatest common divisor 
    */
    public static int gcd(int m, int n) {
        if (m == 0 && n == 0) {
            throw new IllegalArgumentException("Both numbers can't be 0");
        }

        int posM = Math.abs(m);
        int posN = Math.abs(n);
        
        int bv = Math.max(posM, posN);
        
        for (int i = bv; i > 0; i -= 1) {
            if (posM % i == 0 && posN % i == 0) {
                return i;
            }
        }
        
        return 1;
    }
}
