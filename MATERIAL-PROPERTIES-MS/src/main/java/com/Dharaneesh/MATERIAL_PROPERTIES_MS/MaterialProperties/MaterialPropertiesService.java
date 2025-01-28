package com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties;

import java.util.List;

public interface MaterialPropertiesService {


    List<MaterialProperties> getProperties(Long shapeId);

    boolean createProperties(Long shapeId, MaterialProperties materialProperties);

    MaterialProperties getPropertiesMyId(Long propertiesId);

    boolean updatePropertiesById(MaterialProperties materialProperties, Long propertiesId);

    boolean deletePropertiesById(Long propertiesId);
}
