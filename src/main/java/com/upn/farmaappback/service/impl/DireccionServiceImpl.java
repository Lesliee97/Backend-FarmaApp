package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.Direccione;
import com.upn.farmaappback.model.Usuario;
import com.upn.farmaappback.model.repository.DireccionRepository;
import com.upn.farmaappback.model.repository.UsuarioRepository;
import com.upn.farmaappback.service.IDireccion;
import com.upn.farmaappback.service.dto.DireccionDTO;
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
    public List<DireccionDTO> getAllDirecciones(Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            List<Direccione> direcciones = this.direccionRepository.findByIdUsuario(usuario);

            List<DireccionDTO> response = new ArrayList<>();
            direcciones.forEach(direccion -> {
                DireccionDTO direccionDTO = new DireccionDTO();
                direccionDTO.setId(direccion.getId());
                direccionDTO.setNombre(direccion.getNombre());
                direccionDTO.setReferencia(direccion.getReferencia());
                direccionDTO.setCalle(direccion.getCalle());
                direccionDTO.setNumero(direccion.getNumero());
                direccionDTO.setIndicaciones(direccion.getIndicaciones());
                direccionDTO.setNumContacto(direccion.getNumContacto());
                direccionDTO.setIdUsuario(direccion.getIdUsuario().getId());

                response.add(direccionDTO);
            });

            return response;
        } else {
            return Collections.emptyList();
        }
    }

    public DireccionDTO saveDireccion(DireccionDTO direccionDTO) {
        // Convertir DireccionDTO a modelo Direccione
        Direccione direccion = new Direccione();
        direccion.setNombre(direccionDTO.getNombre());
        direccion.setReferencia(direccionDTO.getReferencia());
        direccion.setCalle(direccionDTO.getCalle());
        direccion.setNumero(direccionDTO.getNumero());
        direccion.setIndicaciones(direccionDTO.getIndicaciones());
        direccion.setNumContacto(direccionDTO.getNumContacto());

        //varificar si el usuario existe
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(direccionDTO.getIdUsuario());
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            direccion.setIdUsuario(usuario); // Asignar el usuario a la dirección
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        //Asignar el usuario a la direccion
        Direccione direccionGuardada = direccionRepository.save(direccion);

        //Guardar la direccion
        DireccionDTO direccionGuardadaDTO = new DireccionDTO();

        // Convertir Direccione a DireccionDTO y devolverlo
        direccionGuardadaDTO.setId(direccionGuardada.getId());
        direccionGuardadaDTO.setNombre(direccionGuardada.getNombre());
        direccionGuardadaDTO.setReferencia(direccionGuardada.getReferencia());
        direccionGuardadaDTO.setCalle(direccionGuardada.getCalle());
        direccionGuardadaDTO.setNumero(direccionGuardada.getNumero());
        direccionGuardadaDTO.setIndicaciones(direccionGuardada.getIndicaciones());
        direccionGuardadaDTO.setNumContacto(direccionGuardada.getNumContacto());
        direccionGuardadaDTO.setIdUsuario(direccionGuardada.getIdUsuario().getId());

        return direccionGuardadaDTO;
    }

}
