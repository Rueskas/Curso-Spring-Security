package com.iessanvicente.rest.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iessanvicente.rest.users.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public Optional<UserEntity> findByUsername(String username);
}
