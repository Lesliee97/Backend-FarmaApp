package com.upn.farmaappback.service;

import com.upn.farmaappback.service.dto.DireccionDTO;

import java.util.List;

public interface IDireccion {
    List<DireccionDTO> getAllDirecciones(Long  idUsuario);
    DireccionDTO saveDireccion(DireccionDTO direccion);
}
