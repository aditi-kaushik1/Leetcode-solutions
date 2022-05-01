/* Determine if a 9 x 9 Sudoku board is valid. 
Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'. */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Solution 1 (O(81*2 + 3*3*3*3))
//         Set<Character> numbersPresent = new HashSet<>();
        
//         for(int i = 0; i < 9; i++) {
//             for(int j = 0; j < 9; j++) {
//                 if(board[i][j] != '.') {
//                     if(numbersPresent.contains(board[i][j]))
//                         return false;
//                     numbersPresent.add(board[i][j]);
//                 }
//             }
//             numbersPresent.clear();
            
//             for(int k = 0; k < 9; k++) {
//                 if(board[k][i] != '.') {
//                     if(numbersPresent.contains(board[k][i]))
//                         return false;
//                     numbersPresent.add(board[k][i]);
//                 }
//             }
//             numbersPresent.clear();
//         }
        
//         int k = 0;
//         int l = 0;
        
//         while(k != 9) {
//             while(l != 9) {
//                 for(int i = k; i <= k + 2; i++) {
//                     for(int j = l; j <= l + 2; j++) {
//                         if(board[i][j] != '.') {
//                             if(numbersPresent.contains(board[i][j]))
//                                 return false;
//                             numbersPresent.add(board[i][j]);
//                         }
//                     }
//                 }
//                 numbersPresent.clear();
//                 l += 3;
//             }
//             numbersPresent.clear();
//             k += 3;
//             l = 0;
//         }
        
//         return true;
        
        //Solution 2
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char value = board[i][j];
                
                if(value == '.')
                    continue;
                String row = "R" + i + value;
                String column = "C" + j + value;
                String smallSquare = i/3 + "B" + j/3 + value;
                if(set.contains(row) || set.contains(column) || set.contains(smallSquare))
                    return false;
                else {
                    set.add(row);
                    set.add(column);
                    set.add(smallSquare);
                }
            }
        }
        return true;
    }
}
