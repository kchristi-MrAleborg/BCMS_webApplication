/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import com.pauware.pauware_engine._Exception.Statechart_exception;
//import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
//import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author mraleborg
 */
@Named(value = "firemenApp")
@RequestScoped
public class FiremenApp {
    
    @javax.ejb.EJB
    protected com.java.BCMS.session.FSC_Remote fsc_bCMS;
    
    javax.faces.model.SelectItem[] routes;
    
    /**
     * Creates a new instance of FiremenApp
     */
    public FiremenApp() {
        
    }
            
    @PostConstruct
    public void init(){
        
        List l = fsc_bCMS.getRoutes(); 
        routes = new SelectItem[l.size()];
        for(int i=0; i<l.size(); i++)
        {
            routes[i]=new SelectItem(((com.java.BCMS.entity.Route)l.get(i)).getRouteName(), ((com.java.BCMS.entity.Route)l.get(i)).getRouteName());
        }
    }
    
    public javax.faces.model.SelectItem[] getRoutes()
    {
        return routes;
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
        
}
