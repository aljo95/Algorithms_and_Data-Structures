public class PowXN {
    public static void main(String[] args) {
        System.out.println(pow(2.00000, 10));   // = 1024
        System.out.println(pow(2.10000, 3));    // = 9.26100?
        System.out.println(pow(2.00000, -2));   // = 0.25
    }

    public static double pow(double x,int n) {
        /*
            PREVIOUS SOLUTION

        if (n == 0) return 1;
        if (n < 0) return 1/x * pow(1/x, -(n+1));

        if (n%2 == 0) return pow(x*x, n/2); //1: 2->4   10->5
        else return x*pow(x*x, n/2);        //2: 4*(16, 2)
    }                                       //16, 2 -> 256, 1 -> 
                                            //4*256 (256*256, 0)->
                                            //4*256 (1) => 4*256=1024
                                        //double check decimal tests
    */    

/*            NEW SOLUTION              */

        double result = 1;

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        while(n != 0) {
            if(n%2 != 0) result *= x;   // if n is uneven

            n >>>= 1;   // same as n=n/2 but more secure way
            x *= x;
        }                   //   x=2.00000, n=10
                            //1: n=5, x=4
                            //2: result = 4
                            //   n=2, x=16
                            //3: n=1, x=256
                            //4: result = 4*256 = 1024   
                            //   n=0 -> LOOP ENDING
                            // Returning result = 1024
        return result;
    }
}