package liubo.list.array;import java.lang.reflect.Array;
import java.util.Arrays;

public class Converse {
	public static void Reverse(int A[],int form,int to){
		System.out.println(Arrays.toString(A));
		
		for(int i = 0;i<(to-form+1)/2;i++){
			int temp =A[form+i];
			A[form+i] = A[to-i];
			A[to-i] = temp;	
		}
	}
	public static void ConverseArray(int A[],int n,int k){
		Reverse(A, 0, k-1);
		System.out.println(Arrays.toString(A));
		Reverse(A, k, n-1);
		Reverse(A, 0, n-1);
	}
	public static void main(String[] args) {
		int A[] ={1,2,3,4,5,6,7,8,9,10,11,12}; 
		ConverseArray(A,A.length,4);
		System.out.println("结果是："+Arrays.toString(A));
	}
}
