package com.example.Dosify.service.Impl;

import com.example.Dosify.dto.RequestDTO.UserRequestDto;
import com.example.Dosify.dto.ResponseDTO.UserResponseDto;
import com.example.Dosify.model.User;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.UserService;
import com.example.Dosify.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        // change request dto to entity

//        User user = new User();
//
//        user.setName(userRequestDto.getName());
//        user.setAge(userRequestDto.getAge());
//        user.setContactNo(userRequestDto.getContactNo());
//        user.setEmailId(userRequestDto.getEmailId());
//        user.setGender(userRequestDto.getGender());
//
//        userRepository.save(user);

        // builder annotation

        User user = UserTransformer.userRequestDtoToUser(userRequestDto);

        User savedUser = userRepository.save(user);


        // change enitity to response dto

        UserResponseDto userResponseDto = UserTransformer.userToUserResponseDto(savedUser);

//        userResponseDto.setName(user.getName());
//        userResponseDto.setMessage("Congrats! You have been registered on Dosify");

        return userResponseDto;
    }

    @Override
    public String getByEmailId(String emailId) {

        List<User> users = userRepository.findAll();

        for(User user : users){
            if (user.getEmailId().equals(emailId)) {

                return user.getName();
            }
        }
        return "User does not exist";
    }

    @Override
    public String updateName(String contactNo, String name) {

        List<User> users = userRepository.findAll();

        for(User user : users){
            if (user.getContactNo().equals(contactNo)) {

                user.setName(name);
                userRepository.save(user);

            }
        }
        return "Name updated";
    }

    @Override
    public List<String> getAllUser() {
        List<User> users = userRepository.findAll();

        List<String> names = new ArrayList<>();

        for(User user : users){
            if(user.isDose1Taken() == false && user.isDose2Taken() == false){

                names.add(user.getName());
            }
        }
        return names;
    }

    @Override
    public List<String> getNameDose1() {

        List<User> users = userRepository.findAll();

        List<String> names = new ArrayList<>();

        for(User user : users){
            if(user.isDose1Taken() == true && user.isDose2Taken() == false){

                names.add(user.getName());
            }
        }
        return names;
    }


}
