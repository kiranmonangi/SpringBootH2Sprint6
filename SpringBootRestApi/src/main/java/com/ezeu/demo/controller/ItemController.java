package com.ezeu.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezeu.demo.dao.ItemRepo;
import com.ezeu.demo.model.Item;

@RestController
public class ItemController 
{
	@Autowired
	ItemRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "<h1>This is just localhost just give 'items' to get the list</h1>";
	}
	
	@PostMapping("/item")
	public Item addItem(@RequestBody Item item)
	{
		repo.save(item);
		return item;
	}   
	
	@DeleteMapping("/item/{id}")
	public String deleteItem(@PathVariable int id)
	{
		Item i = repo.getOne(id);
		repo.delete(i);
		return "deleted";
	}
	
	@GetMapping("/items")
	public List<Item> getItems()
	{
		
		return repo.findAll();		
		
	}
	
	@PutMapping("/item")
	public Item saveOrUpdateItem(@RequestBody Item item)
	{
		repo.save(item);
		return item;
	}
	
	@RequestMapping("/item/{id}")
	public Item getItem(@PathVariable("id") int id)
	{
		Optional<Item> optionalItem = repo.findById(id);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		} else 
			return null;
	}
}
