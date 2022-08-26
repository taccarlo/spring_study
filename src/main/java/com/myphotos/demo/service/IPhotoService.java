package com.myphotos.demo.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.myphotos.demo.model.Photo;

public interface IPhotoService {
	public Iterable<Photo> getAll();
	public Photo create(@RequestBody Photo photo);
	public  Optional<Photo>  getById(int id);
	public Optional<Photo> update(int id, Photo photo);
	public boolean delete(int id);
}
