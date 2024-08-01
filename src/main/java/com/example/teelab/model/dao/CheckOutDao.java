package com.example.teelab.model.dao;

import com.example.teelab.model.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckOutDao extends JpaRepository<CheckOut, Integer> {
}
