/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mraleborg
 */
@Entity
@Table(name = "FIRE_TRUCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FireTruck.findAll", query = "SELECT f FROM FireTruck f"),
    @NamedQuery(name = "FireTruck.findByFireTruckName", query = "SELECT f FROM FireTruck f WHERE f.fireTruckName = :fireTruckName")})
public class FireTruck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRE_TRUCK_NAME")
    private String fireTruckName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fireTruck")
    private Collection<BcmsSessionFireTruck> bcmsSessionFireTruckCollection;

    public FireTruck() {
    }

    public FireTruck(String fireTruckName) {
        this.fireTruckName = fireTruckName;
    }

    public String getFireTruckName() {
        return fireTruckName;
    }

    public void setFireTruckName(String fireTruckName) {
        this.fireTruckName = fireTruckName;
    }

    @XmlTransient
    public Collection<BcmsSessionFireTruck> getBcmsSessionFireTruckCollection() {
        return bcmsSessionFireTruckCollection;
    }

    public void setBcmsSessionFireTruckCollection(Collection<BcmsSessionFireTruck> bcmsSessionFireTruckCollection) {
        this.bcmsSessionFireTruckCollection = bcmsSessionFireTruckCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fireTruckName != null ? fireTruckName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FireTruck)) {
            return false;
        }
        FireTruck other = (FireTruck) object;
        if ((this.fireTruckName == null && other.fireTruckName != null) || (this.fireTruckName != null && !this.fireTruckName.equals(other.fireTruckName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.FireTruck[ fireTruckName=" + fireTruckName + " ]";
    }
    
}
