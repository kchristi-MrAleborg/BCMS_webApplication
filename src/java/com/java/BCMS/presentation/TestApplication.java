/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author mraleborg
 */
@ManagedBean
@RequestScoped
public class TestApplication {
    
    @javax.ejb.EJB
    private com.java.BCMS.session.FSC_Remote fsc_bCMS;
    @javax.ejb.EJB
    private com.java.BCMS.session.PSC_Remote psc_bCMS;

    /**
     * Creates a new instance of TestApplication
     */
    public TestApplication() {
    }
    
    public void test()
    {
        try{
        fsc_bCMS.FSC_connection_request();
            psc_bCMS.PSC_connection_request();
            fsc_bCMS.state_fire_truck_number(2);
            psc_bCMS.state_police_vehicle_number(2);

            psc_bCMS.route_for_police_vehicles();
            Thread.sleep(100);
            /**
             * Bug due to PlantUML modeling style. One must await so that
             * 'route_for_police_vehicles' that is re-sent internally, arrives
             * before what follows:
             */
            fsc_bCMS.route_for_fire_trucks();
            fsc_bCMS.FSC_disagrees_about_fire_truck_route();
            fsc_bCMS.route_for_fire_trucks();
            fsc_bCMS.FSC_agrees_about_police_vehicle_route();
            fsc_bCMS.FSC_agrees_about_fire_truck_route();
            Thread.sleep(100);
            /**
             * Bug due to PlantUML modeling style. One must await so that
             * 'completion' that is sent internally, arrives before what
             * follows:
             */

            fsc_bCMS.fire_truck_dispatched("FT1");
            Thread.sleep(100);
            fsc_bCMS.fire_truck_dispatched("FT2");
            Thread.sleep(100);
            psc_bCMS.police_vehicle_dispatched("PV1");
            Thread.sleep(100);
            psc_bCMS.police_vehicle_dispatched("PV2");
            Thread.sleep(100);
            psc_bCMS.police_vehicle_breakdown("PV1", null);
            fsc_bCMS.fire_truck_arrived("FT1");
            fsc_bCMS.fire_truck_arrived("FT2");

            psc_bCMS.police_vehicle_arrived("PV2");
            // 'PV1' had an accident above, so between comments:
            // bCMS.police_vehicle_arrived("PV1");
            Thread.sleep(100);
            //bCMS.close();

            Thread.sleep(100);
            //bCMS.reset();

            
            /**
             * End of state machine is delayed so that events sent internally
             * are effectively processed:
             */
            Thread.sleep(100);
            //bCMS.stop();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    
}
