package com.example.teelab.service.Impl;

import com.example.teelab.config.JwtProvider;
import com.example.teelab.exception.UserException;
import com.example.teelab.model.dao.AddressDao;
import com.example.teelab.model.dao.UserDao;
import com.example.teelab.model.entity.Address;
import com.example.teelab.model.entity.User;
import com.example.teelab.request.AddressRequest;
import com.example.teelab.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private JwtProvider jwtProvider;
    private AddressDao addressDao;

    public UserServiceImpl(UserDao userDao, JwtProvider jwtProvider, AddressDao addressDao){
        this.userDao = userDao;
        this.jwtProvider = jwtProvider;
        this.addressDao = addressDao;
    }
    @Override
    public User findUserById(Long userId) throws UserException{
        System.out.println("find id " + userId);
        for(User user: userDao.findAll()){
            if(user.getId() == userId){
                return user;
            }
        }
        return null;
    }
//    public User findUserById(Long userId) throws UserException {
//        Optional<User>user=userDao.findById(userId);
//
//        if (user.isPresent()){
//            return user.get();
//        }
//        throw new UserException("User not foung with id - " + userId);
//
//    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {

        String email = jwtProvider.getEmailFromToken(jwt);
        System.out.println(email);
        User user=userDao.findByEmail(email);

        if(user==null){
            throw new UserException("User not found with email - "+email);
        }
        return user;
    }

    @Override
    public User findUserAdmin(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromToken(jwt);
        User user=userDao.findByEmail(email);

        if (user==null){
            throw new UserException("User not found with email - "+email);
        } else if (user.getRole() == null) {
            throw new UserException("User admin not found with email - "+ email);
        }

        return user;
    }

    @Override
    public User findUserByEmail(String email){

        User user = userDao.findByEmail(email);

        return user;
    }

    @Override
    public Address addAddress(User user, AddressRequest req) throws UserException{
        Address address = new Address();
        address.setUser(user.getId());
        address.setCity(req.getCity());
        address.setFirtname(req.getFirstName());
        address.setLastName(req.getLastName());
        addressDao.save(address);

        user.getAddress().add(address);
        userDao.save(user);
        return address;
    }



    @Override
    public String deleteAddress(User user, long addressId) {
        addressDao.deleteById(addressId);
        return "Delete address - user id " + user.getId() + "success !!!";
    }


    @Override
    public Address updateAddress(User user, int addressId, AddressRequest req)throws UserException{
        for(Address address: user.getAddress()){
            if(address.getState().equals("Mặc định")){
                address.setState("");
                addressDao.save(address);
            }
        }
        for(Address address:user.getAddress()){
            if(address.getId() == addressId){
                address.setCity(req.getCity());
                address.setFirtname(req.getFirstName());
                address.setLastName(req.getLastName());
                address.setState(req.getState());
                return addressDao.save(address);
            }
        }
        return null;
    }
}
