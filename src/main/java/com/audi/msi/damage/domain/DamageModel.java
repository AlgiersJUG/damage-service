package com.audi.msi.damage.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 */
@Entity
public class DamageModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long damageType;
    private String referenceNumber;

    @Range(min = 1, max = 10)
    private Integer totalDamage;
    private Long odoMeter;
    private Date dateRepaired;
    private Integer status;

    public DamageModel() {
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
