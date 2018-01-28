/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/


class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null){
            return false;
        }
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int row, int col, int index){
        if(index == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        if(board[row][col] == '#'){  //不能走回头路
            return false;
        }
        board[row][col] = '#';
        boolean res = helper(board, word, row, col + 1, index + 1) ||
                      helper(board, word, row, col - 1, index + 1) ||
                      helper(board, word, row + 1, col, index + 1) ||
                      helper(board, word, row - 1, col, index + 1);
        board[row][col] = word.charAt(index);
        return res;
    }
}