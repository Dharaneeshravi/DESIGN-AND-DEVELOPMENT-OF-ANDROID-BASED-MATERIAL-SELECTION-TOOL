package com.Dharaneesh.MATERIAL_MS.Material.MaterialServiceImp;

import com.Dharaneesh.MATERIAL_MS.Material.Material;
import com.Dharaneesh.MATERIAL_MS.Material.MaterialRepository;
import com.Dharaneesh.MATERIAL_MS.Material.MaterialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceimp implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceimp(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> getMaterial() {

        return materialRepository.findAll();
    }

    @Override
    public void createMaterial(Material material) {

        materialRepository.save(material);
    }

    @Override
    public Material getMaterialById(Long materialId) {

        return materialRepository.findById(materialId).orElse(null);
    }

    @Override
    public boolean updateMaterialById(Material material,Long materialId) {

        Optional<Material> optionalMaterial=materialRepository.findById(materialId);

        if(optionalMaterial.isPresent())
        {
            Material material1=optionalMaterial.get();
            material1.setMaterialname(material.getMaterialname());
            material1.setMaterialtype(material.getMaterialtype());
            material1.setGrade(material.getGrade());
            material1.setHeattreatment(material.getHeattreatment());
            material1.setFinishtype(material.getFinishtype());
            material1.setReference(material.getReference());;
            materialRepository.save(material1);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteMaterialById(Long materialId) {

        if(materialRepository.existsById(materialId))
        {
            materialRepository.deleteById(materialId);
            return true;
        }
        else
        {
            return false;
        }
    }
}
