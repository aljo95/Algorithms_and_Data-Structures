
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;



public class Map {
    
    public City[] cities;
    private final int mod = 541;
    int collisionCount = 0;
    
    public Map(String file) {
        
        cities = new City[mod];
        
        try (BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(file), "UTF-8"))) { 
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                City c1 = lookup(row[0]);
                City c2 = lookup(row[1]);
                c1.connect(c2, Integer.valueOf(row[2]));
                c2.connect(c1, Integer.valueOf(row[2]));
            }
            System.out.println("COLLISIONS: " + collisionCount);
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt\n" + e);
        }
    }
    
    
    
    
    //if not exist -> just add
    //if already exist (hash) then check if cities[hashValue] == city (argument)
    //if same then just want to add connection
    //if not same city then its a collision, move forward in loop/array until a null spot is found and then add it :)
    
    public City lookup(String city) {
        
        Integer hashValue = hash(city);
        
        while(cities[hashValue] != null) {
            if ((cities[hashValue].name).equals(city)) {
                collisionCount++;
                return cities[hashValue];
            }
            hashValue++;
        }
        cities[hashValue] = new City(city);
        return cities[hashValue];
    }

    private Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }
}
