

public class City {
    
    String name ;
    
    //hashed name
    
    int p = 0;
    Connection [] neighbours ;
    
    
    public City(String name) {
        this.name = name;
        this.neighbours = new Connection[1];
    }
    
    
    
    
    public void connect(City nxt, int dst) {
        
        if (this.p > 0) {
            Connection[] tempArr = new Connection[p+1];
            
            for (int i=0; i<this.neighbours.length; i++) {
                tempArr[i] = this.neighbours[i];
            }
            
            this.neighbours = new Connection[p+1];
            
            for (int i=0; i<this.neighbours.length; i++) {
                if (tempArr[i] != null) {
                    this.neighbours[i] = tempArr[i];
                }
            }
        }
        
        
        
        this.neighbours[p] = new Connection(nxt, dst);
        this.p++;
        
        
        //this.neighbours[this.neighbours.length-1] = new Connection(nxt, dst);
    }
    
}
