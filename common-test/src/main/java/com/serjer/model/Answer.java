package com.serjer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Answer {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "answer_id")
	private Long id;
	
	private String answerBody;
	
	@OneToOne(mappedBy = "answer")
    private Question question;


	public Answer(String answerBody) {
		super();
		this.answerBody = answerBody;
	}
}
