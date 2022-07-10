class SmallestInfiniteSet {
    TreeSet<Integer> ts = new TreeSet<Integer>();
    public SmallestInfiniteSet() {
        for(int i=1; i<=1000; i++) {
            ts.add(i);
        }
    }
    
    public int popSmallest() {
        int i = ts.first();
        ts.remove(i);
        return i;
    }
    
    public void addBack(int num) {
        ts.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */