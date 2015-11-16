/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

/**
 *
 * @author mraleborg
 */
@Named(value = "environment")
@ApplicationScoped
public class Environment {
    
    
    private static String firemenRoute = null;
    private static String policemenRoute = null;
    private static int fire_truck_number = 0;
    private static int police_vehicle_number = 0;
    private static boolean fire_truck_route_accepted = false;
    private static boolean police_vehicle_route_accepted = false;
    private static boolean firemenConnected = false;
    private static boolean policemenConnected = false;
    private static boolean fireTruckNumberSet = false; 
    private static java.util.ArrayList dispatchedFireTrucks;
    private static javax.faces.model.SelectItem[] firetrucks;
    private static javax.faces.model.SelectItem[] availableFireTrucks;
    
    protected String chosenRoute;
    
    
    
    /**
     * Creates a new instance of Environment
     */
    public Environment() {
    }
        
    @PostConstruct
    public void init(){
        String firemenRoute = null;
        String policemenRoute = null;
        int fire_truck_number = 0;
        int police_vehicle_number = 0;
        boolean fire_truck_route_accepted = false;
        boolean police_vehicle_route_accepted = false;
        boolean firemenConnected = false;
        boolean policemenConnected = false;
        boolean fireTruckNumberSet = false;
    }
    
    public void removeInAvalableFireTrucks(String ft){
        List<javax.faces.model.SelectItem> l = new java.util.ArrayList(availableFireTrucks.length);
        l.addAll(Arrays.asList(availableFireTrucks));
        availableFireTrucks = null;
        
        for(int i=0; i<l.size(); i++){
            if(((String)(l.get(i)).getValue()) == null ? ft == null : ((String)(l.get(i)).getValue()).equals(ft))
                l.remove(i);
        }
        
        availableFireTrucks = new javax.faces.model.SelectItem[l.size()];
        for(int i = 0; i < l.size(); i++){
            availableFireTrucks[i] = new SelectItem(((String)(l.get(i)).getValue()));
        }
    }
    
    public void addInDispatchedFireTrucks(String ft){
        if(dispatchedFireTrucks == null)
            dispatchedFireTrucks = new ArrayList();
        dispatchedFireTrucks.add(ft);
    }
    
    public ArrayList getDispatchedFireTrucks(){
        return dispatchedFireTrucks;
    }
    
    public javax.faces.model.SelectItem[] getAvailableFireTrucks(){
        return availableFireTrucks;
    }
    
    public javax.faces.model.SelectItem[] getAvailableFireTrucks(javax.faces.model.SelectItem[] ft){
        availableFireTrucks = ft;
        return availableFireTrucks;
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
    
    public boolean getFireTruckNumberSet(){
        return fireTruckNumberSet;
    }
    
    public void setFireTruckNumberSet(boolean b){
        fireTruckNumberSet = b;
    }
    
}
