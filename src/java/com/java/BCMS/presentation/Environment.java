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
    
    
    /**
     * Creates a new instance of Environment
     */
    public Environment() {
    }
    
    public void setVar(){
        var1 = new String();
        var1 = "COUCOU";
    }
    
    public String getVar(){
        return var1;
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
    
}
