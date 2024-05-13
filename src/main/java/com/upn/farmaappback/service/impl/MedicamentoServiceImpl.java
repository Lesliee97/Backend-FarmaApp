package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.CategoriaMed;
import com.upn.farmaappback.model.Medicamento;
import com.upn.farmaappback.model.repository.CategoriaRepository;
import com.upn.farmaappback.model.repository.MedicamentoRepository;
import com.upn.farmaappback.service.IMedicamento;
import com.upn.farmaappback.service.dto.MedicamentoInStockDTO;
import com.upn.farmaappback.service.dto.MedicamentoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicamentoServiceImpl implements IMedicamento {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<MedicamentoResponseDto> getAllMedicamentoEnStock() {

        final List<MedicamentoResponseDto> response = new ArrayList<>();

        this.medicamentoRepository.findAll().forEach(medicamento -> {
            MedicamentoResponseDto medicamentoResponse = new MedicamentoResponseDto();
            medicamentoResponse.setId(medicamento.getId());
            medicamentoResponse.setNombre(medicamento.getNombre());
            medicamentoResponse.setFormaFarmaceutica(medicamento.getFormaFarmaceutica());
            medicamentoResponse.setPrecioUnitario(medicamento.getPrecioUnitario());
            medicamentoResponse.setStock(medicamento.getStock());
            medicamentoResponse.setNombreCategoria(medicamento.getIdCategoria().getNombre());

            response.add(medicamentoResponse);
        });

        return response;
    }

    @Override
    public List<MedicamentoInStockDTO> getAllMedicamentoInStockById(Long id) {

        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);

        if (medicamentoOptional.isPresent()) {
            Medicamento medicamento = medicamentoOptional.get();

            // Verificar si el stock es mayor a 0
            if (medicamento.getStock() > 0) {
                // Crear el DTO de medicamento en stock
                MedicamentoInStockDTO medicamentoInStockDTO = new MedicamentoInStockDTO();
                medicamentoInStockDTO.setId(medicamento.getId());
                medicamentoInStockDTO.setNombre(medicamento.getNombre());
                medicamentoInStockDTO.setConcentracion(medicamento.getConcentracion());
                medicamentoInStockDTO.setFormaFarmaceutica(medicamento.getFormaFarmaceutica());
                medicamentoInStockDTO.setPrecioUnitario(medicamento.getPrecioUnitario());
                medicamentoInStockDTO.setStock(medicamento.getStock());
                medicamentoInStockDTO.setPrincipioActivo(medicamento.getPrincipioActivo());
                medicamentoInStockDTO.setEs_restringido(medicamento.getEsRestringido());
                medicamentoInStockDTO.setNombreCategoria(medicamento.getIdCategoria().getNombre());

                return List.of(medicamentoInStockDTO);
            } else {
                // Devolver una lista vacía si el stock es 0
                return Collections.emptyList();
            }
        } else {
            // Devolver una lista vacía si el medicamento no existe
            return Collections.emptyList();
        }
    }

    @Override
    public List<MedicamentoResponseDto> getAllMedicamentosByCategoria(Long idCategoria) {
        Optional<CategoriaMed> categoriaOptional = categoriaRepository.findById(idCategoria);

        if (categoriaOptional.isPresent()) {
            CategoriaMed categoriaMed = categoriaOptional.get();

            List<Medicamento> medicamentos = this.medicamentoRepository.findMedicamentoByIdCategoria(categoriaMed);

            List<MedicamentoResponseDto> response = new ArrayList<>();
            medicamentos.forEach(medicamento -> {
                MedicamentoResponseDto medicamentoResponseDto = new MedicamentoResponseDto();
                medicamentoResponseDto.setId(medicamento.getId());
                medicamentoResponseDto.setNombre(medicamento.getNombre());
                medicamentoResponseDto.setFormaFarmaceutica(medicamento.getFormaFarmaceutica());
                medicamentoResponseDto.setPrecioUnitario(medicamento.getPrecioUnitario());
                medicamentoResponseDto.setStock(medicamento.getStock());
                medicamentoResponseDto.setNombreCategoria(medicamento.getIdCategoria().getNombre());
                response.add(medicamentoResponseDto);
            });

            return response;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<MedicamentoResponseDto> getAllMedicamentosByNombre(String nombre) {
        List<Medicamento> medicamentos = medicamentoRepository.findMedicamentoByNombre(nombre);

        if (!medicamentos.isEmpty()) {

            List<MedicamentoResponseDto> response = new ArrayList<>();

            medicamentos.forEach(medicamento -> {
                MedicamentoResponseDto medicamentoResponseDto = new MedicamentoResponseDto();
                medicamentoResponseDto.setId(medicamento.getId());
                medicamentoResponseDto.setNombre(medicamento.getNombre());
                medicamentoResponseDto.setFormaFarmaceutica(medicamento.getFormaFarmaceutica());
                medicamentoResponseDto.setPrecioUnitario(medicamento.getPrecioUnitario());
                medicamentoResponseDto.setStock(medicamento.getStock());
                medicamentoResponseDto.setNombreCategoria(medicamento.getIdCategoria().getNombre());
                response.add(medicamentoResponseDto);
            });

            return response;
        } else {
            return Collections.emptyList();
        }
    }
}
