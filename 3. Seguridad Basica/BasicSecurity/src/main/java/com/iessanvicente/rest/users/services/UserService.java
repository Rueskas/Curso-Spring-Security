package com.iessanvicente.rest.users.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.iessanvicente.rest.error.NewUserWithDifferentPasswordsException;
import com.iessanvicente.rest.service.base.BaseService;
import com.iessanvicente.rest.users.dto.CreateUserDto;
import com.iessanvicente.rest.users.models.UserEntity;
import com.iessanvicente.rest.users.models.UserRole;
import com.iessanvicente.rest.users.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<UserEntity, Long, UserRepository>{

	private final PasswordEncoder passwordEncoder;
	
	public Optional<UserEntity> findByUsername(String username){
		return this.repositorio.findByUsername(username);
	}
	
	public UserEntity newUser(CreateUserDto user) {
		if(user.getPassword().contentEquals(user.getPassword2())) {
			UserEntity userEntity = UserEntity.builder()
					.username(user.getUsername())
					.password(user.getPassword())
					.avatar(user.getAvatar())
					.roles(Stream.of(UserRole.USER).collect(Collectors.toSet()))
					.build();
			try {
				return save(userEntity);
			} catch(DataIntegrityViolationException ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
			}
		} else {
			throw new NewUserWithDifferentPasswordsException();
		}
	}
}
