package com.iessanvicente.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iessanvicente.rest.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
