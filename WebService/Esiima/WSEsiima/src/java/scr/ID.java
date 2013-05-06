/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Isaac
 */

@Stateless
@Path("/verificar")
public class ID {
    
    @GET
    @Path("getAcces")
    public String getAcces(@QueryParam("id") long base,@QueryParam("pass") String pass) {
        Connection con=null;
        String sql="";
        Statement sentencia=null;
        ResultSet resultado=null;
        String contrase="";
        Conexion miConexion=new Conexion();
        String conf="false";
        try{
            con= miConexion.getConnection();
            sql="Select password From alumno where id="+base+";";
            sentencia=con.createStatement();
            resultado=sentencia.executeQuery(sql);
            while(resultado.next()){
                contrase=resultado.getString("password");
            }
            if(contrase.equals(pass)){
                conf="true";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try {
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conf;
        }
    }
    
    @GET
    @Path("getData")
    public String getAll(@QueryParam("id") long base) {
        Connection con=null;
        String sql="";
        Statement sentencia=null;
        ResultSet resultado=null;
        String nombre="";
        Conexion miConexion=new Conexion();
        try{
            con= miConexion.getConnection();
            sql="Select * From alumno where id="+base+";";
            sentencia=con.createStatement();
            resultado=sentencia.executeQuery(sql);
            while(resultado.next()){
                nombre="{'nombre':'"+resultado.getString("nombre")+"','"+
                       "situacion':'"+resultado.getString("situacion")+"','"+
                       "id':"+resultado.getString("id")+",'"+
                       "generacion':'"+resultado.getString("generacion")+"'}";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try {
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            return nombre;
        }
    }
    
    @GET
    @Path("getCalificaciones")
    public String getCalificaciones(@QueryParam("id") long base) {
        Connection con=null;
        String sql="";
        Statement sentencia=null;
        ResultSet resultado=null;
        String nombre="",res="";
        Conexion miConexion=new Conexion();
        try{
            con= miConexion.getConnection();
            sql="SELECT c.id_parcial, c.calificacion, materia.nombre "
                    + "FROM alumno, grupo_has_materia g, alumno_has_calificacion c, materia "
                    + "WHERE alumno.id ="+base+" "
                    + "AND g.id_grupo = alumno.id_grupo "
                    + "AND c.id_materia = g.id_materia "
                    + "AND materia.id = c.id_materia;";
            sentencia=con.createStatement();
            resultado=sentencia.executeQuery(sql);
            res="[";
            while(resultado.next()){
                nombre="{'nombre':'"+resultado.getString("nombre")+"','"+
                       "calificacion':"+resultado.getInt("calificacion")+",'"+
                       "id_parcial':"+resultado.getInt("id_parcial")+"},";
                res+=nombre;
            }
            res=res.substring(0, res.length()-1)+"]";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try {
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            return res;
        }
    }
    
    @GET
    @Path("getFaltas")
    public String getFaltas(@QueryParam("id") long base) {
        Connection con=null;
        String sql="";
        Statement sentencia=null;
        ResultSet resultado=null;
        String nombre="",res="";
        Conexion miConexion=new Conexion();
        try{
            con= miConexion.getConnection();
            sql="SELECT f.id_parcial, f.faltas, materia.nombre "
                    + "FROM alumno, grupo_has_materia g, alumno_has_faltas f, materia "
                    + "WHERE alumno.id ="+base+" "
                    + "AND g.id_grupo = alumno.id_grupo "
                    + "AND f.id_materia = g.id_materia "
                    + "AND materia.id = f.id_materia;";
            sentencia=con.createStatement();
            resultado=sentencia.executeQuery(sql);
            res="[";
            while(resultado.next()){
                nombre="{'nombre':'"+resultado.getString("nombre")+"','"+
                       "faltas':"+resultado.getInt("faltas")+",'"+
                       "id_parcial':"+resultado.getInt("id_parcial")+"},";
                res+=nombre;
            }
            res=res.substring(0, res.length()-1)+"]";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try {
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ID.class.getName()).log(Level.SEVERE, null, ex);
            }
            return res;
        }
    }
}