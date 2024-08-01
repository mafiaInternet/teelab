package com.example.teelab.service.Impl;

import com.example.teelab.model.dao.VoucherDao;
import com.example.teelab.model.entity.Voucher;
import com.example.teelab.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherImpl implements VoucherService {
    @Autowired
    private VoucherDao voucherDao;



}
