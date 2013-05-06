/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scr;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Isaac
 */
public class Conexion {
    
    private String driver;
    private String url;
    private String base_datos;
    private String usuario;
    private String password;
    
    public Conexion(){
        this.driver="com.mysql.jdbc.Driver";
        this.base_datos="db_esiima";
        this.usuario="root";
        this.password="";
        this.url="jdbc:mysql://localhost:3306/db_esiima?zeroDateTimeBehavior=convertToNull";
    }
    
    public Connection getConnection(){
        Connection con=null;
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(this.url, this.usuario, this.password);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}
