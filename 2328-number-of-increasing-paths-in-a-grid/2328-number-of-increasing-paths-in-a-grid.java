class Solution {
    int mod = (int)Math.pow(10,9) + 7;
    public int countPaths(int[][] matrix) {
        
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] vis = new int[m][n];
        
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                int length = dfs(i, j, m, n, matrix, vis, -1);
                ans = (ans%mod + length%mod)%mod;
            }
        }
        return ans;
    }
    public int dfs(int i, int j, int m, int n, int[][] matrix, int[][] vis, int prev){
        
        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j] <= prev) return 0;
        
        if(vis[i][j] != 0) return vis[i][j];
        
        int a = dfs(i+1, j, m, n, matrix, vis, matrix[i][j]);
        int b = dfs(i-1, j, m, n, matrix, vis, matrix[i][j]);
        int c = dfs(i, j+1, m, n, matrix, vis, matrix[i][j]);
        int d = dfs(i, j-1, m, n, matrix, vis, matrix[i][j]);
        
        return vis[i][j] = (1 + a + b + c + d)%mod;
    }
}