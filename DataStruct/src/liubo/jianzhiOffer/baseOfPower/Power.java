package liubo.jianzhiOffer.baseOfPower;

public class Power {
	public static double Solution(double base, int exponent){
		double count = 1;
		if(exponent>0){
			for(int i =0;i<exponent;i++){
				count =count*base;
				if(count>Double.MAX_VALUE){
					System.out.println("结果超出double的最大范围");
					return -1;
				}
			}
			return count;
		}else if(exponent<0){
			exponent = -exponent;
			for(int i =0;i<exponent;i++){
				count = count*base;
				if(count>Double.MAX_VALUE){
					System.out.println("结果超出double的最大范围");
					return -1;
				}
			}
			count = 1.0/count;
			return count;
		}else{
			return 1;
		}
		
	}
	/**
	 * 1.全面考察指数的正负、底数是否为零等情况。
	 * 2.写出指数的二进制表达，例如13表达为二进制1101。
	 * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
	 * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
	 */
	public static double Solution2(double base, int n){
		double res = 1,curr = base;
	    int exponent;
	    if(n>0){
	        exponent = n;
	    }else if(n<0){
	        if(base==0)
	            throw new RuntimeException("分母不能为0"); 
	        exponent = -n;
	    }else{// n==0
	        return 1;// 0的0次方
	    }
	    while(exponent!=0){
	        if((exponent&1)==1)
	            res*=curr;
	        curr*=curr;// 翻倍
	        exponent>>=1;// 右移一位
	    }
	    return n>=0?res:(1/res);  
	}
	public static void main(String[] args) {
		double n = Solution(500000,100);
		System.out.println(Double.MAX_VALUE);
		System.out.println(n);
	}
}
