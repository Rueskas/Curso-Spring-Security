package com.iessanvicente.rest.users.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iessanvicente.rest.users.model.UserEntity;
import com.iessanvicente.rest.users.model.UserRole;

@Component
public class UserDtoConverter {
	
	public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
		return GetUserDto.builder()
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.fullName(user.getFullName())
				.email(user.getEmail())
				.roles(user.getRoles().stream()
							.map(UserRole::name)
							.collect(Collectors.toSet())
				).build();
	}

	public UserResponse convertToUserResponse(UserEntity user, String jwtToken) {
		return UserResponse.jwtUserResponseBuilder()
				.username(user.getUsername())
				.email(user.getEmail())
				.fullName(user.getFullName())
				.avatar(user.getAvatar())
				.roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
				.token(jwtToken)
				.build();
	}

}
