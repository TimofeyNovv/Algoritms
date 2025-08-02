package org.example.ArraysAndHashing.ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
 */
//char[i][j] board где i это строка, а j столбец
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> seen  = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    if (seen.contains(board[i][j])){
                        return false;
                    }
                    seen.add(board[i][j]);
                }
            }
            seen = new HashSet<>();
        }
        for(int j = 0; j < 9; j++){
            for (int i = 0; i < 9; i++){
                if (board[i][j] != '.'){
                    if (seen.contains(board[i][j])){
                        return false;
                    }
                    seen.add(board[i][j]);
                }
            }
            seen = new HashSet<>();
        }
        for (int numberstr = 0; numberstr < 9; numberstr += 3) {
            for (int numbercolumn = 0; numbercolumn < 9; numbercolumn += 3) {
                for (int i = numberstr; i < 3 + numberstr; i++) {
                    for (int j = numbercolumn; j < 3 + numbercolumn; j++) {
                        if (board[i][j] != '.') {
                            if (seen.contains(board[i][j])) {
                                return false;
                            }
                            seen.add(board[i][j]);
                        }
                    }
                }
                seen = new HashSet<>();
            }
        }
        return true;
    }
}
