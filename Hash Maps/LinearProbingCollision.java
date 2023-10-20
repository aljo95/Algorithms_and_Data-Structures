
import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    
    Node[] data;
    Integer[] keys;
    int max;
    
    public class Node {
        Integer code;
        String name;
        Integer pop;
        
        public Node(Integer c, String n, Integer p) {
            this.code = c;
            this.name = n;
            this.pop = p;
        }
        
    }
    public Zip(String file) {
    data = new Node[100000];
    /********/
    keys = new Integer[10000];
    /********/
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        //try (BufferedReader br = new BufferedReader(new FileReader(file , StandardCharsets.UTF_8))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                /********/
                keys[i++] = code;
                /********/
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    
    
    
    
    
    
    
    
    
    /*
    public Boolean lookup(String zip)  {
        int zipNumber = Integer.parseInt(zip.replaceAll("\\s",""));
        return zipNumber >= 0 && zipNumber < 100000 && data[zipNumber] != null;
    }*/
    
    
        
        // CHANGE INTEGER > BOOLEAN XD
    public int lookup(int[] dataArr, String zip) {
        int mod = dataArr.length;
        int zipCode = Integer.valueOf(zip.replaceAll("\\s", ""));
        int hash = zipCode % mod;
        
        int count = 1;
        
        while (dataArr[hash] != 0) {
            if (dataArr[hash] == zipCode) 
                return count; //return true;
            hash++;
            count++;
        }
        
        return count; //return false;
    }
    
    
    
    
    public int[] collisions(int mod) {  //mod = 20 000
        
        System.out.println("MAX: " + max);
        
        int[] data = new int[mod];
        
        for (int i = 0; i < max+1; i++) {
            int hash = keys[i] % mod;
            
            if (data[hash] == 0) {
                data[hash] = keys[i];
            } else {
                while (data[hash] != 0) {
                    hash++;
                }
                data[hash] = keys[i];
            }
        }
        
        return data;
    }
    
    
    
}
