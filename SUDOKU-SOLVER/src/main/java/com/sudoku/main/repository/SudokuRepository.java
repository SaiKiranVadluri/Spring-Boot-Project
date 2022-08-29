package com.sudoku.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudoku.main.model.Sudoku;

@Repository
public interface SudokuRepository extends JpaRepository<Sudoku, Integer>{

}
