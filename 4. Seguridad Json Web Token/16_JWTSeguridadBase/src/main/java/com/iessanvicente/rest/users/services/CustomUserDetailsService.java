package com.iessanvicente.rest.users.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iessanvicente.rest.users.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final UserEntityService userEntityService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userEntityService.findUserByUsername(username)
					.orElseThrow(()-> new UsernameNotFoundException(username + " no encontrado"));
	}
	
	public UserEntity loadUserById(long id) throws UsernameNotFoundException {
		return userEntityService.findById(id)
				.orElseThrow(()-> new UsernameNotFoundException("No se ha encontrado un usuario con el ID: "+ id));
	}

}
