package com.Dharaneesh.MATERIAL_MS.Material;

import com.Dharaneesh.MATERIAL_MS.Material.DTO.MaterialDTO;

import java.util.List;

public interface MaterialService {

    List<MaterialDTO> getMaterial();

    void createMaterial(Material material);

    Material getMaterialById(Long materialId);

    boolean updateMaterialById(Material material,Long materialId);

    boolean deleteMaterialById(Long materialId);
}
