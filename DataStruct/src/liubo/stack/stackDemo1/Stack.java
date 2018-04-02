package liubo.stack.stackDemo1;

public class Stack {
	private int maxSize;
	private int top;
	private Object[] arr;
	public Stack(int size) {
		maxSize = size;
		top = -1;
		arr = new Object[maxSize];
	}
	//压栈
	public void push(Object value){
		arr[++top] = value;
	}
	//出栈
	public Object pop(){
		return arr[top--];
	}
	//访问栈顶元素
	public Object peek(){
		return arr[top];
	}
	//判断是否栈满
	public boolean isFull(){
		return maxSize-1 == top;
	}
	//判断栈是否为空
	public boolean isEmpty(){
		return top == -1;
	}
	
}
