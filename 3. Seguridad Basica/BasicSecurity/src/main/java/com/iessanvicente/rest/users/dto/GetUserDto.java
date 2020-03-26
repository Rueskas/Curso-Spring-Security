package com.iessanvicente.rest.users.dto;

import java.util.Set;

import com.iessanvicente.rest.users.models.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserDto {
	private String username;
	private String avatar;
	private String fullName;
	private String email;
	private Set<String> roles;

}
