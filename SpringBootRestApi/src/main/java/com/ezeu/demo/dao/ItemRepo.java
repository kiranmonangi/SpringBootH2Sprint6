package com.ezeu.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezeu.demo.model.Item;


//@RepositoryRestResource(collectionResourceRel="items",path="items")
public interface ItemRepo extends JpaRepository<Item,Integer>
{
	//	public Item findById(int id);

}
