import java.math.BigInteger;

/** This class representing rational numbers and it contains useful functions
 * <p> A RatNum can hold a numerator and a denominator.
  */

public class RatNum {
    private BigInteger numerator;
    private BigInteger denominator;

    /** 
     * Creates the rational number 0/1
     */
    public RatNum() {
        this.numerator = BigInteger.valueOf(0);
        this.denominator = BigInteger.valueOf(1);
    }

    /**
     * Creates the rational number a/1
     * @param a The numerator
      */
    public RatNum(int a) {
        this.numerator = BigInteger.valueOf(a);
        this.denominator = BigInteger.valueOf(1);
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
        this(BigInteger.valueOf(a), BigInteger.valueOf(b));
    }
    
    /**
     * Copies the rational number and creates a new
     * @param r The rational number
      */
    public RatNum (RatNum r) {
        this.numerator = r.numerator;
        this.denominator = r.denominator;
    }


    private RatNum (BigInteger n, BigInteger d) {
        if (d == BigInteger.valueOf(0))
            throw new NumberFormatException("Denominator = 0");

        /* int gcd = gcd(n,d); */
        BigInteger gcd = n.gcd(d);

        this.numerator = n.divide(gcd);
        this.denominator = d.divide(gcd);        
        
        if (d.compareTo(BigInteger.valueOf(0)) == -1) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }

        /*  if (d < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        } */
    }

    /**
     * A getter for the numerator
     * @return
      */
    public int getNumerator() {
        return numerator.intValue();
    }

    /**
     * A getter for the denominator
     * @return
      */
    public int getDenominator() {
        return numerator.intValue();
    }

    /**
     * Integer part extraction for rational numbers.
     * @return the integer part of this rational number
     */    
    public int intPart() {
        return this.numerator.divide(this.denominator).intValue();
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
        BigInteger newOtherRnum = (otherR.numerator.multiply(this.denominator));
        BigInteger newThisNum = (this.numerator.multiply(otherR.denominator));

        if (newThisNum.compareTo(newOtherRnum) == -1) {
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
        BigInteger num = (otherR.numerator.multiply(this.denominator)).add(this.numerator.multiply(otherR.denominator));
        BigInteger den = otherR.denominator.multiply(this.denominator);

        return new RatNum(num, den);
    }

    /**
     * Subtracts our this rational number with the other rational number
     * @param otherR The other rational number
     * @return Returns the subtracted rational number
      */
    public RatNum sub(RatNum otherR) {
        BigInteger num = (this.numerator.multiply(otherR.denominator)).subtract(otherR.numerator.multiply(this.denominator));
        BigInteger den = otherR.denominator.multiply(this.denominator);
        
        return new RatNum(num,den);
    }

    /**
     * Multiplies our this rational number with the other rational number
     * @param otherR The other rational number
     * @return Returns the multiplied rational number
      */
    public RatNum mul(RatNum otherR) {
        BigInteger den = otherR.denominator.multiply(this.denominator);
        BigInteger num = otherR.numerator.multiply(this.numerator);

        return new RatNum(num, den);
    }
    
    /**
     * Divides our this rational number with the other rational number
     * @param otherR The other rational number
     * @return Returns the divided rational number
      */
    public RatNum div(RatNum otherR) {
        BigInteger num = this.numerator.multiply(otherR.denominator);
        BigInteger den = otherR.numerator.multiply(this.denominator);

        return new RatNum(num, den);
    }

   
    
}





 /** Calculates the greatest common divisor
     * @param m First whole number
     * @param n Second whole number
     * @return Returns the greatest common divisor 
    */
   /*
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
    } */