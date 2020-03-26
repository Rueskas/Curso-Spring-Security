package com.iessanvicente.rest.dto.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iessanvicente.rest.dto.GetUserDto;
import com.iessanvicente.rest.users.models.UserEntity;
import com.iessanvicente.rest.users.models.UserRole;

@Component
public class UserDtoConverter {
	public GetUserDto convertToDto(UserEntity user) {
		return GetUserDto.builder()
				.username(user.getUsername())
				.avatar(user.getAvatar())
				.roles(user.getRoles().stream()
						.map(UserRole::name)
						.collect(Collectors.toSet()))
				.build();
	}
}
