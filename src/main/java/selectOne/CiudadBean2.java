package selectOne;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;


@ManagedBean
@RequestScoped
public class CiudadBean2 {
    
    
    private String pais;
    private String ciudad;
    
    private List<String> lstCiudad = new ArrayList<>();

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<String> getLstCiudad() {
        return lstCiudad;
    }

    public void setLstCiudad(List<String> lstCiudad) {
        this.lstCiudad = lstCiudad;
    }
    
    public void cargarCiudades(AjaxBehaviorEvent event){
        
        switch(pais){
            case "mexico":
                lstCiudad.add("MONTERREY");
                lstCiudad.add("VERACRUZ");
                break;
            
            case "peru":
                lstCiudad.add("LIMA");
                lstCiudad.add("CUZCO");
                break;
                
            case "eua":
               lstCiudad.add("CALIFORNIA");
               lstCiudad.add("LOS ANGELES");
                
                break;
                
                
        }
    }
    
    
    public void cargarCiudadesPrime(){
        
        switch(pais){
            case "mexico":
                lstCiudad.add("MONTERREY");
                lstCiudad.add("VERACRUZ");
                break;
            
            case "peru":
                lstCiudad.add("LIMA");
                lstCiudad.add("CUZCO");
                break;
                
            case "eua":
               lstCiudad.add("CALIFORNIA");
               lstCiudad.add("LOS ANGELES");
                
                break;
                
                
        }
    }
    
}
