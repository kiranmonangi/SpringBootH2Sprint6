package com.ezeu.demo.model;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;



import com.ezeu.demo.controller.ItemController;
import com.ezeu.demo.dao.ItemRepo;


@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE )
public class ItemTest {
	
	@Autowired
	private ItemRepo repo;

	@Autowired
	private ItemController itemController;

	@Test
	//@Rollback(false)
	public void addItemtest() {
		
		Item item =new Item(6,"samosa",25);
		//Item savedItem = repo.save(item);
		 repo.save(item);
		//assertNotNull(savedItem);
			Assertions.assertEquals( itemController.getItem(6).getId(), 6);
			Assertions.assertEquals( itemController.getItem(6).getPrice(), 25);
			System.out.println(itemController.getItem(6));
	}
	
	@Test
	public void GetItemtest() {
		
		int id = 3;
		//ItemController itemController = new ItemController();
	    Item resultItem = itemController.getItem(id);
		 System.out.println("hi...........tester///////////");
		// System.out.println(itemController.getItem(id));
		 Item item1 =new Item(3,"lays",20);
		 System.out.println(item1);
		Assertions.assertEquals( resultItem.getId(), 3);
		Assertions.assertEquals( resultItem.getPrice(), 20);
		Assertions.assertEquals(item1, resultItem);
		System.out.println(resultItem + "this is result");
	}

	
	

}
