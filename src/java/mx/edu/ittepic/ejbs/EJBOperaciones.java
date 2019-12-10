/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ejbs;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.edu.ittepic.entidades.Rol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;


/**
 *
 * @author alon_
 */
@Stateless
public class EJBOperaciones {
@PersistenceContext EntityManager em;
public String nuevoRol(String nombrerol, int idrol){
//em.merge(r);
Rol r=new Rol();
r.setNombrerol(nombrerol);
r.setIdrol(idrol);
String msj;
try{
em.persist(r);
    msj="{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
    
} catch(Exception e){
 msj="{\"codigo\":400, \"msj\":\"Error en los tipos de parametros\"}";
}
        return msj;
    }

    public String consultaRol() {
        try {
            Query q;
            List<Rol> listaRol;
            q=em.createNamedQuery("Rol.findAll");
            listaRol=q.getResultList(); //ejecutar consulta
            //convertir la lista a objetos JSON
            GsonBuilder builder=new GsonBuilder();
            Gson gson=builder.create();
            return gson.toJson(listaRol);
            
        } catch (Exception e) {
            return "{msg:Error}";
        } 
    }
    public String actualiza(int idrol, String nombrerol){
        GsonBuilder builder=new GsonBuilder();
        Gson gson=builder.create();
        String msj;
        Rol rol=new Rol();
        try{
           rol=em.find(Rol.class,idrol); //Buscar por rolid
           rol.setNombrerol(nombrerol);
           em.merge(rol);
           
            msj="{codigo:200- La operacion se realizo correctamente}";
        }catch(NumberFormatException e){
        msj="{codigo:400 msj-Error en los tipos de parametros}";
        }//fin del try
        return msj;
    }//fin actualiza rol
    
public String eliminaRol(int idrol) {

        Rol rol = new Rol();
        String msj;
        try {
            rol = (Rol) em.createNamedQuery("Rol.findByIdrol").setParameter("idrol", idrol).getSingleResult();
            em.remove(em.merge(rol));
            msj = "{\"code\":200,\"msj\":\"La operación se realizo correctamente\"}";
        } catch (NumberFormatException e) {
            msj ="{\"code\":400,\"msj\":\"Error en los tipos de parametros\"}";
            }
            return msj;
        }//eliminar rol
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
