package com.cybage.service;

import java.util.List;
import java.util.Optional;

import com.cybage.bean.MovieBean;
import com.cybage.entity.MovieEntity;

public interface MovieService {
	List<MovieEntity> findByCity(String city);

	List<MovieEntity> findByLanguage(String language);


	List<MovieEntity> findByGenre(String genre);
	
  
}

