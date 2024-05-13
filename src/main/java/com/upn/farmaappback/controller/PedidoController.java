package com.upn.farmaappback.controller;

import com.upn.farmaappback.service.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    private IPedido iPedido;

    @GetMapping(value = "getAllPedidos")
    public ResponseEntity<Object> getAllPedidos() {
        return ResponseEntity.ok(iPedido.getAllPedidos());
    }
}
