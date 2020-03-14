package q0341;

import java.util.List;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {

   // @return true if this NestedInteger holds a single integer, rather than a nested list.
   public boolean isInteger();

   // @return the single integer that this NestedInteger holds, if it holds a single integer
 // Return null if this NestedInteger holds a nested list
  public Integer getInteger();
  public List<NestedInteger> getList();
}
