/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.session;

import com.pauware.pauware_engine._Exception.Statechart_exception;

/**
 *
 * @author mraleborg
 */
@javax.ejb.Remote
public interface PSC_Remote extends BCMSLocal{
    void PSC_connection_request() throws Statechart_exception;
    void state_police_vehicle_number(int number_of_police_vehicle_required) throws Statechart_exception;
    void route_for_police_vehicles(String route_name) throws Statechart_exception;
    void enough_police_vehicles_dispatched() throws Statechart_exception;
    void police_vehicle_dispatched(String police_vehicle) throws Statechart_exception;
    void enough_police_vehicles_arrived() throws Statechart_exception;
    void police_vehicle_arrived(String police_vehicle) throws Statechart_exception;
    void police_vehicle_breakdown(String police_vehicle,/* may be 'null' */ String replacement_police_vehicle) throws Statechart_exception;
    void police_vehicle_blocked(String police_vehicle) throws Statechart_exception;
    
}
