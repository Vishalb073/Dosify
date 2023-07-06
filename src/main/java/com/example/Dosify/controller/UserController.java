package com.example.Dosify.controller;


import com.example.Dosify.dto.RequestDTO.UserRequestDto;
import com.example.Dosify.dto.ResponseDTO.UserResponseDto;
import com.example.Dosify.model.User;
import com.example.Dosify.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequestDto userRequestDto){

        UserResponseDto savedUser = userService.addUser(userRequestDto);
        return new ResponseEntity(savedUser, HttpStatus.CREATED);
    }

    // find by emailId
    @GetMapping("/get-by-emailid")
    public ResponseEntity<String> getByEmailId(@RequestParam("emailId")String emailId){

        String name = userService.getByEmailId(emailId);

        return new ResponseEntity<>(name, HttpStatus.CREATED);
    }

    // update the name of the user by mobNo
    @PutMapping("/update-by-mobno")
    public String updateName(@RequestParam("contactNo")String contactNo, @RequestParam("name")String name){

        String str = userService.updateName(contactNo, name);

        return str;
    }

    // find all the users who have not taken even a single dose
    @GetMapping("/get-all-users")
    public List<String> getAllUsers(){

        List<String> users = userService.getAllUser();

        return users;
    }

    // all users who have taken dose1 but not dose2
    @GetMapping("/dose1")
    public List<String> getNameDose1(){

        List<String> names = userService.getNameDose1();

        return names;
    }

    // all users who are fully vaccinated


    // all male users who have not taken even a single vaccine

    // all female users who are fully vaccinated


}
