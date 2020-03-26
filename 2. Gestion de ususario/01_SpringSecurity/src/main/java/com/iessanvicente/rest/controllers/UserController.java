package com.iessanvicente.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iessanvicente.rest.dto.CreateUserDto;
import com.iessanvicente.rest.dto.converters.UserDtoConverter;
import com.iessanvicente.rest.services.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserEntityService userService;
	private final UserDtoConverter dtoConverter;
	
	@PostMapping("/")
	public ResponseEntity<?> newUser(@RequestBody CreateUserDto user){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(dtoConverter.convertToDto(userService.newUser(user)));
		
	}
}
