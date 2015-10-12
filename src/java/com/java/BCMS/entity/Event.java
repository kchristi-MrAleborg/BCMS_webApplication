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
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventPK.eventName = :eventName"),
    @NamedQuery(name = "Event.findByEventTime", query = "SELECT e FROM Event e WHERE e.eventPK.eventTime = :eventTime"),
    @NamedQuery(name = "Event.findByExecutionTrace", query = "SELECT e FROM Event e WHERE e.executionTrace = :executionTrace")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventPK eventPK;
    @Size(max = 500)
    @Column(name = "EXECUTION_TRACE")
    private String executionTrace;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID")
    @ManyToOne
    private BcmsSession sessionId;

    public Event() {
    }

    public Event(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public Event(String eventName, String eventTime) {
        this.eventPK = new EventPK(eventName, eventTime);
    }

    public EventPK getEventPK() {
        return eventPK;
    }

    public void setEventPK(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public String getExecutionTrace() {
        return executionTrace;
    }

    public void setExecutionTrace(String executionTrace) {
        this.executionTrace = executionTrace;
    }

    public BcmsSession getSessionId() {
        return sessionId;
    }

    public void setSessionId(BcmsSession sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventPK != null ? eventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventPK == null && other.eventPK != null) || (this.eventPK != null && !this.eventPK.equals(other.eventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.Event[ eventPK=" + eventPK + " ]";
    }
    
}
