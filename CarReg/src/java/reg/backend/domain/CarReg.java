/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.domain;

import org.hibernate.Session;
import reg.backend.utils.HibernateUtil;

/**
 *
 * @author duncan
 */
public class CarReg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Owner ow= new Owner();
        ow.setId("24");
        ow.setName("Duncan");
        
        PassengerCar pc = new PassengerCar();
        pc.setPlateNo("RAC 345 R");
        pc.setModel("TOYOTA");
        pc.setManufacturingYear(1999);
        pc.setNumberOfPassengers(5);
        pc.setOwner(ow);
        
        Truck t = new Truck();
        t.setPlateNo("RAC 435 P");
        t.setModel("BENZ");
        t.setLoadCapacity(45.0);
        t.setManufacturingYear(1994);
        t.setOwner(ow);
        
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(ow);
        ss.save(pc);
        ss.save(t);
        ss.getTransaction().commit();
        ss.close();
    }
    
}
