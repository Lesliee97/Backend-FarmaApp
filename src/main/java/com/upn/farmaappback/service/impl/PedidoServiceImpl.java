package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.repository.PedidoRepository;
import com.upn.farmaappback.service.IPedido;
import com.upn.farmaappback.service.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PedidoServiceImpl implements IPedido {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<PedidoDTO> getAllPedidos() {
        final List<PedidoDTO> pedidoDTOList = new ArrayList<>();
        this.pedidoRepository.findAll().forEach(pedido -> {
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setId(pedido.getId());
            pedidoDTO.setEstado(pedido.getEstado());
            pedidoDTO.setCostoEnvio(pedido.getCostoEnvio());
            pedidoDTO.setFecha(pedido.getFecha());
            pedidoDTO.setIdUsuario(pedido.getIdUsuario().getId());
            pedidoDTO.setIdDireccion(pedido.getIdDireccion().getId());
            pedidoDTO.setCodReceta(pedido.getCodReceta());


            pedidoDTOList.add(pedidoDTO);
        });

        Collections.sort(pedidoDTOList, Comparator.comparing(PedidoDTO::getFecha).reversed());

        return pedidoDTOList;
    }

}
