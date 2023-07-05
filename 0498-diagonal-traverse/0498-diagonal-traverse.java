class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans[] = new int[rows*cols];
        
        int r = 0, c = 0;
        
        for(int i =0; i<rows*cols; i++){
             ans[i] = matrix[r][c];
            
            if((r+c)%2 == 0) {
                if(r-1 >= 0 && c + 1 < cols) {
                    r = r-1; c = c+1;
                }
                else if(r-1<0 && c+1 < cols){
                    c = c +1;
                }
                else if(r+1 >=0 && c+1 >= cols){
                    r= r+1;
                }
            }
            
            else if ((r + c) % 2 != 0) {
                if (r + 1 < rows && c - 1 >= 0) {
                    c = c - 1;
                    r = r + 1;
                } else if (r + 1 < rows && c - 1 < 0) {
                    r = r + 1;
                } else if (r + 1 > rows - 1 && c +1 < cols) {
                    c = c + 1;
                    }
                }
            }
        return ans;
    }
}