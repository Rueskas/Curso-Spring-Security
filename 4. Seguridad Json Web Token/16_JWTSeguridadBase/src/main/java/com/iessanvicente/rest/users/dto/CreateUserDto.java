package com.iessanvicente.rest.users.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateUserDto {
	
	@NotBlank
	private String username;
	private String avatar;
	private String fullname;
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String password2;

}
