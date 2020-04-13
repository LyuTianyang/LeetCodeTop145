package q0341_design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator2 implements Iterator<Integer>{
	Queue<Integer> res = new LinkedList<>();

    public NestedIterator2(List<NestedInteger> nestedList) {
        for(NestedInteger temp : nestedList)
            DFS(temp);
    }

    @Override
    public Integer next() {
        return res.poll();
    }

    @Override
    public boolean hasNext() {
        if(res.isEmpty())
            return false;
        return true;
        
    }
    public void DFS(NestedInteger Node){
        /* 深度遍历 */
        if(Node.isInteger()){
        	res.offer(Node.getInteger());
        }
            
        for(NestedInteger temp :Node.getList()){
        	DFS(temp);
        }  
    }
}
