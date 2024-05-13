package com.upn.farmaappback.service;

import com.upn.farmaappback.service.dto.DireccionesDTO;
import com.upn.farmaappback.service.dto.PedidoDTO;

import java.util.List;

public interface IDireccion {
    List<DireccionesDTO> getAllDirecciones(Long  idUsuario);
}
