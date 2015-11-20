/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.presentation;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import org.apache.jasper.tagplugins.jstl.ForEach;

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
    private static boolean policeVehicleNumberSet = false;
    private static java.util.ArrayList dispatchedFireTrucks;
    private static javax.faces.model.SelectItem[] firetrucks;
    private static javax.faces.model.SelectItem[] availableFireTrucks;
    private static java.util.Map<String, String> trucksStates;
    private static java.util.ArrayList dispatchedPoliceVehicles;
    private static javax.faces.model.SelectItem[] policeVehicles;
    private static javax.faces.model.SelectItem[] availablePoliceVehicles;
    private static java.util.Map<String, String> policeVehicleStates;
    //private static enum states{ Arrived, Blocked, Breakdown }
    
    protected String chosenRoute;
    
    
    
    /**
     * Creates a new instance of Environment
     */
    public Environment() {
    }
        
    @PostConstruct
    public void init(){
        trucksStates = new HashMap<>() ;
        policeVehicleStates = new HashMap<>();
    }
    
    public void reset(/*String parentComponentId*/) throws IOException{
        firemenRoute = null;
        policemenRoute = null;
        fire_truck_number = 0;
        police_vehicle_number = 0;
        fire_truck_route_accepted = false;
        police_vehicle_route_accepted = false;
        fireTruckNumberSet = false;
        policeVehicleNumberSet = false;
        availableFireTrucks = null;
        dispatchedFireTrucks = null;
        dispatchedPoliceVehicles = null;
        availablePoliceVehicles = null;
        policeVehicleStates = null;
        policeVehicleStates = new HashMap<>();
        trucksStates = null ;
        trucksStates = new HashMap<>();
        
        /*UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent fc = view.findComponent(parentComponentId);
        List<String> c_id = new ArrayList<>();
        for(UIComponent c : view.getChildren()){
            c_id.add(c.getId());
        }
        view.resetValues(FacesContext.getCurrentInstance(), c_id);
        if (null != fc) {
            List<UIComponent> components = fc.getChildren();
            for (UIComponent component : components) {
                if (component instanceof UIInput) {
                    UIInput input = (UIInput) component;
                    // JSF 1.1+ 
//                input.setSubmittedValue(null);
//                input.setValue(null);
//                input.setLocalValueSet(false);
//                input.setValid(true);
                    // JSF 1.2+
                    ((UIInput) component).resetValue();
                    
                }
                component.clearInitialState();
            }
        }*/
    }
    
    public java.util.Map<String, String> getTruckStates(){
        return trucksStates;
    }
    public void setTruckStates(java.util.Map<String, String> m){
        trucksStates = m;
    }
    
    public void addTruckState(String key, String value){
        trucksStates.put(key, value);
    }
    
    public void setFireTruckState(String key, String value){
        trucksStates.replace(key, value);
    }
    
    public java.util.Map<String, String> getPoliceVehicleStates(){
        return policeVehicleStates;
    }
    public void setPoliceVehicleStates(java.util.Map<String, String> m){
        policeVehicleStates = m;
    }
    
    public void addPoliceVehicleState(String key, String value){
        policeVehicleStates.put(key, value);
    }
    
    public void setPoliceVehicleState(String key, String value){
        policeVehicleStates.replace(key, value);
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
    
    public void removeInAvailablePoliceVehicles(String pv){
        List<javax.faces.model.SelectItem> l = new java.util.ArrayList(availablePoliceVehicles.length);
        l.addAll(Arrays.asList(availablePoliceVehicles));
        availablePoliceVehicles = null;
        
        for(int i=0; i<l.size(); i++){
            if(((String)(l.get(i)).getValue()) == null ? pv == null : ((String)(l.get(i)).getValue()).equals(pv))
                l.remove(i);
        }
        
        availablePoliceVehicles = new javax.faces.model.SelectItem[l.size()];
        for(int i = 0; i < l.size(); i++){
            availablePoliceVehicles[i] = new SelectItem(((String)(l.get(i)).getValue()));
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
    
    public void addInDispatchedPoliceVehicles(String pv){
        if(dispatchedPoliceVehicles == null)
            dispatchedPoliceVehicles = new ArrayList();
        dispatchedPoliceVehicles.add(pv);
    }
    
    public ArrayList getDispatchedPoliceVehicles(){
        return dispatchedPoliceVehicles;
    }
    
    public javax.faces.model.SelectItem[] getAvailableFireTrucks(){
        return availableFireTrucks;
    }
    
    public javax.faces.model.SelectItem[] getAvailableFireTrucks(javax.faces.model.SelectItem[] pv){
        availableFireTrucks = pv;
        return availableFireTrucks;
    }
    
    public javax.faces.model.SelectItem[] getAvailablePoliceVehicles(){
        return availablePoliceVehicles;
    }
    
    public javax.faces.model.SelectItem[] getAvailablePoliceVehicles(javax.faces.model.SelectItem[] pv){
        availablePoliceVehicles = pv;
        return availablePoliceVehicles;
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
    
    public boolean getPoliceVehicleNumberSet(){
        return policeVehicleNumberSet;
    }
    
    public void setPoliceVehicleNumberSet(boolean b){
        policeVehicleNumberSet = b;
    }
    
}
