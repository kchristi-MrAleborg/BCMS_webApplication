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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "Event.findByExecutionTrace", query = "SELECT e FROM Event e WHERE e.executionTrace = :executionTrace")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Size(max = 500)
    @Column(name = "EXECUTION_TRACE")
    private String executionTrace;
    @JoinColumn(name = "SESSION_ID", referencedColumnName = "SESSION_ID")
    @ManyToOne
    private BcmsSession sessionId;

    public Event() {
    }

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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
        hash += (eventName != null ? eventName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventName == null && other.eventName != null) || (this.eventName != null && !this.eventName.equals(other.eventName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.BCMS.entity.Event[ eventName=" + eventName + " ]";
    }
    
}
