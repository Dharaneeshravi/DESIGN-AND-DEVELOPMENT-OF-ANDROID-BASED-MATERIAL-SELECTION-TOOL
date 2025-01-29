package com.Dharaneesh.MATERIAL_MS.Material.FeignClient;

import com.Dharaneesh.MATERIAL_MS.Material.External.MaterialProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "MATERIAL-PROPERTIES-MS")
public interface MaterialPropertiesClient {

    @GetMapping("/properties?shapeId=")
    public List<MaterialProperties> getMaterialProperties(@RequestParam Long shapeId);
}
