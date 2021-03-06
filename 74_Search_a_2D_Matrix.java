/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/


class Solution {
   public boolean searchMatrix(int[][] matrix, int target) { 
       if(matrix == null || matrix.length == 0){
           return false;
       }
       int row = 0, col = matrix[0].length - 1;
       while(row < matrix.length && col >= 0){
           if(matrix[row][col] == target){
             return true;  
           } else if(matrix[row][col] < target){
               row ++;
           } else {
               col--;
           }
       }
       return false;
   }
    
////////////////////////////自己写出来的基本做法 log(m * n)//////////  
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if(matrix == null || matrix.length == 0){
//             return false;
//         }
//         int m = matrix.length, n = matrix[0].length;
//         int low = 0, high = m * n - 1;
//         while(low <= high){
//             int mid = low + (high - low) / 2;
//             int midVal = matrix[mid / n][mid % m];
//             if(midVal == target){
//                 return true;
//             } else if(midVal > target){
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }
//         return false;
//     }
}