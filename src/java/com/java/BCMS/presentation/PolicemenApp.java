/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.SelectItem;

/**
 *
 * @author mraleborg
 */
@Named(value = "policemenApp")
@Dependent
public class PolicemenApp {

    @javax.ejb.EJB
    private com.java.BCMS.session.PSC_Remote psc_bCMS;
    
    javax.faces.model.SelectItem[] routes;
    
    /**
     * Creates a new instance of PolicemenApp
     */
    public PolicemenApp() {
    }
    
    @PostConstruct
    public void init(){
        
        List l = psc_bCMS.getRoutes(); 
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
    
    public void PSC_connection_request() throws Statechart_exception{
        psc_bCMS.PSC_connection_request();
    }
    
    public void state_police_vehicle_number(int number) throws Statechart_exception{
        psc_bCMS.state_police_vehicle_number(number);
    }
    
    public void route_for_police_vehicles(String name) throws Statechart_exception{
        psc_bCMS.route_for_police_vehicles(name);
    } 
    
    public void police_vehicle_dispatched(String name) throws Statechart_exception{    
        psc_bCMS.police_vehicle_dispatched(name);
    }   
    
    public void police_vehicle_breakdown(String name, String replacementName) throws Statechart_exception{    
        psc_bCMS.police_vehicle_breakdown(name, replacementName);
    } 
    
    public void police_vehicle_arrived(String name) throws Statechart_exception{    
        psc_bCMS.police_vehicle_arrived(name);
    } 
        
}
