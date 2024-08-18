/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuraciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/db_carritocompras";
    String user = "";
    String pass = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) 
        {
        }
        return con;
    }
}
