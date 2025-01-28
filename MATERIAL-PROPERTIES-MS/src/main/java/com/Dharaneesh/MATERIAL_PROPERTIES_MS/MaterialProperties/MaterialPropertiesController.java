package com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/properties")
public class MaterialPropertiesController {

    private MaterialPropertiesService materialPropertiesService;

    public MaterialPropertiesController(MaterialPropertiesService materialPropertiesService) {
        this.materialPropertiesService = materialPropertiesService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialProperties>> getProperties(@RequestParam Long shapeId)
    {
        return new ResponseEntity<>(materialPropertiesService.getProperties(shapeId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createProperties(@RequestParam Long shapeId,@RequestBody MaterialProperties materialProperties)
    {
        boolean Result=materialPropertiesService.createProperties(shapeId,materialProperties);

        if(Result)
        {
            return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("BAD_REQUEST",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{propertiesId}")
    public ResponseEntity<MaterialProperties> getPropertiesMyId(@PathVariable Long propertiesId)
    {
        MaterialProperties Result=materialPropertiesService.getPropertiesMyId(propertiesId);

        if(Result!=null)
        {
            return new ResponseEntity<>(Result,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{propertiesId}")
    public ResponseEntity<String> updatePropertiesById(@RequestBody MaterialProperties materialProperties,@PathVariable Long propertiesId)
    {
        boolean Result=materialPropertiesService.updatePropertiesById(materialProperties,propertiesId);

        if(Result)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("BAD_REQUEST",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{propertiesId}")
    public ResponseEntity<String> deletePropertiesById(@PathVariable Long propertiesId)
    {
        boolean Result=materialPropertiesService.deletePropertiesById( propertiesId);

        if(Result)
        {
            return new ResponseEntity<>("DELETED SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
