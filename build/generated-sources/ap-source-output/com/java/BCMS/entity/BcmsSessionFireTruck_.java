package com.java.BCMS.entity;

import com.java.BCMS.entity.BcmsSession;
import com.java.BCMS.entity.FireTruck;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T18:35:26")
@StaticMetamodel(BcmsSessionFireTruck.class)
public class BcmsSessionFireTruck_ { 

    public static volatile SingularAttribute<BcmsSessionFireTruck, String> fireTruckStatus;
    public static volatile SingularAttribute<BcmsSessionFireTruck, BcmsSession> bcmsSession;
    public static volatile SingularAttribute<BcmsSessionFireTruck, FireTruck> fireTruckName;
    public static volatile SingularAttribute<BcmsSessionFireTruck, String> sessionId;

}