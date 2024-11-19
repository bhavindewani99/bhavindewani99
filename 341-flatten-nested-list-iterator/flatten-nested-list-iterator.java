/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<Integer> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        dfs(nestedList, stack);
    }

    @Override
    public Integer next() {
        return stack.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return stack.size()>0;
    }

    private void dfs(List<NestedInteger> nestedList, Deque<Integer> stack){
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isInteger()){
                stack.add(nestedInteger.getInteger());
            }else{
                dfs(nestedInteger.getList(),stack);
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */