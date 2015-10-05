package com.java.BCMS.entity;

import com.java.BCMS.entity.BcmsSession;
import com.java.BCMS.entity.PoliceVehicle;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T23:58:27")
@StaticMetamodel(BcmsSessionPoliceVehicle.class)
public class BcmsSessionPoliceVehicle_ { 

    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, PoliceVehicle> policeVehicleName;
    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, String> policeVehicleStatus;
    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, BcmsSession> bcmsSession;
    public static volatile SingularAttribute<BcmsSessionPoliceVehicle, String> sessionId;

}