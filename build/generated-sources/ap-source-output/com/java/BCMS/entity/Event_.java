package com.java.BCMS.entity;

import com.java.BCMS.entity.BcmsSession;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T18:35:26")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, String> executionTrace;
    public static volatile SingularAttribute<Event, String> eventName;
    public static volatile SingularAttribute<Event, BcmsSession> sessionId;

}