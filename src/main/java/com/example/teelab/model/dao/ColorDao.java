package com.example.teelab.model.dao;

import com.example.teelab.model.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color, Integer> {
}
