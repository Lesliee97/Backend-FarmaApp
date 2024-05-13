package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.CategoriaMed;
import com.upn.farmaappback.model.Direccione;
import com.upn.farmaappback.model.Medicamento;
import com.upn.farmaappback.model.Usuario;
import com.upn.farmaappback.model.repository.DireccionRepository;
import com.upn.farmaappback.model.repository.UsuarioRepository;
import com.upn.farmaappback.service.IDireccion;
import com.upn.farmaappback.service.dto.DireccionesDTO;
import com.upn.farmaappback.service.dto.MedicamentoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements IDireccion {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<DireccionesDTO> getAllDirecciones(Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            List<Direccione> direcciones = this.direccionRepository.findByIdUsuario(usuario);

            List<DireccionesDTO> response = new ArrayList<>();
            direcciones.forEach(direccion -> {
                DireccionesDTO direccionesDTO = new DireccionesDTO();
                direccionesDTO.setId(direccion.getId());
                direccionesDTO.setNombre(direccion.getNombre());
                direccionesDTO.setReferencia(direccion.getReferencia());
                direccionesDTO.setCalle(direccion.getCalle());
                direccionesDTO.setNumero(direccion.getNumero());
                direccionesDTO.setIndicaciones(direccion.getIndicaciones());
                direccionesDTO.setNum_contacto(direccion.getNumContacto());
                direccionesDTO.setIdUsuario(direccion.getIdUsuario().getId());

                response.add(direccionesDTO);
            });

            return response;
        } else {
            return Collections.emptyList();
        }
    }

}
