package com.myphotos.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myphotos.demo.model.Photo;

/**
 * Repository annotation is used to indicate that the class provides the mechanism for CRUD operations on objects
 */
@Repository
public interface IPhotoRepository extends CrudRepository <Photo, Integer> {
	
}
