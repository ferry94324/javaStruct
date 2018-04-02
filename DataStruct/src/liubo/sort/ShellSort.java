package liubo.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int r[] = {12,15,9,20,6,31,24};
		System.out.println("排序前的记录："+Arrays.toString(r));
		shellSort(r);
		System.out.println("排序后的记录："+Arrays.toString(r));
	}
	private static void shellSort(int[] a) {  
        int dk = a.length/2;   
        while( dk >= 1  ){    
           ShellInsertSort(a, dk);
           System.out.println("排序记录："+Arrays.toString(a));
           dk = dk/2;  
        }  
   } 
	public static void ShellInsertSort(int a[],int dk){
		 for(int i=dk;i<a.length;i++){
                int j;  
                int x=a[i];//x为待插入元素   
                for(j=i-dk;  j>=0 && x<a[j];j=j-dk){//通过循环，逐个后移一位找到要插入的位置。  
                    a[j+dk]=a[j];  
                }  
                a[j+dk]=x;//插入  
	          }       

	}
}
