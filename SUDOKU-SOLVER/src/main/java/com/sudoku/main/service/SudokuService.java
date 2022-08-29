package com.sudoku.main.service;

import com.sudoku.main.exception.BoardNotFoundException;
import com.sudoku.main.model.Sudoku;

public interface SudokuService{
	
	public Sudoku setSudoku(Sudoku sudoku);
	
	public Sudoku solveSudoku(int id) throws BoardNotFoundException;
	
}
