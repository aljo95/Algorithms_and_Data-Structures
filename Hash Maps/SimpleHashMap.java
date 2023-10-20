
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class Zip {
    
    Node[] data;
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
    data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        //try (BufferedReader br = new BufferedReader(new FileReader(file , StandardCharsets.UTF_8))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //zip is just number, ex: 111 15, but its in a string!
    public String linearLookup(String zip) {
        Integer zipNumber = Integer.parseInt(zip.replaceAll("\\s",""));
        Integer i=0;
        while(data[i] != null) {
            if (Objects.equals(data[i].code, zipNumber)) {
                return "Zip exists at line " + (i+1);
            }
            i++;
        }
        return "No zip matching the search query was found";
    }
    
    //same but with binary search
    public String binaryLookup(String zip) {
        Integer zipNumber = Integer.parseInt(zip.replaceAll("\\s",""));
        Integer min = 0;
        Integer maxx;
        maxx = data.length - 1;
        while (true) {
            int mid = (min + maxx) / 2;
            
            if (data[mid] == null) {
                maxx = mid - 1;
                continue;
            }
                
            if (Objects.equals(data[mid].code, zipNumber)) {
                return "Found at lines " + (mid+1);
            }
            
            if ((data[mid].code > zipNumber) & (mid > min))
                maxx = mid - 1;
            else if ((data[mid].code < zipNumber) & (mid < maxx))
                min = mid + 1;
            else return "No zip matching the search query was found";
        }
    }
    
    

}
