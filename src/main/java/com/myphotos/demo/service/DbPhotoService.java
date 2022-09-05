package com.myphotos.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.myphotos.demo.model.Photo;
import com.myphotos.demo.repository.IPhotoRepository;

/**
 * Service indicate that the class is used to hold the business logic
 */
@Service("mainPhotoService")
public class DbPhotoService  implements IPhotoService {

	@Autowired
	private IPhotoRepository photoRepository;
	
	@Override
	public Iterable<Photo> getAll(){
		return photoRepository.findAll();
	}

	@Override
	public Photo create(@RequestBody Photo photo) {
		return photoRepository.save(photo);
	}

	@Override
	public Optional<Photo> getById(int id) {
		return photoRepository.findById(id);
	}

	@Override
	public Optional<Photo> update(int id, Photo photo) {
		Optional<Photo> foundPhoto = photoRepository.findById(id);
		if(foundPhoto.isEmpty()) {
			return Optional.empty();
		}
		foundPhoto.get().setUrl(photo.getUrl());
		photoRepository.save(foundPhoto.get());
		return foundPhoto;
	}

	@Override
	public boolean delete(int id) {

		Optional<Photo> foundPhoto = photoRepository.findById(id);
		if(foundPhoto.isEmpty()) {
			return false;
		}
		photoRepository.delete(foundPhoto.get());
		return true;
	}
	
}
