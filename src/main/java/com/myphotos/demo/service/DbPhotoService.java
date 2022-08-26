package com.myphotos.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.myphotos.demo.model.Photo;

@Service("mainPhotoService")
public class DbPhotoService  implements IPhotoService {

	@Override
	public Iterable<Photo> getAll(){
		return new ArrayList<Photo>();
	}

	@Override
	public Photo create(@RequestBody Photo photo) {
		return null;
	}

	@Override
	public Optional<Photo> getById(int id) {
		return Optional.empty();
	}

	@Override
	public Optional<Photo> update(int id, Photo photo) {
		return Optional.empty();
	}

	@Override
	public boolean delete(int id) {
		return false;
	}
	
}
