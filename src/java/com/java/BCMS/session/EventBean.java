/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.session;

import com.java.BCMS.entity.BcmsSession;
import javax.ejb.Stateless;

/**
 *
 * @author mraleborg
 */
@Stateless
public class EventBean implements EventBeanLocal {
    
    
    @javax.persistence.PersistenceContext(name = "BCMS_webApplicationPU")
    private javax.persistence.EntityManager _entity_manager;
    
    //private BcmsSession _bcmsSession;

    public EventBean() {
    }
    
    
    @Override
    public void insertEvent (final String name, final String trace, com.java.BCMS.entity.BcmsSession _bcmsSession){
        java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        java.util.Date date = new java.util.Date();
        
        try{
            com.java.BCMS.entity.Event event = new com.java.BCMS.entity.Event(new com.java.BCMS.entity.EventPK(name, (format.format(date))));
            event.setSessionId(_bcmsSession);
            event.setExecutionTrace(trace);
            _entity_manager.persist(event);
        }catch(Exception e){
            e.printStackTrace();
            if(_entity_manager==null)
            {
                System.out.println("ENTITY MANAGER NULL");
            }
        }
    }
}
