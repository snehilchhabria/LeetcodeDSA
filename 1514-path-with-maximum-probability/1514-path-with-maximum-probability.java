class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
       
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int j = 0;
        for(int arr[] : edges){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(new Pair(v, succProb[j]));
            adj.get(v).add(new Pair(u, succProb[j]));
            j++;
        }
        int[] vis = new int[n];
        double ans = Integer.MIN_VALUE;
    
        Queue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.prob, a.prob));
        pq.add(new Pair(start,1));
        
        while(!pq.isEmpty()){
            Pair data = pq.poll();
            int node = data.node;
            double prob = data.prob;
            if(node == end) ans = Math.max(ans, prob);
            vis[node] = 1;
            for(Pair x : adj.get(node)){
                
                if(vis[x.node] == 0){
                    pq.add(new Pair(x.node, prob*x.prob));
                }
            }
        }
        return ans == Integer.MIN_VALUE? 0 : ans;
    }
}
class Pair{
    int node;
    double prob;
    Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}