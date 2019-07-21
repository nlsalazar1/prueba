/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Conexion.Conexion;
import Models.Vehicle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Cert-555
 */
public class LinkVehicle {
    
     
    ///Search URIS
    private String sqlGetVehicle = "SELECT * from vehicle WHERE ";
    
    ///Register URIS
    private String sqlIncerVehi = "INSERT INTO vehicle(idvehicle,brand,model,color,countryOrigin) ";

    private Conexion conexion = new Conexion();
    Random rnd = new Random();
    
    private final List<Vehicle> listVehicles = new ArrayList<Vehicle>();
    
    // función para la consulta de lista de usuarios
    public List<Vehicle> listVehicles(){
        Conexion conect1 = new Conexion();
        Connection con1 = conect1.getConnection();
        String sql = "SELECT * FROM vehicle";
        try
        {
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                String id = rs.getString("idvehicle");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String color = rs.getString("color");
                String country = rs.getString("countryorigin");
                
                Vehicle us =  new Vehicle(id,brand,model,color,country);
                listVehicles.add(us);
            }
            st.close();
            return listVehicles;
        }catch (SQLException e){
            System.err.println("Got an exception! ");
            return null;
        }
    }
    
    
    // función para generar consulta de un vehiculo
    public Vehicle getVehicle(String id)
    {
            Conexion conect1 = new Conexion();
            Connection con1 = conect1.getConnection();
            
            String sql = sqlGetVehicle + "id= '" + id+ "'";
            try
            {
                Statement st = con1.createStatement();
                ResultSet rs = st.executeQuery(sql);

                Vehicle u = null;
                while(rs.next()){
                    u = new Vehicle(id,rs.getString("brand"),rs.getString("model"), rs.getString("color"), rs.getString("countryorigin"));
                }
                con1.close();
                return u;
            }    catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al registrar...");
                return null;
        }
    }

    public Vehicle setVehicle(Vehicle vehicle)
    {
        Connection con = conexion.getConnection();
        Statement st;
        String id = vehicle.getIdvehicle();
        String brand = vehicle.getBrand();
        String model = vehicle.getModel();
        String color = vehicle.getColor();
        String country = vehicle.getCountryorigin();
        
        String sql = sqlIncerVehi
                + "VALUES ('" + id + "', '"
                + brand + "', '"
                + model + "', '"
                + color + "', '"
                + country + "')";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            con.close();
            
            Vehicle u = new Vehicle(id, brand, model, color, country);
            return u;
        }    catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar...");
            return null;
        }
    }
    
}
