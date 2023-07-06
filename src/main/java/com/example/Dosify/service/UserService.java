
package com.example.Dosify.service;

import com.example.Dosify.dto.RequestDTO.UserRequestDto;
import com.example.Dosify.dto.ResponseDTO.UserResponseDto;
import com.example.Dosify.model.User;

import java.util.List;

public interface UserService {

    public UserResponseDto addUser(UserRequestDto userRequestDto);


    public String getByEmailId(String emailId);

    public String updateName(String contactNo, String name);

    public List<String> getAllUser();

    List<String> getNameDose1();
}
