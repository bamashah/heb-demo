package com.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
