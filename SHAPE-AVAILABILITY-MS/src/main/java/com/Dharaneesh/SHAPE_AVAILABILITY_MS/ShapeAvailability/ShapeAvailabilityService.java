package com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability;

import java.util.List;

public interface ShapeAvailabilityService {
    List<ShapeAvailability> getShape();

    void createShape(ShapeAvailability shapeAvailability);

    ShapeAvailability getShapeById(Long shapeId);

    boolean updateShapeById(Long shapeId, ShapeAvailability shapeAvailability);

    boolean deleteShapeById(Long shapeId);
}
