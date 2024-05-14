package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.MedFavUsuario;
import com.upn.farmaappback.model.Medicamento;
import com.upn.farmaappback.model.Usuario;
import com.upn.farmaappback.model.repository.MedFavUsuarioRepository;
import com.upn.farmaappback.model.repository.MedicamentoRepository;
import com.upn.farmaappback.model.repository.UsuarioRepository;
import com.upn.farmaappback.service.IMedFavUsuario;
import com.upn.farmaappback.service.dto.MedFavUsuarioRequestDTO;
import com.upn.farmaappback.service.dto.MedFavUsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedFavUsuarioImpl implements IMedFavUsuario {

    @Autowired
    private MedFavUsuarioRepository medFavUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

   @Override
    public MedFavUsuarioResponseDTO saveMedFavUsuario(MedFavUsuarioRequestDTO medFavUsuarioRequestDTO) {

       // Buscar el usuario por su ID
       Optional<Usuario> usuarioOptional = usuarioRepository.findById(medFavUsuarioRequestDTO.getIdUsuario());
       Usuario usuario = usuarioOptional.orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

       // Buscar el medicamento por su ID
       Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(medFavUsuarioRequestDTO.getIdMedicamento());
       Medicamento medicamento = medicamentoOptional.orElseThrow(() -> new IllegalArgumentException("Medicamento no encontrado"));

       // Convertir de DTO a modelo
       MedFavUsuario medFavUsuario = new MedFavUsuario();
       medFavUsuario.setIdUsuario(usuario);
       medFavUsuario.setIdMedicamentos(medicamento);
       medFavUsuario.setFecha(Instant.now());

       // Guardar medFavUsuario
       MedFavUsuario guardado =  medFavUsuarioRepository.save(medFavUsuario);

       MedFavUsuarioResponseDTO response= new MedFavUsuarioResponseDTO();

       response.setId(guardado.getId());
       response.setIdUsuario(guardado.getIdUsuario().getId());
       response.setIdMedicamento(guardado.getIdMedicamentos().getId());
       response.setFecha(guardado.getFecha());

       return response;
    }

    @Override
    public List<MedFavUsuarioResponseDTO> getAllMedFavByUsuario(Long idUsuario) {
        // Buscar el usuario por su ID
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        List<MedFavUsuario> favoritos = this.medFavUsuarioRepository.findMedFavUsuarioByIdUsuario(usuario);
        List<MedFavUsuarioResponseDTO> response = new ArrayList<MedFavUsuarioResponseDTO>();
        
        if(!favoritos.isEmpty()){
            MedFavUsuarioResponseDTO favoritoDTO = new MedFavUsuarioResponseDTO();
            
            favoritos.forEach(favorite -> {
                favoritoDTO.setId(favorite.getId());
                favoritoDTO.setIdUsuario(favorite.getIdUsuario().getId());
                favoritoDTO.setFecha(favorite.getFecha());
                favoritoDTO.setIdMedicamento(favorite.getIdMedicamentos().getId());

                response.add(favoritoDTO);
            });
        }

        return response;
    }
}
