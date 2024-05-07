package com.upn.farmaappback.service;

import com.upn.farmaappback.service.dto.MedicamentoResponseDto;

import java.util.List;

public interface IMedicamento {
    List<MedicamentoResponseDto> getAllMedicamentoEnStock();
}
