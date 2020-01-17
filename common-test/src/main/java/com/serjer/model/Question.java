package com.serjer.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Question {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "question_id")
    private Long id;
	
	private String questionBody;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
	private Answer answer;

	public Question(String questionBody, Answer answer) {
		super();
		this.questionBody = questionBody;
		this.answer = answer;
	}
}
