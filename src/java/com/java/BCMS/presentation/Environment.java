/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

/**
 *
 * @author mraleborg
 */
@Named(value = "environment")
@ApplicationScoped
public class Environment {

    private static String var1 = null;
    
    private static String firemenRoute = null;
    private static String policemenRoute = null;
    private static int fire_truck_number = 0;
    private static int police_vehicle_number = 0;
    private static boolean fire_truck_route_accepted = false;
    private static boolean police_vehicle_route_accepted = false;
    private static boolean firemenConnected = false;
    private static boolean policemenConnected = false;
    
    protected String chosenRoute;
    
    
    
    /**
     * Creates a new instance of Environment
     */
    public Environment() {
    }
    
    public int getFireTruckNumber() {
        return fire_truck_number;
    }
 
    public void setFireTruckNumber(int n) {
        fire_truck_number = n;
    }
    
    public int getPoliceVehicleNumber(){
        return police_vehicle_number;
    }
    
    public void setPoliceVehicleNumber(int n){
        police_vehicle_number = n;
    }
    
    public void setFiremenRoute(String s){
        //firemenRoute = new String();
        firemenRoute = s;
    }
    
    public void setPolicemenRoute(String s){
        //policemenRoute=new String();
        policemenRoute = s;
    }
    
    public String getFiremenRoute(){
        return firemenRoute;
    }
    
    public String getPolicemenRoute(){
        return policemenRoute;
    }
    
    public boolean getFireTruckRouteAccepted(){
        return fire_truck_route_accepted;
    }
    
    public void setFireTruckRouteAccepted(boolean b){
        fire_truck_route_accepted = b;
    }
    
    public boolean getPoliceVehicleRouteAccepted(){
        return police_vehicle_route_accepted;
    }
    
    public void setPoliceVehicleRouteAccepted(boolean b){
        police_vehicle_route_accepted = b;
    }
    
    public void firemenRouteAccepted(){
        setFireTruckRouteAccepted(true);
    }
    
    public void firemenRouteRefused(){
        setFireTruckRouteAccepted(false);
    }
    
    public void policemenRouteAccepted(){
        setPoliceVehicleRouteAccepted(true);
    }
    
    public void policemenRouteRefused(){
        setPoliceVehicleRouteAccepted(false);
    }
    
    public boolean getFiremenConnected(){
        return firemenConnected;
    }
    
    public void setFiremenConnected(boolean b){
        firemenConnected = b;
    }
    
    public boolean getPolicemenConnected(){
        return policemenConnected;
    }
    
    public void setPolicemenConnected(boolean b){
        policemenConnected = b;
    }
    
}
