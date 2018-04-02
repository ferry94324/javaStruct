package liubo.array;

import java.util.HashMap;

public class ArrayRepeat {
	/*时间复杂度o(n),空间复杂度o(n)*/  
    public static boolean duplicate(int numbers[], int length, int[] duplication) {  
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
        int flag = 0;  
        for (int i = 0; i < length; i++) {  
            if (numbers[i] > length) {  
                flag = 1;  
                break;  
            }  
            if (map.containsKey(numbers[i])) {  
                duplication[0] = numbers[i];  
                break;  
            } else  
                map.put(numbers[i], 1);  
        }  
        if (flag == 0 && duplication[0] >=0)  
            return true;  
        else  
            return false;  
  
    }  
    /*时间复杂度o(n),空间复杂度o(1)*/  
    public static boolean duplicate1(int numbers[], int length, int[] duplication) {  
        if(numbers == null || length < 0)  
            return false;  
        for(int i = 0; i < length; i ++)  
        {  
            if(numbers[i] < 0 || numbers[i] > length -1)  
                return false;  
        }  
        for(int i = 0; i < length; i++)  
            while(numbers[i] != i){  
                if(numbers[i]==numbers[numbers[i]]){  
                    duplication[0] = numbers[i];  
                    return true;  
                }  
                int temp = numbers[i];  
                numbers[i] = numbers[temp];  
                numbers[temp] = temp;  
            }     
        return false;     
    }  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        int[] num = { 2, 3, 1, 0, 3, 5, 7};  
        int[] duplication = new int[1];  
        duplication[0] = -1;  
        System.out.println(duplicate1(num,num.length,duplication));  
          
    }
}
