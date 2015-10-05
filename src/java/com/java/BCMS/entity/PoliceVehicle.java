/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "POLICE_VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoliceVehicle.findAll", query = "SELECT p FROM PoliceVehicle p"),
    @NamedQuery(name = "PoliceVehicle.findByPoliceVehicleName", query = "SELECT p FROM PoliceVehicle p WHERE p.policeVehicleName = :policeVehicleName")})
public class PoliceVehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "POLICE_VEHICLE_NAME")
    private String policeVehicleName;
    @OneToMany(mappedBy = "policeVehicleName")
    private Collection<BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicleCollection;

    public PoliceVehicle() {
    }

    public PoliceVehicle(String policeVehicleName) {
        this.policeVehicleName = policeVehicleName;
    }

    public String getPoliceVehicleName() {
        return policeVehicleName;
    }

    public void setPoliceVehicleName(String policeVehicleName) {
        this.policeVehicleName = policeVehicleName;
    }

    @XmlTransient
    public Collection<BcmsSessionPoliceVehicle> getBcmsSessionPoliceVehicleCollection() {
        return bcmsSessionPoliceVehicleCollection;
    }

    public void setBcmsSessionPoliceVehicleCollection(Collection<BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicleCollection) {
        this.bcmsSessionPoliceVehicleCollection = bcmsSessionPoliceVehicleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (policeVehicleName != null ? policeVehicleName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoliceVehicle)) {
            return false;
        }
        PoliceVehicle other = (PoliceVehicle) object;
        if ((this.policeVehicleName == null && other.policeVehicleName != null) || (this.policeVehicleName != null && !this.policeVehicleName.equals(other.policeVehicleName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BCMS.entity.PoliceVehicle[ policeVehicleName=" + policeVehicleName + " ]";
    }
    
}
