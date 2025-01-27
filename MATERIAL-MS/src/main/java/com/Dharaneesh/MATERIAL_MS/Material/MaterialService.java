package com.Dharaneesh.MATERIAL_MS.Material;

import java.util.List;

public interface MaterialService {

    List<Material> getMaterial();

    void createMaterial(Material material);

    Material getMaterialById(Long materialId);

    boolean updateMaterialById(Material material,Long materialId);

    boolean deleteMaterialById(Long materialId);
}
