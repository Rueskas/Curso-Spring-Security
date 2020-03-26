package com.iessanvicente.rest.users.dto.converters;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.iessanvicente.rest.users.dto.GetUserDto;
import com.iessanvicente.rest.users.models.UserEntity;
import com.iessanvicente.rest.users.models.UserRole;

@Component
public class UserDtoConverter {

	public GetUserDto convertToDto(UserEntity user) {
		return GetUserDto.builder()
				.username(user.getUsername())
				.roles(user.getRoles().stream()
						.map(UserRole::name)
						.collect(Collectors.toSet()))
				.avatar(user.getAvatar())
				.build();
	}
	
}
