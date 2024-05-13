package com.upn.farmaappback.service;

import com.upn.farmaappback.model.MedFavUsuario;
import com.upn.farmaappback.service.dto.MedFavUsuarioRequestDTO;

public interface IMedFavUsuario {

    MedFavUsuarioRequestDTO saveMedFavUsuario(MedFavUsuarioRequestDTO medFavUsuarioRequestDTO);


}
