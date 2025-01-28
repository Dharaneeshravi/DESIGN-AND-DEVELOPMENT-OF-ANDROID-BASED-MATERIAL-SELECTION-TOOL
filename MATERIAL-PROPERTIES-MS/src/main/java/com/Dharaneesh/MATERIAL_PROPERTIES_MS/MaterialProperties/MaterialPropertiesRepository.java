package com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MaterialPropertiesRepository extends JpaRepository<MaterialProperties, Long> {
    List<MaterialProperties> findByShapeId(Long shapeId);
}
