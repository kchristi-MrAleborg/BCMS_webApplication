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
public interface FSC_Remote extends BCMSLocal{
    void FSC_connection_request() throws Statechart_exception;
    void state_fire_truck_number(int number_of_fire_truck_required) throws Statechart_exception;
    void route_for_fire_trucks() throws Statechart_exception;
    void FSC_agrees_about_fire_truck_route() throws Statechart_exception;
    void FSC_agrees_about_police_vehicle_route() throws Statechart_exception;
    void FSC_disagrees_about_fire_truck_route() throws Statechart_exception;
    void FSC_disagrees_about_police_vehicle_route() throws Statechart_exception;
    void enough_fire_trucks_dispatched() throws Statechart_exception;
    void fire_truck_dispatched(String fire_truck) throws Statechart_exception;
    void enough_fire_trucks_arrived() throws Statechart_exception;
    void fire_truck_arrived(String fire_truck) throws Statechart_exception;
    void fire_truck_breakdown(String fire_truck,/* may be 'null' */ String replacement_fire_truck) throws Statechart_exception;
    void fire_truck_blocked(String fire_truck) throws Statechart_exception;
    
}
