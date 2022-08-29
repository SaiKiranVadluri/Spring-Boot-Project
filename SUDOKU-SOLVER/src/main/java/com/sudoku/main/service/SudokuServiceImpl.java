package com.sudoku.main.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sudoku.main.exception.BoardNotFoundException;
import com.sudoku.main.model.Sudoku;
import com.sudoku.main.repository.SudokuRepository;
import com.sudoku.main.validation.SudokuValidation;

@Service
public class SudokuServiceImpl implements SudokuService {

	private SudokuRepository sudokuRepository;

	public SudokuServiceImpl(SudokuRepository sudokuRepository) {
		super();
		this.sudokuRepository = sudokuRepository;
	}

	public Sudoku setSudoku(Sudoku sudoku) {

		return sudokuRepository.save(sudoku);
	}
	
	public Sudoku solveSudoku(int id) throws BoardNotFoundException {

		Optional<Sudoku> sudoku = sudokuRepository.findById(id);

		if (sudoku.isEmpty()) {
			throw new BoardNotFoundException("Board Not Found!!");
		}

		Sudoku temp = sudoku.get();

		SudokuValidation sudokuValidation = new SudokuValidation();
		sudokuValidation.printBoard(temp.getBoard());
		return temp;

	}

}
