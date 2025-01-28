package com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties.MaterialPropertiesServiceImp;

import com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties.MaterialProperties;
import com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties.MaterialPropertiesRepository;
import com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties.MaterialPropertiesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialPropertiesServiceimp implements MaterialPropertiesService {

    private final MaterialPropertiesRepository materialPropertiesRepository;

    public MaterialPropertiesServiceimp(MaterialPropertiesRepository materialPropertiesRepository) {
        this.materialPropertiesRepository = materialPropertiesRepository;
    }


    @Override
    public List<MaterialProperties> getProperties(Long shapeId) {

        return materialPropertiesRepository.findByShapeId(shapeId);
    }

    @Override
    public boolean createProperties(Long shapeId, MaterialProperties materialProperties) {

        if(shapeId!=null && materialProperties!=null)
        {
            materialProperties.setShapeId(shapeId);
            materialPropertiesRepository.save(materialProperties);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public MaterialProperties getPropertiesMyId(Long propertiesId) {

        return materialPropertiesRepository.findById(propertiesId).orElse(null);
    }

    @Override
    public boolean updatePropertiesById(MaterialProperties materialProperties, Long propertiesId) {

        Optional<MaterialProperties> materialPropertiesOptional=materialPropertiesRepository.findById(propertiesId);

        if(materialPropertiesOptional.isPresent())
        {
            MaterialProperties materialProperties1=materialPropertiesOptional.get();
            materialProperties1.setDensity(materialProperties.getDensity());
            materialProperties1.setHardness(materialProperties.getHardness());
            materialProperties1.setTensilestrength(materialProperties.getTensilestrength());
            materialProperties1.setCompressivestrength(materialProperties.getCompressivestrength());
            materialProperties1.setYieldstrength(materialProperties.getYieldstrength());
            materialProperties1.setThermalconductivity(materialProperties.getThermalconductivity());
            materialProperties1.setElectricalconductivity(materialProperties.getElectricalconductivity());
            materialProperties1.setWeldability(materialProperties.getWeldability());
            materialPropertiesRepository.save(materialProperties1);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deletePropertiesById(Long propertiesId) {

        if(materialPropertiesRepository.existsById(propertiesId))
        {
            materialPropertiesRepository.deleteById(propertiesId);
            return true;
        }
        else
        {
            return false;
        }
    }
}
