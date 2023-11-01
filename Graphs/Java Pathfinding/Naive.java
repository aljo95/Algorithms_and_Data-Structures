
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;



public class Naive {

    private static Integer shortest(City from, City to, Integer max) {
        
        if (max < 0) return null;
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        
        for (int i = 0; i < from.neighbours.length; i++) {
            if (from.neighbours[i] != null) {
                Connection conn = from.neighbours[i];
                
                Integer temp = shortest(conn.city, to, max-conn.distance);
                if (temp != null) {
                    Integer shorter = conn.distance;
                    if (temp > 0) {
                        shorter += temp;
                    }
                    if (shrt == null || shrt > shorter) {
                        shrt = shorter;
                    } 
                }
            }
        }
        return shrt;
    }
    
    // Benchmarks
    public static void main(String[] args) throws UnsupportedEncodingException {
        
        System.setOut(new PrintStream(System.out, true, "UTF8"));
        
        Map map = new Map("src/trains.csv");
        
        //String from = args[0];
        //String to = args[1];
        Integer max = 800;
        
        System.out.println("from: " + from + " to: " + to + " and max is: " + max);
        

        
	/* Benchmark 1. Naive version */
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
        


        /* Benchmark 2. Paths version */
        Integer dist = 0;
        double result = 0;
        for (int i=0; i<100; i++) {
            Paths paths = new Paths();
            t0 = System.nanoTime();
            dist = paths.shortest(map.lookup(from), map.lookup(to));
            time = (System.nanoTime() - t0)/1_000_000;
            result += time;
            //System.out.println("shortest: " + dist + " min (" + time + " ms)");
        }
        result = (result/100);
        System.out.println("Path distance: " + dist);
        System.out.println("TIME IS: " + result);
        

        
	/* Benchmark 3. PathsMax version */
        dist = 0;
        result = 0;
        for (int i=0; i<1; i++) {
            
            PathsMax paths = new PathsMax();
            t0 = System.nanoTime();
            dist = paths.shortest(map.lookup(from), map.lookup(to));
            time = (System.nanoTime() - t0)/1_000_000;
            result += time;
            //System.out.println("shortest: " + dist + " min (" + time + " ms)");
        
        }
        result = (result/1);
        System.out.println("Path distance: " + dist);
        System.out.println("TIME IS: " + result);
    }
}
