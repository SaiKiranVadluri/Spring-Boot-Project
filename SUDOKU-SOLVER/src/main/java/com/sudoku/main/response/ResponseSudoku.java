package com.sudoku.main.response;

import java.util.Arrays;

public class ResponseSudoku {
	
	private int[][] board = new int[9][9];

	public ResponseSudoku(int[][] board) {
		super();
		this.board = board;
	}

	public ResponseSudoku() {
		super();
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "Sudoku : " +  "board = " + Arrays.toString(board) + "]";
	}
	
}
