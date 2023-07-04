class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length, answer = 0;
        //union the cells that can be connected thru swaps
        UnionFind uf = new UnionFind(n);
        for (int[] swap : allowedSwaps) {
            uf.unify(swap[0], swap[1]);
        }
        //this holds the element in the source array along with all of the different parent cells it can reach
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
            //if there is no target cell number that means it doesn't exist in source array so it will be difference
            //also check to see if target cell number has a parent that matches the parent of curr cell i
            answer += (!map.containsKey(target[i]) || !map.get(target[i]).remove(new Integer(uf.getAbsoluteParent(i)))) ? 1 : 0;
        }
        return answer;
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