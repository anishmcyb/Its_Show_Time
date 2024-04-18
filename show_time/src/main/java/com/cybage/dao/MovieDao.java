package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.entity.MovieEntity;

public interface MovieDao extends JpaRepository<MovieEntity, Integer> {
    List<MovieEntity> findByCity(String city);


	
	List<MovieEntity> findByGenre(String genre);



	List<MovieEntity> findByLanguage(String language);
  

   
    
}
