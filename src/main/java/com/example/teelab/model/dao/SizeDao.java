package com.example.teelab.model.dao;

import com.example.teelab.model.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeDao extends JpaRepository<Size,Integer> {
}
