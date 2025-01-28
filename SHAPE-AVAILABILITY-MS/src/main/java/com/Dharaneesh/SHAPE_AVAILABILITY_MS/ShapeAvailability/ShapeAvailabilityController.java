package com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shape")
public class ShapeAvailabilityController {

    private final ShapeAvailabilityService shapeAvailabilityService;

    public ShapeAvailabilityController(ShapeAvailabilityService shapeAvailabilityService) {
        this.shapeAvailabilityService = shapeAvailabilityService;
    }

    @GetMapping
    public ResponseEntity<List<ShapeAvailability>> getShape()
    {
        return new ResponseEntity<>(shapeAvailabilityService.getShape(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createShape(@RequestBody ShapeAvailability shapeAvailability)
    {
        shapeAvailabilityService.createShape(shapeAvailability);
        return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
    }

    @GetMapping("/{shapeId}")
    public ResponseEntity<ShapeAvailability> getShapeById(@PathVariable Long shapeId)
    {
        ShapeAvailability Result=shapeAvailabilityService.getShapeById(shapeId);

        if(Result!=null)
        {
            return new ResponseEntity<>(Result,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{shapeId}")
    public ResponseEntity<String> updateShapeById(@PathVariable Long shapeId,@RequestBody ShapeAvailability shapeAvailability)
    {
        boolean Result=shapeAvailabilityService.updateShapeById(shapeId,shapeAvailability);

        if(Result)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("BAD_REQUEST",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{shapeId}")
    public ResponseEntity<String> deleteShapeById(@PathVariable Long shapeId)
    {

        boolean Result=shapeAvailabilityService.deleteShapeById(shapeId);

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
