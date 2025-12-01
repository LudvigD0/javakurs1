public class Pi {

    public static RatNum pow(int k) { 
        return new RatNum(1, (int)Math.pow(16, k));
    }


    public static void main(String[] args) {
        int decimalCount = 70;
        if (args.length > 0) {
            decimalCount = Integer.valueOf(args[0]);
        }

        RatNum res = new RatNum(0,1);
        // ersätt följande två rader med din lösning


        for(int k = 0; k < decimalCount; k++) {
            RatNum first = new RatNum(4,8*k+1);
            RatNum second = new RatNum(2,8*k+4);
            RatNum third = new RatNum(1,8*k+5);
            RatNum fourth = new RatNum(1,8*k+6);
            res = res.add(pow(k).mul(first.sub(second).sub(third).sub(fourth)));
        }


        // kod för utskriften (behöver inte ändras)
        System.out.print("pi = ");        
        RatNum r = res;
        RatNum ten = new RatNum(10,1);
        for (int k=0; k<=decimalCount; k++) {
            int intPart = r.intPart();
            System.out.print(intPart);
            if(k==0) System.out.print(".");
            r = r.sub(new RatNum(intPart));
            r = r.mul(ten);
        }
        System.out.println("...");
    }

}
 