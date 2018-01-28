/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/


class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int n0 = 1; //立flag，标记第一列为1
        for(int i = 0; i < m; i++){
           if(matrix[i][0] == 0){   //单独处理第一列
               n0 = 0;
           } 
           for(int j = 1; j < n; j++){
               if(matrix[i][j] == 0){
                   matrix[i][0] = matrix[0][j] = 0;
               }
           } 
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 1; j--){
                if(matrix[i][0] == 0|| matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(n0 == 0){
                matrix[i][0] = 0;
            }
        }
    }
}