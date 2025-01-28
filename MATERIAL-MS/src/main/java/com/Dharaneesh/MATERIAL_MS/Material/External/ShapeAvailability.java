package com.Dharaneesh.MATERIAL_MS.Material.External;

public class ShapeAvailability {

    private Long shapeid;
    private String shape;
    private String isavailable;

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
