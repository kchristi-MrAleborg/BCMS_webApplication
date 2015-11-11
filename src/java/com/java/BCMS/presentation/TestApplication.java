/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Query;

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
    

    
    ArrayList routes;
    
    /**
     * Creates a new instance of TestApplication
     */
    public TestApplication() {
    }
    
    @PostConstruct
    public void init_TestApplication(){
        //Query query = fsc_bCMS.getEntityManager().createNamedQuery("Route.findAll")
        //routes = (ArrayList) query.getResultList();
        //System.out.println("Routes ============"+routes.get(0));
    }
    
    public void FSC_connection_request() throws Statechart_exception{
        fsc_bCMS.FSC_connection_request();
    }
    
    public void PSC_connection_request() throws Statechart_exception{
        psc_bCMS.PSC_connection_request();
    }
    
    public void state_fire_truck_number(int number) throws Statechart_exception{
        fsc_bCMS.state_fire_truck_number(number);
    }
    
    public void state_police_vehicle_number(int number) throws Statechart_exception{
        psc_bCMS.state_police_vehicle_number(number);
    }
    
    public void route_for_police_vehicles(String name) throws Statechart_exception{
        psc_bCMS.route_for_police_vehicles(name);
    }
    
    public void route_for_fire_trucks(String name) throws Statechart_exception{    
        fsc_bCMS.route_for_fire_trucks(name);
    }   
    
    public void FSC_disagrees_about_fire_truck_route() throws Statechart_exception{    
        fsc_bCMS.FSC_disagrees_about_fire_truck_route();
    }  
    
    public void FSC_agrees_about_police_vehicle_route() throws Statechart_exception{    
        fsc_bCMS.FSC_agrees_about_police_vehicle_route();
    }  
    
    public void FSC_agrees_about_fire_truck_route() throws Statechart_exception{    
        fsc_bCMS.FSC_agrees_about_fire_truck_route();
    } 
    
    public void fire_truck_dispatched(String name) throws Statechart_exception{    
        fsc_bCMS.fire_truck_dispatched(name);
    }  
    
    public void police_vehicle_dispatched(String name) throws Statechart_exception{    
        psc_bCMS.police_vehicle_dispatched(name);
    }   
    
    public void police_vehicle_breakdown(String name, String replacementName) throws Statechart_exception{    
        psc_bCMS.police_vehicle_breakdown(name, replacementName);
    }  
    
    public void fire_truck_arrived(String name) throws Statechart_exception{    
        fsc_bCMS.fire_truck_arrived(name);
    }  
    
    public void police_vehicle_arrived(String name) throws Statechart_exception{    
        psc_bCMS.police_vehicle_arrived(name);
    } 
    
    public void reset() throws Statechart_exception{    
        psc_bCMS.reset();
    }
    
    
   // Methodes manquante à rajouter 
    
    public void test()
    {
        try{
            fsc_bCMS.FSC_connection_request();
            psc_bCMS.PSC_connection_request();
            fsc_bCMS.state_fire_truck_number(2);
            psc_bCMS.state_police_vehicle_number(2);

            psc_bCMS.route_for_police_vehicles("R3");
            Thread.sleep(100);
            /**
             * Bug due to PlantUML modeling style. One must await so that
             * 'route_for_police_vehicles' that is re-sent internally, arrives
             * before what follows:
             */
            fsc_bCMS.route_for_fire_trucks("R1");
            fsc_bCMS.FSC_disagrees_about_fire_truck_route();
            fsc_bCMS.route_for_fire_trucks("R2");
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
            Thread.sleep(100);
            fsc_bCMS.fire_truck_arrived("FT1");
            Thread.sleep(100);
            fsc_bCMS.fire_truck_arrived("FT2");
            Thread.sleep(100);

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
            psc_bCMS.reset();
            //bCMS.stop();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    
}
