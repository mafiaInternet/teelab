package com.example.teelab.service;

import com.example.teelab.exception.UserException;
import com.example.teelab.model.entity.Address;
import com.example.teelab.model.entity.User;
import com.example.teelab.request.AddressRequest;

import java.util.List;

public interface UserService {
//    public User findUserById(Long userId) throws UserException;

    User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;

    User findUserAdmin(String jwt) throws Exception;

    User findUserByEmail(String email);

    Address addAddress(User user, AddressRequest req) throws UserException;

    String deleteAddress(User user, long addressId);

    Address updateAddress(User user, int addressId, AddressRequest req)throws UserException;
}
