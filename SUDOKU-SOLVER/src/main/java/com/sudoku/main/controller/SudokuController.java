package com.sudoku.main.controller;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.sudoku.main.model.Sudoku;
import com.sudoku.main.request.RequestSudoku;
import com.sudoku.main.response.ResponseSudoku;
import com.sudoku.main.service.SudokuService;

@RestController
public class SudokuController {
	
	private SudokuService sudokuService;
	
	public SudokuController(SudokuService sudokuService) {
		super();
		this.sudokuService = sudokuService;
	}

	@PostMapping("/add")
	public String setSudoku(@RequestBody RequestSudoku requestSudoku) throws Exception{
		
		try {
			if(requestSudoku.getBoard().length != 9) {
				return "Invalid input size, please enter valid 9X9 inputs";
			}
//			else if(requestSudoku.getBoard().toString().isBlank()) {
//				return "Input cannor contain blank spaces, kindly enter correct input";
//			}
			else {
				Sudoku sudoku = new Sudoku();
				sudoku.setBoard(requestSudoku.getBoard());
				sudokuService.setSudoku(sudoku);
				return "Successfully added board with id : " + sudoku.getId();
			}
		} catch (HttpMessageNotReadableException e) {
			return e.getMessage();
		}
	}

	
	@GetMapping("/solvesudoku/{id}")
	public int[][] solveSudoku(@PathVariable int id) {
		
		try {
			Sudoku sudoku = sudokuService.solveSudoku(id);
			
			ResponseSudoku responseSudoku = new ResponseSudoku();
			responseSudoku.setBoard(sudoku.getBoard());
			return responseSudoku.getBoard();
		} catch (Exception e) {
			System.out.println("Board Not found with id : " + id);
			return new ResponseSudoku().getBoard();
		}
	}
	
//	@GetMapping("/solvesudoku/{id}")
//	public String solveSudoku(@PathVariable int id) {
//		
//		try {
//			Sudoku sudoku = sudokuService.solveSudoku(id);
//			
//			ResponseSudoku responseSudoku = new ResponseSudoku();
//			responseSudoku.setBoard(sudoku.getBoard());
//			
//			return responseSudoku.getBoard();
//			//return responseSudoku.getBoard();
//			
//		} catch (Exception e) {
//			return ("Board Not found with id : " + id);
//			
//		}
//	}

}
