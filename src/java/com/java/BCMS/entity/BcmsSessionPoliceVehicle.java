/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mraleborg
 */
@Entity
@Table(name = "BCMS_SESSION_POLICE_VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findAll", query = "SELECT b FROM BcmsSessionPoliceVehicle b"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findBySessionId", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.bcmsSessionPoliceVehiclePK.sessionId = :sessionId"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByPoliceVehicleName", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.bcmsSessionPoliceVehiclePK.policeVehicleName = :policeVehicleName"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByPoliceVehicleStatus", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.policeVehicleStatus = :policeVehicleStatus")})
public class BcmsSessionPoliceVehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BcmsSessionPoliceVehiclePK bcmsSessionPoliceVehiclePK;
    @Size(max = 10)
    @Column(name = "POLICE_VEHICLE_STATUS")
    private String policeVehicleStatus;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BcmsSession bcmsSession;
    @JoinColumn(name = "POLICE_VEHICLE_NAME", referencedColumnName = "POLICE_VEHICLE_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PoliceVehicle policeVehicle;

    public BcmsSessionPoliceVehicle() {
    }

    public BcmsSessionPoliceVehicle(BcmsSessionPoliceVehiclePK bcmsSessionPoliceVehiclePK) {
        this.bcmsSessionPoliceVehiclePK = bcmsSessionPoliceVehiclePK;
    }

    public BcmsSessionPoliceVehicle(String sessionId, String policeVehicleName) {
        this.bcmsSessionPoliceVehiclePK = new BcmsSessionPoliceVehiclePK(sessionId, policeVehicleName);
    }

    public BcmsSessionPoliceVehiclePK getBcmsSessionPoliceVehiclePK() {
        return bcmsSessionPoliceVehiclePK;
    }

    public void setBcmsSessionPoliceVehiclePK(BcmsSessionPoliceVehiclePK bcmsSessionPoliceVehiclePK) {
        this.bcmsSessionPoliceVehiclePK = bcmsSessionPoliceVehiclePK;
    }

    public String getPoliceVehicleStatus() {
        return policeVehicleStatus;
    }

    public void setPoliceVehicleStatus(String policeVehicleStatus) {
        this.policeVehicleStatus = policeVehicleStatus;
    }

    public BcmsSession getBcmsSession() {
        return bcmsSession;
    }

    public void setBcmsSession(BcmsSession bcmsSession) {
        this.bcmsSession = bcmsSession;
    }

    public PoliceVehicle getPoliceVehicle() {
        return policeVehicle;
    }

    public void setPoliceVehicle(PoliceVehicle policeVehicle) {
        this.policeVehicle = policeVehicle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bcmsSessionPoliceVehiclePK != null ? bcmsSessionPoliceVehiclePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionPoliceVehicle)) {
            return false;
        }
        BcmsSessionPoliceVehicle other = (BcmsSessionPoliceVehicle) object;
        if ((this.bcmsSessionPoliceVehiclePK == null && other.bcmsSessionPoliceVehiclePK != null) || (this.bcmsSessionPoliceVehiclePK != null && !this.bcmsSessionPoliceVehiclePK.equals(other.bcmsSessionPoliceVehiclePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.BcmsSessionPoliceVehicle[ bcmsSessionPoliceVehiclePK=" + bcmsSessionPoliceVehiclePK + " ]";
    }
    
}
