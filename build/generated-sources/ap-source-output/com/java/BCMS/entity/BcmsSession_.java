package com.java.BCMS.entity;

import com.java.BCMS.entity.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-12T16:45:34")
@StaticMetamodel(BcmsSession.class)
public class BcmsSession_ { 

    public static volatile CollectionAttribute<BcmsSession, Event> eventCollection;
    public static volatile SingularAttribute<BcmsSession, String> sessionId;

}