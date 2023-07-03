
class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0; i<n; i++)
            adj.add(new ArrayList<Pair>());
        
        for(int a[] : roads){
            adj.get(a[0]).add(new Pair(a[2], a[1]));
            adj.get(a[1]).add(new Pair(a[2], a[0]));
        }
        long dist[] = new long[n];
        int[] ways = new int[n];
        for(int i =0; i<n; i++) dist[i] = (int)(1e18);
        
        dist[0] = 0;
        ways[0] = 1;
        
        int mod = (int)(1e9 + 7);
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            
            Pair x = pq.poll();
            int distance = x.distance;
            int node = x.node;
            
            for(Pair p : adj.get(node)){
                int adjNode = p.node;
                int wt = p.distance;
                
                //if shorter distance found to the adjNode then update the dist and ways for adjNode would be same as
                //Node as node has come up with shorter distance so we will store its no. of ways
                if(wt + distance < dist[adjNode]){
                    dist[adjNode] = wt + distance;
                    pq.add(new Pair(distance + wt, adjNode));
                    ways[adjNode] = ways[node];
                }
                //if same distance is found that means we have found another route to travel to the adjNode with same 
                //distance so no. of routes/ways should be added up as they all have the same cost to their destination
                else if(wt + distance == dist[adjNode]){
                    ways[adjNode] = (ways[node] + ways[adjNode])% mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}