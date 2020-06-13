package q0066_easy;

public class PlusOne {
	/**
	 Q0066 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	你可以假设除了整数 0 之外，这个整数不会以零开头。
	
	输入: [1,2,3]
	输出: [1,2,4]
	解释: 输入数组表示数字 123。
	 */
	public static int[] plusOne(int[] digits) {
		if(digits == null || digits.length ==0) return null;
		int len = digits.length;
		for(int i=len-1; i>=0; i--){
			digits[i] = digits[i]+1;
			digits[i] = digits[i]%10;
			//如果数组中元素，不都是9，就会直接return
			if(digits[i] != 0) return digits;
		}
		digits = new int[len+1];
		digits[0] = 1;
		return digits;
	}
	
	public static int[] plusOne1(int[] digits) {
		if(digits == null || digits.length == 0) return new int[]{1};
		int len = digits.length;
		int carry = 0;
		for(int i=len-1; i>=0; i--){
			int tmp = 0;
			if(i == len-1){
				tmp = digits[i]+1;
			}else{
				tmp = digits[i]+carry;
			}
			digits[i] = tmp%10;
			carry = tmp/10;
		}
		if(carry == 1){
			digits = new int[len+1];
			digits[0] = 1;
		}
		return digits;
	}
	
	public static void main(String[] args) {
		int[] digits = {9,9,9};
		int[] result = plusOne1(digits);
		for(int r: result){
			System.out.println(r);
		}
		
	}
}
