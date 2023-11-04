
public class Paths {
    
    City[] path;
    int sp;
    
    public Paths() {
        path = new City[54];
        sp = 0;
    }
    
    public Integer shortest(City from, City to) {
        
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
            return null;
        }

        path[sp++] = from;
        for (int i = 0; i < from.neighbours.length; i++) {
            if (from.neighbours[i] != null) {
                
                Connection conn = from.neighbours[i];
                
                Integer temp = shortest(conn.city, to);
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
        path[sp--] = null;
        return shrt;
    }
}
