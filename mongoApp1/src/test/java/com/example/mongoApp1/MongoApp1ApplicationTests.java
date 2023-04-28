package com.example.mongoApp1;

import com.example.mongoApp1.documents.GroceryItem;
import com.example.mongoApp1.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
class MongoApp1ApplicationTests {

	@MockBean
	ItemRepository groceryItemRepo;

	@Autowired
	MongoApp1Application mongoApp1Application;


	@Test
	void testShowAll() {
		when(groceryItemRepo.findAll()).thenReturn(Stream.of(new GroceryItem("1","Item1",2,"Category1"),
				new GroceryItem("2","Item2",3,"Category2")).collect(Collectors.toList()));
		mongoApp1Application.showAllGroceryItems();

	}

}
