package com.Dharaneesh.MATERIAL_MS.Material.DTO;

import com.Dharaneesh.MATERIAL_MS.Material.External.MaterialProperties;
import com.Dharaneesh.MATERIAL_MS.Material.External.ShapeAvailability;
import com.Dharaneesh.MATERIAL_MS.Material.Material;

import java.util.List;

public class MaterialDTO {

    private Material material;
    private ShapeAvailability shapeAvailability;
    private List<MaterialProperties> materialProperties;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public ShapeAvailability getShapeAvailability() {
        return shapeAvailability;
    }

    public void setShapeAvailability(ShapeAvailability shapeAvailability) {
        this.shapeAvailability = shapeAvailability;
    }

    public List<MaterialProperties> getMaterialProperties() {
        return materialProperties;
    }

    public void setMaterialProperties(List<MaterialProperties> materialProperties) {
        this.materialProperties = materialProperties;
    }
}
