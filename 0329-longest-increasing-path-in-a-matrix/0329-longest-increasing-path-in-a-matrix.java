class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int vis[][] = new int[m][n]; 
        
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
               int length = dfs(i, j, m, n, matrix,vis);
                max = Math.max(length, max);
            }
        }
        return max;
    }
    public int dfs(int i, int j, int m, int n, int[][] matrix, int[][] vis){
        
        if(vis[i][j] != 0) return vis[i][j];
        int ans = 1;
        
        
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int k =0; k<4; k++){
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            
            if(x<0 || x>=m || y<0 || y>=n || matrix[i][j] >= matrix[x][y]) continue;
            
            int len = 1 + dfs(x, y, m, n, matrix, vis);
            ans = Math.max(ans, len);
        }
        vis[i][j] = ans;
        return ans;
    }
}