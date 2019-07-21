
package Consultas;

import Conexion.Conexion;
import Models.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Link {
    
    ///Search URIS
    private String sqlGetUser = "SELECT * from persona WHERE ";
    
    ///Register URIS
    private String sqlIncerUser = "INSERT INTO persona(name,id,calif,peso) ";

    private Conexion conexion = new Conexion();
    Random rnd = new Random();
    
    private final List<Persona> listUser = new ArrayList<Persona>();
    
    // función para la consulta de lista de usuarios
    public List<Persona> listUser(){
        Conexion conect1 = new Conexion();
        Connection con1 = conect1.getConnection();
        String sql = "SELECT * FROM persona";
        try
        {
            Statement st = con1.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("name");
                String id = rs.getString("id");
                int calf = rs.getInt("calif");
                float peso = rs.getFloat("peso");

                Persona us =  new Persona(name, id, calf, peso);
                listUser.add(us);
            }
            st.close();
            return listUser;
        }catch (SQLException e){
            System.err.println("Got an exception! ");
            return null;
        }
    }
    
    
    // función para generar consulta de un usuario
    public Persona getUser(String id)
    {
            Conexion conect1 = new Conexion();
            Connection con1 = conect1.getConnection();
            
            String sql = sqlGetUser + "id= '" + id+ "'";
            try
            {
                Statement st = con1.createStatement();
                ResultSet rs = st.executeQuery(sql);

                Persona u = null;
                while(rs.next()){
                    u = new Persona(rs.getString("name"),id, rs.getInt("calif"), rs.getFloat("peso"));
                }
                con1.close();
                return u;
            }    catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al registrar...");
                return null;
        }
    }

    public Persona setUser(Persona persona)
    {
        Connection con = conexion.getConnection();
        Statement st;
        String name = persona.getName();
        String id = persona.getCedula();
        int c = persona.getCalificacion();
        float p = persona.getPeso();
        //System.out.println("+++");
        String sql = sqlIncerUser
                + "VALUES ('" + name + "', '"
                + id + "', '"
                + c + "', '"
                + p + "')";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            con.close();
            Persona u = new Persona(name, id, c, p);
            return u;
        }    catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar...");
            return null;
        }
    }
    
    
}
