package q0251_design;

import java.util.List;

public class Vector2D02 {
	/**
	Implement an iterator to flatten a 2d vector.

	Example:
	
	Input: 2d vector =
	[
	  [1,2],
	  [3],
	  [4,5,6]
	]
	Output: [1,2,3,4,5,6]
	Explanation: By calling next repeatedly until hasNext returns false, 
	             the order of elements returned by next should be: [1,2,3,4,5,6].
	Follow up:
	As an added challenge, try to code it using only iterators in C++ or iterators in Java.
	 */
	List<List<Integer>> listOfList;
	int listIndex;
	int elemIndex;
	public Vector2D02(List<List<Integer>> vec2d){
		listOfList = vec2d;
		listIndex = 0;
		elemIndex = 0;
	}
	
	public int next(){
		return listOfList.get(listIndex).get(elemIndex++);
	}
	
	public boolean hasNext(){
		while(listIndex < listOfList.size()){
			if(elemIndex < listOfList.get(listIndex).size()){
				return true;
			}else{
				listIndex++;
				elemIndex = 0;
			}
		}
		return false;
	}
}
