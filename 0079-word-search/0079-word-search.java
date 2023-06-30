class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean [][] vis = new boolean[m][n];
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int idx, boolean[][] vis){
        if(idx == word.length()){
            return true;
        }
        if(i<0 || i>=m || j<0 ||j>=n || board[i][j] != word.charAt(idx) || vis[i][j] == true){
            return false;
        }
        
        vis[i][j] = true;
        if( 
            dfs(board, word, i+1, j, idx+1, vis) ||
            dfs(board, word, i-1, j, idx+1, vis) || 
            dfs(board, word, i, j+1, idx+1, vis) ||
            dfs(board, word, i, j-1, idx+1, vis)
          ){
            return true;
        }
        vis[i][j] = false;
        return false;
    }
}