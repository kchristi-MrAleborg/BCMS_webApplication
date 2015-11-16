/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
//import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author mraleborg
 */
@Named(value = "firemenApp")
@RequestScoped
public class FiremenApp implements Serializable{
    
    @javax.ejb.EJB
    protected com.java.BCMS.session.FSC_Remote fsc_bCMS;
    
    private static javax.faces.model.SelectItem[] routes;
    private static javax.faces.model.SelectItem[] firetrucks;
    private static javax.faces.model.SelectItem[] availableFireTrucks;
    private static java.util.ArrayList dispatchedFireTrucks;
    
    /**
     * Creates a new instance of FiremenApp
     */
    public FiremenApp() {
        
    }
    
    public javax.faces.model.SelectItem[] getRoutes()
    {
        List l = fsc_bCMS.getRoutes(); 
        routes = new SelectItem[l.size()];
        for(int i=0; i<l.size(); i++)
        {
            routes[i]=new SelectItem(((com.java.BCMS.entity.Route)l.get(i)).getRouteName(), ((com.java.BCMS.entity.Route)l.get(i)).getRouteName());
        }
        return routes;
    }
    
    public javax.faces.model.SelectItem[] getFireTrucks()
    {
        List l;
        l = fsc_bCMS.getFireTrucks();
        firetrucks = new SelectItem[l.size()];
        for(int i=0; i<l.size(); i++)
        {
            firetrucks[i]=new SelectItem(((com.java.BCMS.entity.FireTruck)l.get(i)).getFireTruckName(), ((com.java.BCMS.entity.FireTruck)l.get(i)).getFireTruckName());
        }
        return firetrucks;
    }
    
    public javax.faces.model.SelectItem[] getAvailableFireTrucks()
    {
        return availableFireTrucks;
    }
    
    public void FSC_connection_request() throws Statechart_exception{
        fsc_bCMS.FSC_connection_request();
    }
    
    public void state_fire_truck_number(int number) throws Statechart_exception{
        fsc_bCMS.state_fire_truck_number(number);
    }
        
    public void route_for_fire_trucks(String name) throws Statechart_exception{    
        fsc_bCMS.route_for_fire_trucks(name);
    }   
    
    public void FSC_disagrees_about_fire_truck_route() throws Statechart_exception{    
        fsc_bCMS.FSC_disagrees_about_fire_truck_route();
    }
    
    public void FSC_disagrees_about_police_vehicle_route() throws Statechart_exception{    
        fsc_bCMS.FSC_disagrees_about_police_vehicle_route();
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
    
    public void fire_truck_arrived(String name) throws Statechart_exception{    
        fsc_bCMS.fire_truck_arrived(name);
    }  
    
    public void reset() throws Statechart_exception{    
        fsc_bCMS.reset();
    }
    
    public int getMaxFTNumber(){
        return fsc_bCMS.getMaxFTNumber();
    }
    
    public void fire_truck_blocked(String fire_truck) throws Statechart_exception{
        fsc_bCMS.fire_truck_blocked(fire_truck);
    }
    
}
