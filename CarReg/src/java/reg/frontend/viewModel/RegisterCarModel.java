/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.frontend.viewModel;

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


/**
 *
 * @author duncan
 */
@ManagedBean(name="registration")
@SessionScoped
public class RegisterCarModel {
    GeneralDao<Owner> ow = new GeneralDao<>(Owner.class);
    GeneralDao<PassengerCar> pc = new GeneralDao<>(PassengerCar.class);
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
    
    public List<Owner> allCars(){
        return ow.findAll();
    }
    
    public void Add(){
        try{
           
            ow.save(owner);
            pass.setOwner(owner);
            pc.save(pass);
//            RequestContext.getCurrentInstance().reset("form:panelform");
            System.out.println("saved"+ pass);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void update(){
        
    }
    public void delete (Owner owner){
        try{
        ow.delete(owner);
        System.out.println("delete");
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
     public String Update (){
        try{
        this.owner = owner;
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
//        System.out.println("update");
        
        }catch(Exception e){
            e.printStackTrace();
            return "index";
        }
    }

    public List<PassengerCar> getPcs() {
        return pc.findAll();
    }
     
}
