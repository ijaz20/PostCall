class MyHashSet {
    
    List<Integer>[] set = null;
    double lf= 0.75;
    int cap = 100, size = 0;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new LinkedList[cap];        
    }
    
    int getHashIndex(int key){
        return key % cap;
    }
    
    public void add(int key) {
        if(contains(key)) return;  
        if(size == cap * lf){
            cap *= 2;
            size=0;
            List<Integer>[] oldC = set;
            set = new LinkedList[cap];
            for(int i=0; i < oldC.length; i++){
                List<Integer> list = oldC[i];
                if(list != null){
                    for(int entry : list)
                       this.add(entry); 
                }
            }
        }
        int ind = getHashIndex(key);
        if(set[ind] == null) set[ind] = new LinkedList<>();
        set[ind].add(key);
        size++;
    }
    
    public void remove(int key) {
        int ind = getHashIndex(key);
        if(set[ind] == null) return;
        int i = set[ind].indexOf(key);
        if(i == -1) return;
        set[ind].remove(i);
        size--;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int ind = getHashIndex(key);
        return set[ind] != null && set[ind].indexOf(key) != -1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */