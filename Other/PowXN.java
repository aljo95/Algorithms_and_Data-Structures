public class PowXN {
    public static void main(String[] args) {
        System.out.println(pow(2.00000, 10));   // = 1024
        System.out.println(pow(2.10000, 3));    // = 9.26100?
        System.out.println(pow(2.00000, -2));   // = 0.25
    }

    public static double pow(double x,int n) {
        if (n == 0) return 1;
        if (n < 0) return 1/x * pow(1/x, -(n+1));

        if (n%2 == 0) return pow(x*x, n/2); //1: 2->4   10->5
        else return x*pow(x*x, n/2);        //2: 4*(16, 2)
    }                                       //16, 2 -> 256, 1 -> 
                                            //4*256 (256*256, 0)->
                                            //4*256 (1) => 4*256=1024
}           //double check decimal tests