package com.Dharaneesh.MATERIAL_MS.Material;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialid;
    private String materialname;
    private String materialtype;
    private String grade;
    private String heattreatment;
    private String finishtype;
    private String reference;private Long shapeid;

    public Material() {
    }

    public Material(Long materialid, String materialname, String materialtype, String grade, String heattreatment, String finishtype, String reference, Long shapeid) {
        this.materialid = materialid;
        this.materialname = materialname;
        this.materialtype = materialtype;
        this.grade = grade;
        this.heattreatment = heattreatment;
        this.finishtype = finishtype;
        this.reference = reference;
        this.shapeid = shapeid;
    }

    public Long getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Long materialid) {
        this.materialid = materialid;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getMaterialtype() {
        return materialtype;
    }

    public void setMaterialtype(String materialtype) {
        this.materialtype = materialtype;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHeattreatment() {
        return heattreatment;
    }

    public void setHeattreatment(String heattreatment) {
        this.heattreatment = heattreatment;
    }

    public String getFinishtype() {
        return finishtype;
    }

    public void setFinishtype(String finishtype) {
        this.finishtype = finishtype;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getShapeid() {
        return shapeid;
    }

    public void setShapeid(Long shapeid) {
        this.shapeid = shapeid;
    }
}
