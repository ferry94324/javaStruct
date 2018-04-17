package liubo.jianzhiOffer.fibonacc;

public class Fibonacc {
	public static int Fibonacci(int n) {
		int a = 0;
		int b = 1;
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = a + b;
			a = b;
			b = result;
		}
		return result;
	}
	public static int Fibonacci2(int n) {
		if(n==1||n==2){
			return 1;
		}else{
			return Fibonacci2(n-1)+Fibonacci2(n-2);
		}
	}
	public static void main(String[] args) {
		
		System.out.println(Fibonacci2(10));
	}
}
