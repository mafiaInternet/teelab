package com.example.teelab.model.dao;

import com.example.teelab.model.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherDao extends JpaRepository<Voucher, Integer> {
}
