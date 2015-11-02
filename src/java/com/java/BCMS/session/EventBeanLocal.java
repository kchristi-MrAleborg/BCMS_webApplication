/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.BCMS.session;

import javax.ejb.Local;

/**
 *
 * @author mraleborg
 */
@Local
public interface EventBeanLocal {
    void insertEvent(final String name, final String trace, com.java.BCMS.entity.BcmsSession bcmsSession);
}
