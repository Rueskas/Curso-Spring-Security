package com.iessanvicente.rest.service;

import org.springframework.stereotype.Service;

import com.iessanvicente.rest.modelo.Pedido;
import com.iessanvicente.rest.repos.PedidoRepositorio;
import com.iessanvicente.rest.service.base.BaseService;

@Service
public class PedidoServicio extends BaseService<Pedido, Long, PedidoRepositorio> {

}
