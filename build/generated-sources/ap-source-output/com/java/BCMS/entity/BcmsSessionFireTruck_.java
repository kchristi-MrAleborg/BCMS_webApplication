package com.java.BCMS.entity;

import com.java.BCMS.entity.BcmsSession;
import com.java.BCMS.entity.BcmsSessionFireTruckPK;
import com.java.BCMS.entity.FireTruck;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-15T15:01:04")
@StaticMetamodel(BcmsSessionFireTruck.class)
public class BcmsSessionFireTruck_ { 

    public static volatile SingularAttribute<BcmsSessionFireTruck, String> fireTruckStatus;
    public static volatile SingularAttribute<BcmsSessionFireTruck, BcmsSession> bcmsSession;
    public static volatile SingularAttribute<BcmsSessionFireTruck, FireTruck> fireTruck;
    public static volatile SingularAttribute<BcmsSessionFireTruck, BcmsSessionFireTruckPK> bcmsSessionFireTruckPK;

}