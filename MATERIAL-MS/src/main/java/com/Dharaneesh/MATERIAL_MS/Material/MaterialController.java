package com.Dharaneesh.MATERIAL_MS.Material;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<Material>> getMaterial()
    {
        return new ResponseEntity<>(materialService.getMaterial(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createMaterial(@RequestBody Material material)
    {
        materialService.createMaterial(material);
        return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
    }

    @GetMapping("/{materialId}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long materialId)
    {
        Material material=materialService.getMaterialById(materialId);

        if(material!=null)
        {
            return new ResponseEntity<>(material,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{materialId}")
    public ResponseEntity<String> updateMaterialById(@RequestBody Material material,@PathVariable Long materialId)
    {
        boolean Result=materialService.updateMaterialById(material,materialId);

        if(Result)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("BAD_REQUEST",HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{materialId}")
    public ResponseEntity<String> deleteMaterialById(@PathVariable Long materialId)
    {
        boolean Result=materialService.deleteMaterialById(materialId);

        if(Result)
        {
            return new ResponseEntity<>("DELETED SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("BAD_REQUEST",HttpStatus.BAD_REQUEST);
        }
    }

}
