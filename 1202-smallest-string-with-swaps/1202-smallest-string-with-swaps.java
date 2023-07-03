class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char str[] = s.toCharArray();
        
        //Integer -> parentID,   PQ -> group of swappable indices
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        UnionFind uf = new UnionFind(str.length);
        
        for(List<Integer> pair : pairs){
            uf.unify(pair.get(0), pair.get(1));
        }
        
        for(int i=0; i<str.length; i++){
            int parentID = uf.getAbsoluteParent(i);
            PriorityQueue<Character> pq = map.getOrDefault(parentID, new PriorityQueue<Character>());
            pq.offer(str[i]);
            map.putIfAbsent(parentID, pq);
        }
        
        for(int i =0; i<str.length; i++){
            int parentID = uf.getAbsoluteParent(i);
            str[i] = map.get(parentID).poll();
        }
        
        return new String(str);
        
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
            
            
            
            
            
