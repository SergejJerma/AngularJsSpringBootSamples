package com.serjer.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serjer.model.Item;

@Service
public class FileReadingService {
	
	public List<Item> readingJsonFile()  {
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<Item> items = new ArrayList<>();
		
		try {
			items = Arrays.asList(objectMapper.readValue(getClass().getResourceAsStream("/file.json"), Item[].class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

}
