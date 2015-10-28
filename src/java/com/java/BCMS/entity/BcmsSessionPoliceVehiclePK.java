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
public class BcmsSessionPoliceVehiclePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "POLICE_VEHICLE_NAME")
    private String policeVehicleName;

    public BcmsSessionPoliceVehiclePK() {
    }

    public BcmsSessionPoliceVehiclePK(String sessionId, String policeVehicleName) {
        this.sessionId = sessionId;
        this.policeVehicleName = policeVehicleName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPoliceVehicleName() {
        return policeVehicleName;
    }

    public void setPoliceVehicleName(String policeVehicleName) {
        this.policeVehicleName = policeVehicleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        hash += (policeVehicleName != null ? policeVehicleName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionPoliceVehiclePK)) {
            return false;
        }
        BcmsSessionPoliceVehiclePK other = (BcmsSessionPoliceVehiclePK) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        if ((this.policeVehicleName == null && other.policeVehicleName != null) || (this.policeVehicleName != null && !this.policeVehicleName.equals(other.policeVehicleName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.BcmsSessionPoliceVehiclePK[ sessionId=" + sessionId + ", policeVehicleName=" + policeVehicleName + " ]";
    }
    
}
