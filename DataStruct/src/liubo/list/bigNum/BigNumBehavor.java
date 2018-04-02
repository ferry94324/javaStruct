package liubo.list.bigNum;

import java.util.Scanner;

public class BigNumBehavor {
	public static String bigNumAdd(String first,String second){
		//翻转存储
		char []a = new StringBuffer(first).reverse().toString().toCharArray();
		char []b = new StringBuffer(second).reverse().toString().toCharArray();
		for(char m :a){
			System.out.println("a:"+m);
		}
		//获取两个大数的长度
		int lenA = a.length;
		int lenB = b.length;
		//得到这两个数较长的那一个
		int len = lenA>lenB ? lenA : lenB;
		//得到的结果可能会有进位，所以要加1
		int result[] = new int[len+1];
		for(int i=0;i<result.length;i++){
			//将短的 那个数用0补齐，长度跟长的一样。
			int aint = i<lenA?a[i]-'0':0;
			int bint = i<lenB?b[i]-'0':0;
			result[i] = aint+bint;
		}
		//计算进位，若第i结果是大于十的就往前进一位。
		for(int i =0;i<result.length;i++){
			if(result[i]>10){
				result[i+1]+=result[i]/10;
				result[i]%=10;
			}
		}
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		for(int i = len;i>=0;i--){
			if(result[i]==0&&flag){
				continue;
			}else{
				flag = false;
			}
			sb.append(result[i]);
		}
		return sb.toString();
	}
	public static String bigNumberSimpleMulti(String first,String second){
		//判断符号，确定相乘后的符号是什么。
		char signA = first.charAt(0);
		char signB = second.charAt(0);
		char sign = '+';
		if(signA=='+'||signA =='-'){
			sign = signA;
			first = first.substring(1);
		}
		if(signB == '+'||signB =='-'){
			if(sign==signB){
				sign='+';
			}else{
				sign='-';
			}
			second = second.substring(1);
		}
		//翻转存储
		char []a = new StringBuffer(first).reverse().toString().toCharArray();
		char []b = new StringBuffer(second).reverse().toString().toCharArray();
		//获取两个大数的长度
		int lenA = a.length;
		int lenB = b.length;
		//相乘之后长度不应该超过两个数长度之和
		int len = lenA+lenB;
		int result[] = new int[len];
		//计算结果集合
		for(int i =0;i<lenA;i++){
			for(int j = 0;j<lenB;j++){
				result[i+j] += (int)(a[i]-'0')*(int)(b[j]-'0');
				System.out.println("result["+i+"+"+j+"]="+result[i+j]);
			}
		}
		//计算进位，若第i结果是大于十的就往前进一位。
		for(int i =0;i<result.length;i++){
			if(result[i]>10){
				result[i+1]+=result[i]/10;
				result[i]%=10;
			}
		}
		//去掉头为0
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		for(int i = len-1;i>=0;i--){
			if(result[i]==0&&flag){
				continue;
			}else{
				flag = false;
			}
			sb.append(result[i]);
		}
		if (!sb.toString().equals("")) {  
			if (sign == '-') {  
				sb.insert(0, sign);  
	          }  
	        } else {  
	            sb.append(0);  
	        }
		return sb.toString();
	}
	public static String bigNumSub(String first,String second){
		 char[] a = new StringBuffer(first).reverse().toString().toCharArray();  
	        char[] b = new StringBuffer(second).reverse().toString().toCharArray();  
	        int lenA = a.length;  
	        int lenB = b.length;  
	        // 找到最大长度  
	        int len = lenA > lenB ? lenA : lenB;  
	        int[] result = new int[len];  
	        // 表示结果的正负  
	        char sign = '+';  
	        // 判断最终结果的正负  
	        if (lenA < lenB) {  
	            sign = '-';  
	        } else if (lenA == lenB) {  
	            int i = lenA - 1;  
	            while (i > 0 && a[i] == b[i]) {  
	                i--;  
	            }  
	            if (a[i] < b[i]) {  
	                sign = '-';  
	            }  
	        }  
	        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a  
	        for (int i = 0; i < len; i++) {  
	            int aint = i < lenA ? (a[i] - '0') : 0;  
	            int bint = i < lenB ? (b[i] - '0') : 0;  
	            if (sign == '+') {  
	                result[i] = aint - bint;  
	            } else {  
	                result[i] = bint - aint;  
	            }  
	        }  
	        // 如果结果集合中的某一位小于零，那么就向前一位借一，然后将本位加上10。其实就相当于借位做减法  
	        for (int i = 0; i < result.length - 1; i++) {  
	            if (result[i] < 0) {  
	                result[i + 1] -= 1;  
	                result[i] += 10;  
	            }  
	        }  
	        StringBuffer sb = new StringBuffer();  
	        // 如果最终结果为负值，就将负号放在最前面，正号则不需要  
	        if (sign == '-') {  
	            sb.append('-');  
	        }  
	        // 判断是否有前置0  
	        boolean flag = true;  
	        for (int i = len - 1; i >= 0; i--) {  
	            if (result[i] == 0 && flag) {  
	                continue;  
	            } else {  
	                flag = false;  
	            }  
	            sb.append(result[i]);  
	        }  
	        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0  
	        if (sb.toString().equals("")) {  
	            sb.append("0");  
	        }  
	        return sb.toString();  
	}
	public static void main(String[] args) {
		
		while(true){
			System.out.println("请输入两个大数：");
			Scanner sc = new Scanner(System.in);
			String first = sc.next();
			String second = sc.next();
			System.out.println("请选择运算符号：");
			String sign = sc.next();
			
			switch (sign) {
			case "+":
				String sb1 = bigNumAdd(first, second);
				System.out.println(first+"+"+second+"="+sb1);
				break;
			case "-":
				String sb2 = bigNumSub(first, second);
				System.out.println(first+"-"+second+"="+sb2);
				break;
			case "*":
				String sb3 = bigNumberSimpleMulti(first, second);
				System.out.println(first+"*"+second+"="+sb3);
				break;
			default:
				break;
			}
			System.out.println("是否选择继续【Y/N】");
			String p = sc.next();
			System.out.println(p.equals("N"));
			if(p.equals("N")){
				System.out.println("退出运算");
				break;
			}
		}
	}
}
