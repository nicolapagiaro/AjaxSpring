/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Persona;

/**
 *
 * @author FSEVERI\meneghetti3282
 */
public class MainDao {

    /**
     * Metodo che restituisce la lista delle persone
     *
     * @param factory
     * @return
     */
    public static List<Persona> getPersone(SessionFactory factory) {
        Session sessione = factory.openSession();
        List<Persona> persone = (List<Persona>) sessione.createQuery("FROM Persona").list();
        for(Persona p : persone){
            Hibernate.initialize(p.getJobs());
            Hibernate.initialize(p.getDipartimento());
        }
        return persone;
    }
    
    /**
     * 
     * @param factory
     * @param text
     * @return 
     */
    public static List<Persona> searchPersone(SessionFactory factory, String text) {
        Session sessione = factory.openSession();
        List<Persona> persone = (List<Persona>) sessione
                .createQuery("FROM Persona WHERE nome like '%" + text + "%'")
                .list();
        for(Persona p : persone){
            Hibernate.initialize(p.getJobs());
            Hibernate.initialize(p.getDipartimento());
        }
        return persone;
    }
    
}
