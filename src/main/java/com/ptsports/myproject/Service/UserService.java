package com.ptsports.myproject.Service;


import com.ptsports.myproject.DTO.PageDto;
import com.ptsports.myproject.DTO.UserDto;

public interface UserService {

   void createUser(UserDto userDto);
   UserDto updateUser(UserDto user, Integer userId);
   UserDto getUserById(Integer userId);
   PageDto<UserDto> getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
   void deleteUser(Integer userId);

   UserDto findByEmail(String email) ;

   UserDto updateAvatar(UserDto userDto, Integer userId);

   UserDto registerUser(UserDto userDto);

   void updatePassword(UserDto userDTO);


   int count();


}
