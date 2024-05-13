package com.upn.farmaappback.service;

import com.upn.farmaappback.service.dto.MedicamentoInStockDTO;
import com.upn.farmaappback.service.dto.MedicamentoResponseDto;

import java.util.List;

public interface IMedicamento {
    List<MedicamentoResponseDto> getAllMedicamentoEnStock();
    List<MedicamentoInStockDTO>  getAllMedicamentoInStockById(Long id);
    List<MedicamentoResponseDto> getAllMedicamentosByCategoria(Long idCategoria);
    List<MedicamentoResponseDto> getAllMedicamentosByNombre(String nombre);
}
