package com.oracle.bean;

import com.oracle.dao.PersonaDAO;
import com.oracle.model.Persona;
import com.oracle.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


@ManagedBean
@ViewScoped
public class PersonaBean {
    
    private Persona persona = new Persona();
    
    private List<Persona> lstPersonas;
   
    private List<String> lstCiudad;
    
    private List<String> lstMunicipio;
    
  
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
    
    public void registrar(){
        System.out.println("Registrar ===========");
        System.out.println("::: " + persona);
        PersonaDAO dao;
        try{
            dao = new PersonaDAO();
            dao.registrar(persona);
        }catch(Exception e){
            
        }
        persona = new Persona();
    }
    
    
     public void listar(){
         System.out.println("Listar ===============");
        PersonaDAO dao;
        try{
            dao = new PersonaDAO();
           lstPersonas = dao.listar();
            System.out.println("=====================");
            System.out.println(lstPersonas);
        }catch(Exception e){
            
        }
    }
     
     
     public void leerID(Persona per) throws Exception {
         PersonaDAO dao;
         Persona temp;
         
         System.out.println("LeerID ====== ");
         
         try{
             dao = new PersonaDAO();
             temp = dao.leerID(per);
             
             if(temp != null) {
                 this.persona = temp;
                 System.out.println("===== " + this.persona);
             }
             
         }catch(Exception e){
             
         }
     }
     
     
     public void modificar(){
        System.out.println("Registrar ===========");
        PersonaDAO dao;
        try{
            dao = new PersonaDAO();
            dao.modificar(persona);
            this.listar();
        }catch(Exception e){
            
        }
    }
     
     
     
     public void eliminar(Persona per){
        System.out.println("Eliminar ===========");
        PersonaDAO dao;
        try{
            dao = new PersonaDAO();
            dao.eliminar(per);
            this.listar();
        }catch(Exception e){
            
        }
    }

    public List<String> getLstCiudad() {
        return lstCiudad;
    }

    public void setLstCiudad(List<String> lstCiudad) {
        this.lstCiudad = lstCiudad;
    }
     
     
    public void cargarCiudadesPrime(){
        
        switch(this.persona.getPais()){
            case "mexico":
                lstCiudad = new ArrayList<>();
                lstCiudad.add("MONTERREY");
                lstCiudad.add("VERACRUZ");
                break;
            
            case "peru":
                lstCiudad = new ArrayList<>();
                lstCiudad.add("LIMA");
                lstCiudad.add("CUZCO");
                break;
                
            case "eua":
               lstCiudad = new ArrayList<>();
               lstCiudad.add("CALIFORNIA");
               lstCiudad.add("LOS ANGELES");
                
                break;
        }
    }
    
    
    
    
    
    public void cargarMunicipios(){
        
        System.out.println("===============================");
        System.out.println("===== Cargar Municipio ========");
        System.out.println(":::: " + persona.getCiudad());

        
        switch(persona.getCiudad()){
            case "MONTERREY":
                lstMunicipio = new ArrayList<>();
                lstMunicipio.add("mo 1");
                lstMunicipio.add("mo 2");
                break;
            
            case "VERACRUZ":
                lstMunicipio = new ArrayList<>();
                lstMunicipio.add("ve 1");
                lstMunicipio.add("ve 2");
                break;
                
            case "LIMA":
               lstMunicipio = new ArrayList<>();
               lstMunicipio.add("li 1");
               lstMunicipio.add("li 1");
            break;
            
            case "CUZCO":
               lstMunicipio = new ArrayList<>();
               lstMunicipio.add("cu 1");
               lstMunicipio.add("cu 1");  
            break;
            
            case "CALIFORNIA":
               lstMunicipio = new ArrayList<>();
               lstMunicipio.add("ca 1");
               lstMunicipio.add("ca 1");
                
             break;
            
            case "LOS ANGELES":
               lstMunicipio = new ArrayList<>();
               lstMunicipio.add("ang 1");
               lstMunicipio.add("ang 1");
                
            break;
        }
    }

    public List<String> getLstMunicipio() {
        return lstMunicipio;
    }

    public void setLstMunicipio(List<String> lstMunicipio) {
        this.lstMunicipio = lstMunicipio;
    }
     
}
