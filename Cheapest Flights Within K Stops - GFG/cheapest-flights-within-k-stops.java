//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Pair{
    int dest;
    int cost;
    Pair(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}
class Tuple{
    int stops;
    int dest;
    int cost;
    Tuple(int stops, int dest, int cost){
        this.stops = stops;
        this.dest = dest;
        this.cost = cost;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       for(int i =0; i<n; i++){
           adj.add(new ArrayList<>());
       }
       int m = flights.length;
       for(int i =0; i<m; i++){
           adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
       }
       Queue<Tuple> q = new LinkedList<>();
       q.add(new Tuple(0,src,0));
       int[] dist = new int[n];
       for(int i =0; i<n; i++) dist[i] = (int)(1e9);
       dist[src] = 0;
       
       while(!q.isEmpty()){
           Tuple x = q.poll();
           int stops = x.stops;
           int node = x.dest;
           int cost = x.cost;
           
           if(stops > k)continue;
           for(Pair y : adj.get(node)){
               int adjNode = y.dest;
               int edgeWeight = y.cost;
               
               if(cost + edgeWeight < dist[adjNode] && stops <= k){
                   dist[adjNode] = cost + edgeWeight;
                   q.add(new Tuple(stops + 1, adjNode, cost + edgeWeight));
               }
           }
       }
       if(dist[dst] == 1e9) return -1;
       return dist[dst];
    }
}