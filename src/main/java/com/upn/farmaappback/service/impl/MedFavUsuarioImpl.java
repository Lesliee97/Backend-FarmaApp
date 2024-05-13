package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.MedFavUsuario;
import com.upn.farmaappback.model.Medicamento;
import com.upn.farmaappback.model.Usuario;
import com.upn.farmaappback.model.repository.MedFavUsuarioRepository;
import com.upn.farmaappback.model.repository.MedicamentoRepository;
import com.upn.farmaappback.model.repository.UsuarioRepository;
import com.upn.farmaappback.service.IMedFavUsuario;
import com.upn.farmaappback.service.dto.MedFavUsuarioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public MedFavUsuarioRequestDTO saveMedFavUsuario(MedFavUsuarioRequestDTO medFavUsuarioRequestDTO) {

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

       // Guardar medFavUsuario
       MedFavUsuario guardado =  medFavUsuarioRepository.save(medFavUsuario);

       MedFavUsuarioRequestDTO medFavUsuarioRequestSave= new MedFavUsuarioRequestDTO();

       medFavUsuarioRequestSave.setIdUsuario(guardado.getIdUsuario().getId());
       medFavUsuarioRequestSave.setIdMedicamento(guardado.getIdMedicamentos().getId());

       return medFavUsuarioRequestSave;
    }
}
