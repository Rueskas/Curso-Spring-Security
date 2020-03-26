package com.iessanvicente.rest.service;

import org.springframework.stereotype.Service;

import com.iessanvicente.rest.modelo.Categoria;
import com.iessanvicente.rest.repos.CategoriaRepositorio;
import com.iessanvicente.rest.service.base.BaseService;

@Service
public class CategoriaServicio extends BaseService<Categoria, Long, CategoriaRepositorio>{

}
