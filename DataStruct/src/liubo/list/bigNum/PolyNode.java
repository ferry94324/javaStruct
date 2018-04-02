package liubo.list.bigNum;

public class PolyNode {
	private int a;  
    private int i;  
    PolyNode next;  
      
    public PolyNode(int a,int i){  
          
         this.a=a;  
         this.i=i;  
         this.next=null;  
    }  
    public PolyNode(){  
          
        this(0,0);  
    }  
    public int getA() {  
        return a;  
    }  
    public int getI() {  
        return i;  
    }  
    public void setA(int a) {  
        this.a = a;  
    }  
    public void setI(int i) {  
        this.i = i;  
    }  
}
