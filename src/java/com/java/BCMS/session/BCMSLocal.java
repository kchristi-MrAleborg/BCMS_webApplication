/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.session;

import com.pauware.pauware_engine._Exception.Statechart_exception;
import java.util.List;

/**
 *
 * @author mraleborg
 */
@javax.ejb.Local
public interface BCMSLocal {
    void reset() throws Statechart_exception;
    void no_more_route_left() throws Statechart_exception;
    void crisis_is_more_severe() throws Statechart_exception;
    void crisis_is_less_severe() throws Statechart_exception;
    List getRoutes();
}
