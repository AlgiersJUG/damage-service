package com.audi.msi.damage.service.dto;

import java.util.Date;

/**
 * Created by Abderrazak BOUADMA
 * on 26/03/2017.
 */
public class DamageDto {

    private Long id;
    private Long damageType;
    private String referenceNumber;
    private Integer totalDamage;
    private Long odoMeter;
    private Date dateRepaired;
    private Integer status;

    public DamageDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDamageType() {
        return damageType;
    }

    public void setDamageType(Long damageType) {
        this.damageType = damageType;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Integer getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(Integer totalDamage) {
        this.totalDamage = totalDamage;
    }

    public Long getOdoMeter() {
        return odoMeter;
    }

    public void setOdoMeter(Long odoMeter) {
        this.odoMeter = odoMeter;
    }

    public Date getDateRepaired() {
        return dateRepaired;
    }

    public void setDateRepaired(Date dateRepaired) {
        this.dateRepaired = dateRepaired;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
