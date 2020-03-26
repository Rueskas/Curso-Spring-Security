package com.iessanvicente.rest.users.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse extends GetUserDto {
	private String token;
	
	@Builder(builderMethodName="jwtUserResponseBuilder")
	public UserResponse(
			String username, String avatar, String fullName, String email, Set<String> roles, String token) {
		super(username, avatar, fullName, email, roles);
		this.token = token;
	}
	
}
