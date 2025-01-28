package com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeAvailabilityRepository extends JpaRepository<ShapeAvailability,Long> {
}
