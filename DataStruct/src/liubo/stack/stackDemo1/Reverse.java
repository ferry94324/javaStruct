package liubo.stack.stackDemo1;

public class Reverse {
	String input;
	
	public Reverse(String input){
		this.input = input;
	}
	
	public String doReverse(){
		Stack s = new Stack(input.length());
		for(int i =0;i<input.length();i++){
			s.push(input.charAt(i));
		}
		String output = "";
		while(!s.isEmpty()){
			output +=s.pop();
		}
		return output;
	}
}
