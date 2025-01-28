package com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability.ShapeAvailabilityServiceImp;

import com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability.ShapeAvailability;
import com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability.ShapeAvailabilityRepository;
import com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability.ShapeAvailabilityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShapeAvailabilityServiceimp implements ShapeAvailabilityService {

    private final ShapeAvailabilityRepository shapeAvailabilityRepository;

    public ShapeAvailabilityServiceimp(ShapeAvailabilityRepository shapeAvailabilityRepository) {
        this.shapeAvailabilityRepository = shapeAvailabilityRepository;
    }

    @Override
    public List<ShapeAvailability> getShape() {

        return shapeAvailabilityRepository.findAll();
    }

    @Override
    public void createShape(ShapeAvailability shapeAvailability) {

        shapeAvailabilityRepository.save(shapeAvailability);
    }

    @Override
    public ShapeAvailability getShapeById(Long shapeId) {

        return shapeAvailabilityRepository.findById(shapeId).orElse(null);
    }

    @Override
    public boolean updateShapeById(Long shapeId, ShapeAvailability shapeAvailability) {

        Optional<ShapeAvailability> shapeAvailabilityOptional=shapeAvailabilityRepository.findById(shapeId);

        if(shapeAvailabilityOptional.isPresent())
        {
            ShapeAvailability shapeAvailability1=shapeAvailabilityOptional.get();
            shapeAvailability1.setShape(shapeAvailability.getShape());
            shapeAvailability1.setIsavailable(shapeAvailability.getIsavailable());
            shapeAvailabilityRepository.save(shapeAvailability1);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteShapeById(Long shapeId) {

        if(shapeAvailabilityRepository.existsById(shapeId))
        {
            shapeAvailabilityRepository.deleteById(shapeId);
            return true;
        }
        else
        {
            return false;
        }

    }
}
