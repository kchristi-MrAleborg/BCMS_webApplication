/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findBySessionId", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.sessionId = :sessionId"),
    @NamedQuery(name = "BcmsSessionPoliceVehicle.findByPoliceVehicleStatus", query = "SELECT b FROM BcmsSessionPoliceVehicle b WHERE b.policeVehicleStatus = :policeVehicleStatus")})
public class BcmsSessionPoliceVehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Size(max = 10)
    @Column(name = "POLICE_VEHICLE_STATUS")
    private String policeVehicleStatus;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private BcmsSession bcmsSession;
    @JoinColumn(name = "POLICE_VEHICLE_NAME", referencedColumnName = "POLICE_VEHICLE_NAME")
    @ManyToOne
    private PoliceVehicle policeVehicleName;

    public BcmsSessionPoliceVehicle() {
    }

    public BcmsSessionPoliceVehicle(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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

    public PoliceVehicle getPoliceVehicleName() {
        return policeVehicleName;
    }

    public void setPoliceVehicleName(PoliceVehicle policeVehicleName) {
        this.policeVehicleName = policeVehicleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BcmsSessionPoliceVehicle)) {
            return false;
        }
        BcmsSessionPoliceVehicle other = (BcmsSessionPoliceVehicle) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BCMS.entity.BcmsSessionPoliceVehicle[ sessionId=" + sessionId + " ]";
    }
    
}
