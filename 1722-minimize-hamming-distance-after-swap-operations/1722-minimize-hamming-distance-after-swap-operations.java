class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        //if you dont know what is UnionFind  Algorithm then I would suggest you to first study that
        
        int n = source.length, HamDis = 0;
        UnionFind uf = new UnionFind(n);
        
        for (int[] swap : allowedSwaps) {
            uf.unify(swap[0], swap[1]);
        }
        
        //source[i] --> their parent Id
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sourceElement = source[i];
            int parentID = uf.getAbsoluteParent(i);
    
            if (!map.containsKey(sourceElement)) {
                map.put(sourceElement, new ArrayList<>());
            }
    
            List<Integer> list = map.get(sourceElement);
            list.add(parentID);
        }
        
        for (int i = 0; i < n; i++) {
            //if there is no target cell in map that means it doesn't exists in source s0 hamDis +=1
            //2nd exprsn checks if the removal operation was successful.
            //If the element was not present in the collection and therefore couldn't be removed,
            //it evaluates to false so HamDis++ . If the element was successfully
            //removed or the collection is empty, it evaluates to true and no increment to HamDis
            
              if((!map.containsKey(target[i]))){
                  HamDis += 1;
              }
                 else if(!map.get(target[i]).remove(new Integer(uf.getAbsoluteParent(i)))){
                  HamDis += 1;
              }
        }
        return HamDis;
    }
    
    private class UnionFind{
       private int[] parent;
        
        private UnionFind(int n){
            parent = new int[n];
            for(int i =0; i<n; i++){
                parent[i] = i;
            }
        }
        
        private int getAbsoluteParent(int i){
            if(parent[i] == i){
                return i;
            }
            parent[i] = getAbsoluteParent(parent[i]);
            return parent[i];
        }
        
        private void unify(int i, int j){
            int absoluteParentI = getAbsoluteParent(i);
            int absoluteParentJ = getAbsoluteParent(j);
            if(absoluteParentI != absoluteParentJ){
                parent[absoluteParentJ] = absoluteParentI;
            }
        }
    }
}