/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mraleborg
 */
@Embeddable
public class BcmsSessionFireTruckPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRE_TRUCK_NAME")
    private String fireTruckName;

    public BcmsSessionFireTruckPK() {
    }

    public BcmsSessionFireTruckPK(String sessionId, String fireTruckName) {
        this.sessionId = sessionId;
        this.fireTruckName = fireTruckName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getFireTruckName() {
        return fireTruckName;
    }

    public void setFireTruckName(String fireTruckName) {
        this.fireTruckName = fireTruckName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        hash += (fireTruckName != null ? fireTruckName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionFireTruckPK)) {
            return false;
        }
        BcmsSessionFireTruckPK other = (BcmsSessionFireTruckPK) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        if ((this.fireTruckName == null && other.fireTruckName != null) || (this.fireTruckName != null && !this.fireTruckName.equals(other.fireTruckName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.BcmsSessionFireTruckPK[ sessionId=" + sessionId + ", fireTruckName=" + fireTruckName + " ]";
    }
    
}
