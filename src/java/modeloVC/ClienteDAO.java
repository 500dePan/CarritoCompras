/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloVC;

import configuraciones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author theen
 */
public class ClienteDAO {
    Conexion conexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    
    public boolean registrar(Cliente cliente) {
        String sql = "INSERT INTO cliente (Dni, Nombres, Direccion, Email, Password) VALUES (?, ?, ?, ?, ?)";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }
    
    public Cliente validar(String email, String password) {
        Conexion conexion = new Conexion();
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE Email = ? AND Password = ?";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getString("Dni"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEmail(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
