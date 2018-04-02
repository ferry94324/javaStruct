package liubo.sort;

public class SelectSort {
	public static void main(String[] args) {  
        int a[] = {3,1,5,7,2,4,9,6,10,8};    
        SelectSort  obj=new SelectSort();  
        System.out.println("初始值：");  
        obj.print(a);  
        obj.selectSort(a);  
        System.out.println("\n排序后：");  
        obj.print(a);  
  
    }  
    private void selectSort(int[] a) {  
        for(int i=0;i<a.length;i++){  
            int k=i;//k存放最小值下标。每次循环最小值下标+1  
            for(int j=i+1;j<a.length;j++){//找到最小值下标  
                if(a[k]>a[j])  
                    k=j;  
            }  
            swap(a,k,i);//把最小值放到它该放的位置上  
        }  
    }  
    public void print(int a[]){  
        for(int i=0;i<a.length;i++){  
            System.out.print(a[i]+" ");  
        }  
    }  
     public  void swap(int[] data, int i, int j) {    
            if (i == j) {    
                return;    
            }  
            int temp  = data[i];
            data[i] = data[j];
            data[j] = temp;
            /*data[i] = data[i] + data[j];    
            data[j] = data[i] - data[j];    
            data[i] = data[i] - data[j]; */   
        }    
}
