package com.sudoku.main.request;

import java.util.Arrays;

public class RequestSudoku {
	
	private int[][] board = new int[9][9];

	public RequestSudoku(int[][] board) {
		super();
		this.board = board;
	}

	public RequestSudoku() {
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
