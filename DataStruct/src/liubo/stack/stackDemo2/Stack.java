package liubo.stack.stackDemo2;

public class Stack<T> {
	public class Node{
		public T data;
		public Node next;
		public Node(){}  
		public Node(T data,Node next){  
            this.data = data;  
            this.next = next;  
        } 
	}
	public Node top = new Node();  
    public int size;  
    public Node oldNode;  
      
    //入栈  
    public void push(T element){  
        top = new Node(element,top);  
        size++;  
    }  
      
    //出栈  
    public T pop(){  
        oldNode = top;  
        top = top.next;  
        //oldNode = null;  
        size--;  
        return oldNode.data;  
    }  
      
    //返回栈顶对象的数据域，但不出栈  
    public T peek(){  
        return top.data;  
    }  
      
    //栈长  
    public int length(){  
        return size;  
    }  
      
    //判断栈是否为空  
    public boolean isEmpty(){  
        return size == 0;  
    }  
  
}  

