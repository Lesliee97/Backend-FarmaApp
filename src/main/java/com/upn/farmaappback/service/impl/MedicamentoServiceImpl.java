package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.Medicamento;
import com.upn.farmaappback.model.repository.MedicamentoRepository;
import com.upn.farmaappback.service.IMedicamento;
import com.upn.farmaappback.service.dto.MedicamentoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentoServiceImpl implements IMedicamento {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

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

}
