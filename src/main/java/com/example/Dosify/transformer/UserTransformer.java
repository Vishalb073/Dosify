package com.example.Dosify.transformer;

import com.example.Dosify.dto.RequestDTO.UserRequestDto;
import com.example.Dosify.dto.ResponseDTO.UserResponseDto;
import com.example.Dosify.model.User;

public class UserTransformer {

    public static User userRequestDtoToUser(UserRequestDto userRequestDto){

        return User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .gender(userRequestDto.getGender())
                .contactNo(userRequestDto.getContactNo())
                .emailId(userRequestDto.getEmailId())
                .build();

    }

    public static UserResponseDto userToUserResponseDto(User user){

        return UserResponseDto.builder()
                .name(user.getName())
                .message("Congrats! You have been registered on Dosify")
                .build();
    }
}
