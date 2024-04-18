package com.cybage.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cybage.dao.MovieDao;
import com.cybage.entity.MovieEntity;

@Service
public class MovieServiceImpl  implements MovieService{


	@Autowired
	private MovieDao movieDao;
	
	

	public List<MovieEntity> findByCity(String city) {
		// TODO Auto-generated method stub
		return movieDao.findByCity(city);
	}

	@Override
	public List<MovieEntity> findByLanguage(String language) {
		// TODO Auto-generated method stub
		return movieDao.findByLanguage(language);
	}

	@Override
	public List<MovieEntity> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return movieDao.findByGenre(genre);
	}}
