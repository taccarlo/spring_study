package com.myphotos.demo.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.demo.model.Photo;
import com.myphotos.demo.service.IPhotoService;

/**
 * The RestController is a specialized version of the controller.
 */
@RestController
public class AdminPhotoController{


	/**
	 * Autowired : allows to resolve and injext collaborating beans into our bean
	 * Bean : objects managed by the spring IoC container
	 * Qualifier : indicate which bean needs to be injected
	 */
	@Autowired
	@Qualifier("mainPhotoService")
	private IPhotoService photoService;
	
	public AdminPhotoController() {
	}
	
	@RequestMapping("/admin/api/photos")
	public Iterable<Photo> getAll(){
		return photoService.getAll();
	}
	
	@RequestMapping("/admin/api/photos/{id}")
	public Photo getById(@PathVariable int id) {
		Optional<Photo> photo = photoService.getById(id);
		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		return photo.get();
	}
	
	@RequestMapping(value = "/admin/api/photos", method = RequestMethod.POST)
	public Photo create(@RequestBody Photo photo) {
		return photoService.create(photo);
	}
	
	@RequestMapping(value = "/admin/api/photos/{id}", method = RequestMethod.PUT)
	public Photo update(@PathVariable int id, @RequestBody Photo photo) {
		Optional<Photo> foundPhoto = photoService.update(id, photo);
		if(foundPhoto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		foundPhoto.get().setUrl(photo.getUrl());
		return foundPhoto.get();
	}
	
	@RequestMapping(value = "/admin/api/photos/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		boolean isDeleted = photoService.delete(id);
		if(!isDeleted) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
	}
	
	
}
