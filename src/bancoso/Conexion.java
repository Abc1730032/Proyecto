/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoso;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Enrique
 */
public class Conexion {
    public Connection Conexion(){
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://172.16.0.11:5432/Banco","user1","123456");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return conexion;
    }
}
