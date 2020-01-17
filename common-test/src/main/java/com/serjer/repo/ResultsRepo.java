package com.serjer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serjer.model.Question;

public interface ResultsRepo extends JpaRepository<Question, Long> {


}
