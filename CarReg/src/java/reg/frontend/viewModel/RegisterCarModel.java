/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.frontend.viewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jboss.weld.context.RequestContext;
import reg.backend.dao.GeneralDao;
import reg.backend.domain.Car;
import reg.backend.domain.Owner;
import reg.backend.domain.PassengerCar;
import reg.backend.domain.Truck;
import reg.backend.utils.REGISTERCODE;


/**
 * @author duncan
 */
@ManagedBean(name="registration")
@SessionScoped
public class RegisterCarModel {
    GeneralDao<Owner> ow = new GeneralDao<>(Owner.class);
    GeneralDao<PassengerCar> pc = new GeneralDao<>(PassengerCar.class);
    GeneralDao<Truck> truc = new GeneralDao<>(Truck.class);
    GeneralDao<Car> c = new GeneralDao<>(Car.class);
    
    private Owner owner = new Owner();
    private Car car = new Car();
    private Truck truck = new Truck();
    private PassengerCar pass = new PassengerCar();
    
    private List<PassengerCar> pcs=new ArrayList<>();

    public Truck getTruck() {
        return truck;
    }

    public PassengerCar getPass() {
        return pass;
    }

    public RegisterCarModel() {
    }
    
    public Owner getOwner(){
        return owner;
    }

    public Car getCar() {
        return car;
    }
    
    public List<Truck> allTrucks(){
        return truc.findAll();
    }
    public String AddTruck(){
        try{
//           Owner owne = ow.findById((Serializable) owner.getId());
//           PassengerCar ca = pc.findById((Serializable) pass.getPlateNo());
         //  System.out.println(owne + " "+ owner.getName());
//            if(owne.){
            ow.save(owner);
            truck.setOwner(owner);
            truc.save(truck);
//            return "works";
//            }
            
//               if(ca.getPlateNo() != pass.getPlateNo() ){
//                pass.setOwner(owner);
//                pc.save(pass);
//                System.out.println("saved"+ pass);
//               }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "REGISTERED SUCCESSFULLY";
    }
    
    public String AddPassenger(){
        try{
//           Owner owne = ow.findById((Serializable) owner.getId());
//           PassengerCar ca = pc.findById((Serializable) pass.getPlateNo());
         //  System.out.println(owne + " "+ owner.getName());
//            if(owne.){
            ow.save(owner);
            pass.setOwner(owner);
            pc.save(pass);
//            return "works";
//            }
            
//               if(ca.getPlateNo() != pass.getPlateNo() ){
//                pass.setOwner(owner);
//                pc.save(pass);
//                System.out.println("saved"+ pass);
//               }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "REGISTERED SUCCESSFULLY";
    }
   
    public void deletePassenger (Car passengerCar){
        try{
        c.delete(passengerCar);
        System.out.println("delete");
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
       public void deleteTruck (Truck truck){
        try{
        truc.delete(truck);
        System.out.println("delete");
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
     public String Update (){
        try{
        this.pass = pass;
        System.out.println("update");
        return "TruckView";
        }catch(Exception e){
            e.printStackTrace();
            return "index";
        }
    }
    
    public String Update (Owner owner){
        try{
        ow.update(owner);
        return "TruckViewEdit";
        }catch(Exception e){
            e.printStackTrace();
            return "index";
        }
    }

    public List<PassengerCar> getPcs() {
        return pc.findAll();
    }
    public List<Owner> allOwners(){
        return ow.findAll();
    }
}
