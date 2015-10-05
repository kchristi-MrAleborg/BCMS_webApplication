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
import javax.persistence.OneToOne;
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
@Table(name = "BCMS_SESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BcmsSession.findAll", query = "SELECT b FROM BcmsSession b"),
    @NamedQuery(name = "BcmsSession.findBySessionId", query = "SELECT b FROM BcmsSession b WHERE b.sessionId = :sessionId")})
public class BcmsSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SESSION_ID")
    private String sessionId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bcmsSession")
    private BcmsSessionFireTruck bcmsSessionFireTruck;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bcmsSession")
    private BcmsSessionPoliceVehicle bcmsSessionPoliceVehicle;
    @OneToMany(mappedBy = "sessionId")
    private Collection<Event> eventCollection;

    public BcmsSession() {
    }

    public BcmsSession(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public BcmsSessionFireTruck getBcmsSessionFireTruck() {
        return bcmsSessionFireTruck;
    }

    public void setBcmsSessionFireTruck(BcmsSessionFireTruck bcmsSessionFireTruck) {
        this.bcmsSessionFireTruck = bcmsSessionFireTruck;
    }

    public BcmsSessionPoliceVehicle getBcmsSessionPoliceVehicle() {
        return bcmsSessionPoliceVehicle;
    }

    public void setBcmsSessionPoliceVehicle(BcmsSessionPoliceVehicle bcmsSessionPoliceVehicle) {
        this.bcmsSessionPoliceVehicle = bcmsSessionPoliceVehicle;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
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
        if (!(object instanceof BcmsSession)) {
            return false;
        }
        BcmsSession other = (BcmsSession) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BCMS.entity.BcmsSession[ sessionId=" + sessionId + " ]";
    }
    
}
