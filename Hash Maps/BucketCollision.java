
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
    keys = new Integer[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                keys[code] = code;
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    
    public Boolean lookupC(String zip)  {
        int zipNumber = Integer.parseInt(zip.replaceAll("\\s",""));
        return zipNumber >= 0 && zipNumber < 100000 && keys[zipNumber] != null;
    }
    
    public int[][] collisionsBucket(int mod) {
            
        int[][] bucketArr = new int[mod][1];

        for (int i = 0; i < max+1; i++) {
            Integer index = keys[i] % mod;
            if (bucketArr[index][0] == 0) {
                bucketArr[index][0] = keys[i];
            } else {                           
                                                   
                int[] newArr = new int[bucketArr[index].length + 1];
                for (int j=0; j<bucketArr[index].length; j++) {
                    newArr[j] = bucketArr[index][j];
                }
                newArr[newArr.length-1] = keys[i];
                bucketArr[index] = newArr;
                    
            }
        }
        return bucketArr;
    }
    
    public Boolean lookup(int[][] bucketArr, String zip) {
        int mod = bucketArr.length;
        int zipCode = Integer.valueOf(zip.replaceAll("\\s", ""));
        int hash = zipCode % mod;
        
        if (bucketArr[hash][0] != 0) {
            for (int i=0; i<bucketArr[hash].length; i++) {
                if (bucketArr[hash][i] == zipCode) {
                    return true;
                }
            }
        }
        return false;
    }
}
