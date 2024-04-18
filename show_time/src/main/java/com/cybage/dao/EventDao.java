package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cybage.entity.EventEntity;

public interface EventDao extends JpaRepository<EventEntity, Integer> {

    List<EventEntity> findByCity(String city);
    List<EventEntity> findByGenre(String genre);
    
    @Query("SELECT e FROM EventEntity e WHERE e.price > 0 AND e.price <= 300")
    List<EventEntity> findByPriceRange0To300();

    @Query("SELECT e FROM EventEntity e WHERE e.price > 300 AND e.price <= 500")
    List<EventEntity> findByPriceRange300To500();

    @Query("SELECT e FROM EventEntity e WHERE e.price > 500 AND e.price <= 900")
    List<EventEntity> findByPriceRange500To900();

    @Query("SELECT e FROM EventEntity e WHERE e.price > 900")
    List<EventEntity> findByPriceAbove900();

}
