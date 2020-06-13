package q0069_easy_BinarySearch;

public class MySqrt {
	
	/**
	Q0069 实现 int sqrt(int x) 函数。

	计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	输入: 4
	输出: 2
	
	输入: 8
	输出: 2
	说明: 8 的平方根是 2.82842..., 
	     由于返回类型是整数，小数部分将被舍去。
	 */
	public static int mySqrt(int x) {
		int magicNum = (int)Math.sqrt(Integer.MAX_VALUE);
		int start = 1; 
		int end = magicNum;
		while(start+1<end){
			int mid = start+(end-start)/2;
			if(mid*mid == x) return mid;
			if(mid*mid > x){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(end * end <= x){
			return end;
		}else{
			return start;
		}
	}
	
	public static void main(String[] args) {
		int result = mySqrt(105);
		System.out.println(result);
	}
	
}
