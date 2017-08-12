package com.oracle.dao;

import com.oracle.model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends DAO {
    
    public void registrar(Persona persona){
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(""
                    + "INSERT INTO Persona (codigo, nombre, sexo) values (?,?,?)");
            st.setInt(1, persona.getCodigo());
            st.setString(2, persona.getNombre());
            st.setString(3, persona.getSexo());
            
            st.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
       
    }
    
    
    public List<Persona> listar(){
        
        List<Persona> lista = new ArrayList<Persona>();
        ResultSet rs;
       try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT codigo, nombre, sexo FROM Persona");
            rs = st.executeQuery();
            while(rs.next()){
                Persona per = new Persona();
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setSexo(rs.getString("sexo"));
                lista.add(per);
            }
            
        }catch(Exception e){
            
        }finally{
            
        }
        return lista;
    }
    
    
    public Persona leerID(Persona per){
        Persona persona=null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(""
                    + "SELECT codigo, nombre, sexo FROM Persona WHERE codigo = ?");
            st.setInt(1, per.getCodigo());
            rs = st.executeQuery();
            
            while(rs.next()){
                persona = new Persona();
                persona.setCodigo(rs.getInt("codigo"));
                persona.setNombre(rs.getString("nombre"));
                persona.setSexo(rs.getString("sexo"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
        return persona;
    }
    
    
    
    public void modificar(Persona persona){
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(""
                    + "UPDATE Persona SET nombre = ?, sexo = ? WHERE codigo = ?");
            st.setString(1, persona.getNombre());
            st.setString(2, persona.getSexo());
            st.setInt(3, persona.getCodigo());
            
            st.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
    }
    
    
    public void eliminar(Persona persona){
        System.out.println("Antes de Eliminar:::::: " + persona);
        
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement(""
                    + "DELETE FROM Persona WHERE codigo = ?");
            st.setInt(1, persona.getCodigo());
            
            int el = st.executeUpdate();
            System.out.println(" Eliminado ========= " + el);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            this.cerrar();
        }
    }
    
    
    
}
