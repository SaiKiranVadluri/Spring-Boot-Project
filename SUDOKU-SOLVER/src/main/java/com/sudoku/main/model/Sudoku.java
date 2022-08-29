package com.sudoku.main.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sudoku {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int[][] board = new int[9][9];

	public Sudoku() {
		super();
	}

	public Sudoku(int id, int[][] board) {
		super();
		this.id = id;
		this.board = board;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "Sudoku [id=" + id + ", board=" + Arrays.toString(board) + "]";
	}

}
