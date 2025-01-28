package com.Dharaneesh.MATERIAL_PROPERTIES_MS.MaterialProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MaterialProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertiesid;
    private String density;
    private String hardness;
    private String tensilestrength;
    private String compressivestrength;
    private String yieldstrength;
    private String thermalconductivity;
    private String electricalconductivity;
    private String weldability;
    private Long shapeId;

    public MaterialProperties() {
    }

    public MaterialProperties(Long propertiesid, String density, String hardness, String tensilestrength, String compressivestrength, String yieldstrength, String thermalconductivity, String electricalconductivity, String weldability,Long shapeId) {
        this.propertiesid = propertiesid;
        this.density = density;
        this.hardness = hardness;
        this.tensilestrength = tensilestrength;
        this.compressivestrength = compressivestrength;
        this.yieldstrength = yieldstrength;
        this.thermalconductivity = thermalconductivity;
        this.electricalconductivity = electricalconductivity;
        this.weldability = weldability;
        this.shapeId=shapeId;
    }

    public Long getShapeId() {
        return shapeId;
    }

    public void setShapeId(Long shapeId) {
        this.shapeId = shapeId;
    }

    public Long getPropertiesid() {
        return propertiesid;
    }

    public void setPropertiesid(Long propertiesid) {
        this.propertiesid = propertiesid;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getHardness() {
        return hardness;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    public String getTensilestrength() {
        return tensilestrength;
    }

    public void setTensilestrength(String tensilestrength) {
        this.tensilestrength = tensilestrength;
    }

    public String getCompressivestrength() {
        return compressivestrength;
    }

    public void setCompressivestrength(String compressivestrength) {
        this.compressivestrength = compressivestrength;
    }

    public String getYieldstrength() {
        return yieldstrength;
    }

    public void setYieldstrength(String yieldstrength) {
        this.yieldstrength = yieldstrength;
    }

    public String getThermalconductivity() {
        return thermalconductivity;
    }

    public void setThermalconductivity(String thermalconductivity) {
        this.thermalconductivity = thermalconductivity;
    }

    public String getElectricalconductivity() {
        return electricalconductivity;
    }

    public void setElectricalconductivity(String electricalconductivity) {
        this.electricalconductivity = electricalconductivity;
    }

    public String getWeldability() {
        return weldability;
    }

    public void setWeldability(String weldability) {
        this.weldability = weldability;
    }
}
