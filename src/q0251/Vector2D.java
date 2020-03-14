package q0251;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer>{

	Iterator<List<Integer>> i;
	Iterator<Integer> j;
	
	@Override
	public Integer next() {
		return j.next();
	}
	
	@Override
	public boolean hasNext() {
		while((j==null || !j.hasNext()) && i.hasNext()){
			j = i.next().iterator();
		}
		return j!=null && j.hasNext();
	}

	

}
