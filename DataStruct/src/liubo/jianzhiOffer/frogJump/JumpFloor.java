package liubo.jianzhiOffer.frogJump;

public class JumpFloor {
	/**
	 * 
	 * @param target
	 * @return
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 当只有一个台阶时候只有一种跳法，两层台阶有两种跳法，三层有三种，四层有五种，所以这是一个斐波拉西数列。
	 */
	public int JumpFloor(int target){
		if(target<=0){
			return -1;
		}
		if(target==1){
			return 1;
		}
		if(target==2){
			return 2;
		}else{
			return JumpFloor(target-1)+JumpFloor(target-2);
		}
	}
}
