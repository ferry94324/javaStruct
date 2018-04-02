package liubo.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int r[] = {50,13,55,97,27,38,49,65};
		System.out.println("排序前的记录："+Arrays.toString(r));
		bubbleSort_a(r);
		System.out.println("排序后的记录："+Arrays.toString(r));
	}
	public static void bubbleSort_a(int a[]){
		int i = a.length-1;
		while(i>0){
			int pos= 0;
			for(int j = 0;j<i;j++){
				if(a[j]>a[j+1]){
					pos = j;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			i = pos;
			System.out.println("排序记录："+Arrays.toString(a));
		}
	}
}
