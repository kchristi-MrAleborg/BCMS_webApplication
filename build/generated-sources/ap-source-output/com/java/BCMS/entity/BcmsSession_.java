package com.java.BCMS.entity;

import com.java.BCMS.entity.BcmsSessionFireTruck;
import com.java.BCMS.entity.BcmsSessionPoliceVehicle;
import com.java.BCMS.entity.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T18:35:26")
@StaticMetamodel(BcmsSession.class)
public class BcmsSession_ { 

    public static volatile SingularAttribute<BcmsSession, BcmsSessionFireTruck> bcmsSessionFireTruck;
    public static volatile CollectionAttribute<BcmsSession, Event> eventCollection;
    public static volatile SingularAttribute<BcmsSession, BcmsSessionPoliceVehicle> bcmsSessionPoliceVehicle;
    public static volatile SingularAttribute<BcmsSession, String> sessionId;

}