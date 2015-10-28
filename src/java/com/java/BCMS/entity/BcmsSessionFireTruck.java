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
@Table(name = "BCMS_SESSION_FIRE_TRUCK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSessionFireTruck.findAll", query = "SELECT b FROM BcmsSessionFireTruck b"),
    @NamedQuery(name = "BcmsSessionFireTruck.findBySessionId", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.bcmsSessionFireTruckPK.sessionId = :sessionId"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByFireTruckName", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.bcmsSessionFireTruckPK.fireTruckName = :fireTruckName"),
    @NamedQuery(name = "BcmsSessionFireTruck.findByFireTruckStatus", query = "SELECT b FROM BcmsSessionFireTruck b WHERE b.fireTruckStatus = :fireTruckStatus")})
public class BcmsSessionFireTruck implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BcmsSessionFireTruckPK bcmsSessionFireTruckPK;
    @Size(max = 10)
    @Column(name = "FIRE_TRUCK_STATUS")
    private String fireTruckStatus;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BcmsSession bcmsSession;
    @JoinColumn(name = "FIRE_TRUCK_NAME", referencedColumnName = "FIRE_TRUCK_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FireTruck fireTruck;

    public BcmsSessionFireTruck() {
    }

    public BcmsSessionFireTruck(BcmsSessionFireTruckPK bcmsSessionFireTruckPK) {
        this.bcmsSessionFireTruckPK = bcmsSessionFireTruckPK;
    }

    public BcmsSessionFireTruck(String sessionId, String fireTruckName) {
        this.bcmsSessionFireTruckPK = new BcmsSessionFireTruckPK(sessionId, fireTruckName);
    }

    public BcmsSessionFireTruckPK getBcmsSessionFireTruckPK() {
        return bcmsSessionFireTruckPK;
    }

    public void setBcmsSessionFireTruckPK(BcmsSessionFireTruckPK bcmsSessionFireTruckPK) {
        this.bcmsSessionFireTruckPK = bcmsSessionFireTruckPK;
    }

    public String getFireTruckStatus() {
        return fireTruckStatus;
    }

    public void setFireTruckStatus(String fireTruckStatus) {
        this.fireTruckStatus = fireTruckStatus;
    }

    public BcmsSession getBcmsSession() {
        return bcmsSession;
    }

    public void setBcmsSession(BcmsSession bcmsSession) {
        this.bcmsSession = bcmsSession;
    }

    public FireTruck getFireTruck() {
        return fireTruck;
    }

    public void setFireTruck(FireTruck fireTruck) {
        this.fireTruck = fireTruck;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bcmsSessionFireTruckPK != null ? bcmsSessionFireTruckPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionFireTruck)) {
            return false;
        }
        BcmsSessionFireTruck other = (BcmsSessionFireTruck) object;
        if ((this.bcmsSessionFireTruckPK == null && other.bcmsSessionFireTruckPK != null) || (this.bcmsSessionFireTruckPK != null && !this.bcmsSessionFireTruckPK.equals(other.bcmsSessionFireTruckPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.BcmsSessionFireTruck[ bcmsSessionFireTruckPK=" + bcmsSessionFireTruckPK + " ]";
    }
    
}
