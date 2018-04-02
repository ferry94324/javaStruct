package liubo.stack.stackDemo2;

import java.util.Scanner;

public class Expression {  
    
    //运算符之间的优先级,其顺序是+、-、*、/、（、），其中大于号表示优先级高  
    //，小于号表示优先级低，等号表示优先级相同，感叹号表示没有优先关系  
    public static final char[][] relation = {{'>','>','<','<','<','>','>'},  
            {'>','>','<','<','<','>','>'},{'>','>','>','>','<','>','>'},  
            {'>','>','>','>','<','>','>'},{'<','<','<','<','<','=','!'},  
            {'>','>','>','>','!','>','>'},{'<','<','<','<','<','!','='}};  
      
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        while(true){  
        try{  
        System.out.println("请输入要计算的表达式：");  
        String exp = input.next();  
        System.out.println(calc(exp + "#"));  
        }catch(ArithmeticException e1){  
            System.out.println("表达式中的分母不能为0");  
            e1.printStackTrace();  
        }  
        }  
    }  
    /** 
     *  
     * @param exp 要计算的表达式 
     * @return 计算的结果 
     */  
    private static int calc(String exp) {  
        //操作数栈  
        Stack<Integer> num = new Stack<Integer>();  
        //操作符栈  
        Stack<Character> op = new Stack<Character>();  
          
        op.push('#');  
        int i = 0;  
        char ch = exp.charAt(i);  
        boolean flag = false;//判断连续的几个字符是否是数字，若是，就处理成一个数字。这样就能处理多位数的运算了。  
        while(ch != '#' || op.peek() != '#') {//peek()查看栈顶对象但不移除。  
            if(ch >= '0' && ch <= '9') {  
                if(flag) {  
                    int tmp = num.pop();  
                    num.push(tmp * 10 + Integer.parseInt(ch + ""));  
                } else {  
                    num.push(Integer.parseInt(ch + ""));  
                }  
                flag = true;  
                i++;  
            } else {  
                flag = false;  
                switch(precede(op.peek(), ch)) {  
                case '<':  
                    op.push(ch);  
                    i++;  
                    break;  
                case '=':  
                    op.pop();  
                    i++;  
                    break;  
                case '>':  
                    int num2 = num.pop();  
                    int num1 = num.pop();  
                    int result = operate(num1, op.pop(), num2);  
                    num.push(result);  
                    break;  
                case '!':  
                    System.out.println("输入的表达式错误！");  
                    return -1;  
                }  
            }  
            ch = exp.charAt(i);  
        }  
        return num.peek();  
    }  
    private static char precede(char peek, char ch) {  
        return relation[getIndex(peek)][getIndex(ch)];  
    }  
      
    /** 
     *  
     * @param ch 操作符 
     * @return 操作符的索引，按照+、-、*、/、（、）的顺序 
     */  
    private static int getIndex(char ch) {  
        int index = -1;  
        switch(ch) {  
        case '+':  
            index = 0;  
            break;  
        case '-':  
            index = 1;  
            break;  
        case '*':  
            index = 2;  
            break;  
        case '/':  
            index = 3;  
            break;  
        case '(':  
            index = 4;  
            break;  
        case ')':  
            index = 5;  
            break;  
        case '#':  
            index = 6;  
            break;  
        }  
        return index;  
    }  
      
    /** 
     *  
     * @param num1  第一个运算数 
     * @param ch 运算符 
     * @param num2 第二个运算数 
     * @return 运算结果 
     */  
    private static int operate(int num1, char ch, int num2) {  
        int result = 0;  
        switch(ch) {  
        case '+':  
            result = num1 + num2;  
            break;  
        case '-':  
            result = num1 - num2;  
            break;  
        case '*':  
            result = num1 * num2;  
            break;  
        case '/':  
            result = num1 / num2;  
            break;  
        }  
        return result;  
    }  
}  
