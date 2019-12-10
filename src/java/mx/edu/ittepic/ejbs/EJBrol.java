/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ejbs;

import javax.ejb.Stateful;
import javax.ejb.Remote;

/**
 *
 * @author alon_
 */
@Stateful
@Remote (EJBrolRemote.class)
public class EJBrol implements EJBrolRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
