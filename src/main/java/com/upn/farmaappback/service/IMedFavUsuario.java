package com.upn.farmaappback.service;

import com.upn.farmaappback.model.MedFavUsuario;
import com.upn.farmaappback.service.dto.MedFavUsuarioRequestDTO;
import com.upn.farmaappback.service.dto.MedFavUsuarioResponseDTO;

public interface IMedFavUsuario {

    MedFavUsuarioResponseDTO saveMedFavUsuario(MedFavUsuarioRequestDTO medFavUsuarioRequestDTO);
}
