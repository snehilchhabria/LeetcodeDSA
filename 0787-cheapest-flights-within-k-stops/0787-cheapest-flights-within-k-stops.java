class Tuple{
    int stops;
    int node;
    int distance;
    Tuple(int stops, int node, int distance){
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}
class Pair{
    int dest;
    int cost;
    Pair(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return -1;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int a[] : flights){
            adj.get(a[0]).add(new Pair(a[1], a[2]));
        }
        
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.stops - y.stops);
        pq.add(new Tuple(0,src,0));
        
        int[] dist = new int[n];
        for(int i = 0; i<n; i++) dist[i] = (int)(1e9);
        dist[src] = 0;
        
        
        while(!pq.isEmpty()){
            
            Tuple x = pq.poll();
            int stops = x.stops;
            int node = x.node;
            int distance = x.distance;
            
            if(stops > k) continue;
            
            for(Pair it : adj.get(node)){
                int dest = it.dest;
                int cost = it.cost;
                
                if(distance + cost < dist[dest]){
                    dist[dest] = distance + cost;
                    pq.add(new Tuple(stops +1, dest, distance + cost));
                }
            }
        }
        
        return dist[dst] != 1e9 ? dist[dst] : -1;
    }
}