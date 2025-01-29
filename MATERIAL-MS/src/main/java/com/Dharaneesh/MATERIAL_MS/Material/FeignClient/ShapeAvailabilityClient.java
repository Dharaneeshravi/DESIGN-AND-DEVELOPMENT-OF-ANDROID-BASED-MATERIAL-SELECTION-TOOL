package com.Dharaneesh.MATERIAL_MS.Material.FeignClient;

import com.Dharaneesh.MATERIAL_MS.Material.External.ShapeAvailability;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SHAPE-AVAILABILITY-MS")
public interface ShapeAvailabilityClient {

    @GetMapping("/shape/{shapeId}")
    public ShapeAvailability getShapeAvailability(@PathVariable Long shapeId);
}
