package com.mohit.coding;

import java.util.ArrayList;
import java.util.List;

public class NQueens_51 {

	public static void main(String[] args) {
		/*
		 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
		 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
		 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
		 * Input: n = 4 Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
		 */
		System.out.println(solveNQueens(8));
	}

	private static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> result = new ArrayList<>(); 
		backtrack(board,result,0,n);
		return result;
	}

	private static void backtrack(char[][] board, List<List<String>> result, int col, int n) {
		if(col == n) {
			result.add(construct(board));
			return;
		}
		for(int row = 0; row < n; row++) {
			if(isSafe(board,row,col)) {
				board[row][col] = 'Q';
				backtrack(board,result,col + 1,n);
				board[row][col] = '.';
			}
		}
	}

	private static boolean isSafe(char[][] board, int row, int col) {
		int trow = row;
		int tcol = col;
		int n = board.length;
		while(col >= 0) {
			if(board[row][col] == 'Q')return false;
			col--;
		}
		col = tcol;
		while(col >= 0 && row >= 0) {
			if(board[row][col] == 'Q')return false;
			col--;
			row--;
		}
		col = tcol;
		row = trow;
		while(col >= 0 && row < n) {
			if(board[row][col] == 'Q')return false;
			col--;
			row++;
		}
		return true;
	}

	private static List<String> construct(char[][] board) {
		List<String> s = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			s.add(new String(board[i]));
		}
		return s;
	}

}
