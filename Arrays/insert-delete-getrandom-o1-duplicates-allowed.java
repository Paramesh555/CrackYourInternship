class RandomizedCollection {
    ArrayList<Integer> lst;
    HashMap<Integer,Set<Integer>> idx;
    java.util.Random rand = new java.util.Random();

    public RandomizedCollection() {
        lst = new ArrayList();
        idx = new HashMap<Integer,Set<Integer>>();
    }
    
    public boolean insert(int val) {
        lst.add(val);
        if(idx.containsKey(val) == false){
            idx.put(val,new HashSet<Integer>());
        }
        idx.get(val).add(lst.size() -1);
        return idx.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if(!idx.containsKey(val)) return false;
        int removeIdx = idx.get(val).iterator().next();
        idx.get(val).remove(removeIdx);
        
        int last = lst.get(lst.size() - 1);
        //order is important
        lst.set(removeIdx,last);
        idx.get(last).add(removeIdx);
        idx.get(last).remove(lst.size() - 1);
        if(idx.get(val).size() == 0) idx.remove(val);
        
        lst.remove(lst.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size())); // generates a random number between 0 to lst.size()
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */