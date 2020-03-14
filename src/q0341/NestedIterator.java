package q0341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer>{
	/**
	给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

	列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
	
	示例 1:
	
	输入: [[1,1],2,[1,1]]
	输出: [1,1,2,1,1]
	解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
	示例 2:
	
	输入: [1,[4,[6]]]
	输出: [1,4,6]
	解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
	 */
	private Stack<NestedInteger> mainStack = new Stack<>();
    private Stack<Integer> aidStack = new Stack<>();

    private void flattern(Stack<NestedInteger> mainStack, Stack<Integer> aidStack){
        while(!mainStack.empty()){
            NestedInteger n = mainStack.pop();
            if(n.isInteger())
                aidStack.push(n.getInteger());
            else{
                for(NestedInteger x: n.getList())
                    mainStack.push(x);
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger n: nestedList)
            mainStack.push(n);
        flattern(mainStack, aidStack);
    }

    @Override
    public Integer next() {
        return aidStack.pop();
    }

    @Override
    public boolean hasNext() {
        return !aidStack.empty();
    }
}
