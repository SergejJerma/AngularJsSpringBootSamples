package com.serjer.model;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Item {
	private String question;
	private List<String> answers;
}
