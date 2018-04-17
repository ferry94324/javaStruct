package liubo.jianzhiOffer.AdjustNumber;

import java.util.Arrays;

public class AdjustNumber {
	/**
	 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
	 * 2.i从左向右遍历，找到第一个偶数。
	 * 3.j从i+1开始向后找，直到找到第一个奇数。
	 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
	 * 5.終止條件：j向後遍歷查找失敗。
	 */
	public static void reOrderArray(int [] a){
		if(a==null||a.length==0)
	        return;
	    int i = 0,j;
	    while(i<a.length){
	    	System.out.println("每次i的值是："+i);
	        while(i<a.length&&!isEven(a[i])){
	            i++;
	            System.out.println("i的值是："+i);
	        }
	        j = i+1;
	        System.out.println("初始j的值是："+j);
	        System.out.println("当前a[j]的值是 ："+a[j]);
	        while(j<a.length&&isEven(a[j])){
	        	 j++;
	        	 System.out.println("找到奇数时候j的值："+j);
	        }
	        if(j<a.length){
	            int tmp = a[j];
	            System.out.println("tmp的值是："+tmp);
	            for (int j2 = j-1; j2 >=i; j2--) {
	                a[j2+1] = a[j2];
	            }
	            a[i++] = tmp;
	            System.out.println("array 的值："+Arrays.toString(a));
	        }else{// 查找失敗
	            break;
	        }
	    }
	}
	static boolean isEven(int n){
	    if(n%2==0)
	        return true;
	    return false;
	}
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5};
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
