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
public class EventPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EVENT_TIME")
    private String eventTime;

    public EventPK() {
    }

    public EventPK(String eventName, String eventTime) {
        this.eventName = eventName;
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventName != null ? eventName.hashCode() : 0);
        hash += (eventTime != null ? eventTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPK)) {
            return false;
        }
        EventPK other = (EventPK) object;
        if ((this.eventName == null && other.eventName != null) || (this.eventName != null && !this.eventName.equals(other.eventName))) {
            return false;
        }
        if ((this.eventTime == null && other.eventTime != null) || (this.eventTime != null && !this.eventTime.equals(other.eventTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.EventPK[ eventName=" + eventName + ", eventTime=" + eventTime + " ]";
    }
    
}
