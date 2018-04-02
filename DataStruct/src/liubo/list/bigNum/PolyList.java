package liubo.list.bigNum;

public class PolyList {  
    
    PolyNode head;  
    PolyNode current;  
      
    public PolyList(){  
          
        head=new PolyNode();  
        current=head;  
        head.next=null;  
    }  
      
    //是否为空  
    public boolean isEmpty(){  
          
        return head.next==null;  
    }  
    //这里只考虑按顺序插入元素  
    public void insert(PolyNode node){  
          
        current.next=node;  
        current=node;  
    }  
    //打印多项式  
    public String printS(){  
          
        StringBuilder s=new StringBuilder("");  
        StringBuilder a=new StringBuilder("");  
        StringBuilder i=new StringBuilder("");  
        StringBuilder theOne=new StringBuilder("");  
          
         current=head.next;  
         while(current!=null){  
               
             a.delete(0, a.length());  
             i.delete(0, i.length());  
             theOne.delete(0, theOne.length());  
               
                 if(current.getA()==1)  
                     a.append("");  
                 else  
                     a.append(String.valueOf(current.getA()));  
                   
                 if(current.getI()==1)  
                 {  
                     i.append("");  
                     theOne.append(a.toString()).append("x").append(i.toString());  
                 } else{  
                       
                     i.append(String.valueOf(current.getI()));  
                     theOne.append(a.toString()).append("x^").append(i.toString());  
                 }  
                       
               
            if(current==head.next)  
                 s.append(theOne.toString());  
            else  
                s.append("+").append(theOne.toString());  
                  
             current=current.next;  
         }  
         return s.toString();  
    }  
      
    //加法运算  
    public static PolyList add(PolyList p1,PolyList p2){  
          
         PolyList result=new PolyList();  
         //分别指向p1 p2的第一个元素  
         p1.current=p1.head.next;  
         p2.current=p2.head.next;  
         while(p1.current!=null && p2.current!=null){  
               
              if(p1.current.getI()==p2.current.getI()){  
                    
                   
                  result.insert(new PolyNode(p1.current.getA()+p2.current.getA(),p1.current.getI()));  
                  p1.current=p1.current.next;  
                  p2.current=p2.current.next;  
              }  
              else if(p1.current.getI()<p2.current.getI()){  
                    
                  result.insert(p1.current);  
                  p1.current=p1.current.next;  
                    
              }else{  
                  result.insert(p2.current);  
                  p2.current=p2.current.next;  
              }  
         }  
         while(p1.current!=null){  
               
              result.insert(p1.current);  
              p1.current=p1.current.next;  
         }  
         while(p2.current!=null){  
               
              result.insert(p2.current);  
              p2.current=p2.current.next;  
         }  
         return result;  
           
    }  
    //乘法运算  
    public static PolyList multiply(PolyList p1,PolyList p2){  
          
         PolyList result=new PolyList();  
         //分别指向p1 p2的第一个元素  
         p1.current=p1.head.next;  
         p2.current=p2.head.next;  
         while(p1.current!=null){  
               
               while(p2.current!=null)  
               {  
                   int a=p1.current.getA()*p2.current.getA();  
                   int i=p1.current.getI()+p2.current.getI();  
                   result.insert(new PolyNode(a,i));  
                   p2.current=p2.current.next;  
               }  
               p1.current=p1.current.next;  
               p2.current=p2.head.next;  
         }  
         //合并同类项  
         result.current=result.head.next;  
         PolyNode tempPrevious=result.current;  
         PolyNode temp=result.current.next;  
         while(result.current.next!=null){  
               
             while(temp!=null)  
             {  
                 if(temp.getI()!=result.current.getI())  
                 {  
                     temp=temp.next;  
                     tempPrevious=tempPrevious.next;  
                 }else{  
                     result.current.setA(result.current.getA()+temp.getA());  
                     tempPrevious.next=temp.next;  
                     temp=temp.next;  
                 }  
                       
             }  
             result.current=result.current.next;  
             tempPrevious=result.current;  
             temp=result.current.next;  
         }         
         return result;  
    }  
  
}  
