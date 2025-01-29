package com.Dharaneesh.MATERIAL_MS.Material.MaterialServiceImp;

import com.Dharaneesh.MATERIAL_MS.Material.DTO.MaterialDTO;
import com.Dharaneesh.MATERIAL_MS.Material.External.MaterialProperties;
import com.Dharaneesh.MATERIAL_MS.Material.External.ShapeAvailability;
import com.Dharaneesh.MATERIAL_MS.Material.Material;
import com.Dharaneesh.MATERIAL_MS.Material.MaterialRepository;
import com.Dharaneesh.MATERIAL_MS.Material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialServiceimp implements MaterialService {

    @Autowired
    private  RestTemplate restTemplate;

    private final MaterialRepository materialRepository;

    public MaterialServiceimp(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<MaterialDTO> getMaterial() {

        List<Material> materialList=materialRepository.findAll();
        return materialList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private MaterialDTO convertToDto(Material material)
    {
        MaterialDTO materialDTO =new MaterialDTO();
        materialDTO.setMaterial(material);
        ShapeAvailability shapeAvailability=restTemplate.getForObject("http://SHAPE-AVAILABILITY-MS:8082/shape/"+material.getShapeid(), ShapeAvailability.class);
        materialDTO.setShapeAvailability(shapeAvailability);
        ResponseEntity<List<MaterialProperties>> responseEntity=restTemplate.exchange("http://MATERIAL-PROPERTIES-MS:8083/properties?shapeId=" + material.getShapeid(), HttpMethod.GET, null, new ParameterizedTypeReference<List<MaterialProperties>>() {
        });
        List<MaterialProperties> materialProperties=responseEntity.getBody();
        List<MaterialProperties> materialProperties1=materialProperties;
        materialDTO.setMaterialProperties(materialProperties);
        return materialDTO;
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
