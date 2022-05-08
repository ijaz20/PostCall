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
    
    Stack<NestedInteger> st = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        process(nestedList);
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()) {
            var n = st.peek();
            if(n.isInteger()) return true;
            process(st.pop().getList());
        }
        return false;
    }
    
    void process(List<NestedInteger> nes) {
        for(int i=nes.size()-1; i>=0 ; i--) {
            st.push(nes.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */