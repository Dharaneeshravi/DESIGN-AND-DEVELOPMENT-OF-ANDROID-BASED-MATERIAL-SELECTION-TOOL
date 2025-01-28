package com.Dharaneesh.SHAPE_AVAILABILITY_MS.ShapeAvailability;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShapeAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shapeid;
    private String shape;
    private String isavailable;

    public ShapeAvailability() {
    }

    public ShapeAvailability(Long shapeid, String shape, String isavailable) {
        this.shapeid = shapeid;
        this.shape = shape;
        this.isavailable = isavailable;
    }

    public Long getShapeid() {
        return shapeid;
    }

    public void setShapeid(Long shapeid) {
        this.shapeid = shapeid;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(String isavailable) {
        this.isavailable = isavailable;
    }
}
