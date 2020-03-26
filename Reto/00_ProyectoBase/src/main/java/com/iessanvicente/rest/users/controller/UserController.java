package com.iessanvicente.rest.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iessanvicente.rest.users.dto.CreateUserDto;
import com.iessanvicente.rest.users.dto.GetUserDto;
import com.iessanvicente.rest.users.dto.converters.UserDtoConverter;
import com.iessanvicente.rest.users.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	private final UserDtoConverter dtoConverter;
	
	@PostMapping("/")
	public ResponseEntity<?> newUser(@RequestBody CreateUserDto user){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(dtoConverter.convertToDto(userService.newUser(user)));
		
	}
}
