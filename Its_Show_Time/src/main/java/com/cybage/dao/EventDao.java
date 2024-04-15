package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.cybage.entity.EventEntity;

public interface EventDao extends JpaRepository<EventEntity, Integer>{
	List<EventEntity> findByEventName(String eventName);

	
	@Query(value ="SELECT * FROM event_entity WHERE event_name LIKE CONCAT(:letter,'%')",nativeQuery = true)
	public List<EventEntity>searchEvent(@Param("letter") String letter);
}
