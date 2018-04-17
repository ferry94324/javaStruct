package liubo.jianzhiOffer.NumberOf1;

import java.util.Arrays;

public class NumberOf1 {
	/**
	 * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
	 * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
	 * 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。
	 * 减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
	 * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
	 * 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
	 * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf1(int n){
		int count = 0;
		while(n!=0){
			count++;
			n = n&(n-1);
			System.out.println(n);
		}
		
		return count;
	}
	/**
	 * 下面这种方法就是把十进制的数转化为二进制的数组，用ch存放。然后逐一读取看为1的个数。
	 * @param n
	 * @return
	 */
	public static int NumberOf1_2(int n){
		int count = 0;
		char ch[] = Integer.toBinaryString(n).toCharArray();
		for(int i =0;i<ch.length;i++){
			if(ch[i]=='1'){
				count++;
			}
		}
		System.out.println("ch[]:="+Arrays.toString(ch));
		return count;
	}
	public static void main(String[] args) {
		int n = NumberOf1(15);
		int m = NumberOf1_2(15);
		System.out.println("The NumberOf1_2 resulut Count is :"+m);
		System.out.println("------------>"+n);
	}
}
