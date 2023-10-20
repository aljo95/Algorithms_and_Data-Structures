
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
    keys = new Integer[100000];
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
                keys[code] = code;
                /********/
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

    
    
    
    
    
    
    
    
    
    /*
    public void collisions(int mod) {
        
        System.out.println("MAX: " + max);
        
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            if (index == 1115) {
                System.out.println("HEHEHEHHE");    // THREE TIMES
            }
            cols[data[index]]++;            // cols[0]++ (om data[index] är 0 så incrementerar vi värdet i col[0])
            data[index]++;                  // vi sätter plats 11115%10000 = 1115 => data[1115] = 1 (true) den finns alltså
        }
        System.out.print("mod value:" + mod + " ->");
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);                   //AMOUNT OF COLLISIONS =/= AMOUNT IN DATA.
        }                                                       //if collides 3 times, it also collides two times (first..) xD
        
        
        System.out.println();
    }*/
    
    
    
    
        public int[][] collisionsBucket(int mod) {
            
            int[][] bucketArr = new int[mod][1];     //  mod = 20 000, lets say 10 000 easier
                                                //
            for (int i = 0; i < max+1; i++) {
                Integer index = keys[i] % mod;
                if (bucketArr[index][0] == 0) {
                    bucketArr[index][0] = keys[i];       //if nothing there then: data[1115][0] = 11115
                } else {                            //if nothing there then: data[8499][0] = 98499
                                                    //next time 21115 -> 1115(hash): we want data[1115][1] = 21115
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
    
    
        
        // BOLEAN VERSION IS THE REAL ONE
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
    
    //THIS IS JUST COUNT VERSION!
    public int lookup2(int[][] bucketArr, String zip) {
        int mod = bucketArr.length;
        int zipCode = Integer.valueOf(zip.replaceAll("\\s", ""));
        
        int hash = zipCode % mod;
        
        int count = 1;
        
        if (bucketArr[hash][0] != 0) {
            for (int i=0; i<bucketArr[hash].length; i++) {
                if (bucketArr[hash][i] == zipCode) {
                    return count;
                }
                count++;
            }
        }
        return count;
    }
    
}
