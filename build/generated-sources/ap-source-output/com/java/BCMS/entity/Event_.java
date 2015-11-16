package com.java.BCMS.entity;

import com.java.BCMS.entity.BcmsSession;
import com.java.BCMS.entity.EventPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-16T09:54:47")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, EventPK> eventPK;
    public static volatile SingularAttribute<Event, String> executionTrace;
    public static volatile SingularAttribute<Event, BcmsSession> sessionId;

}