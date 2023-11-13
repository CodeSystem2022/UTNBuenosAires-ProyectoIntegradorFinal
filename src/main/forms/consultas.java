package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class consultas {
    public void guardarUsuario(String usuario, String password, String nombre, String direccion, String telefono){
        ConexionDB db = new ConexionDB();
        //String sql = "insert into usuario(nombre, password) values ('" + usuario +"', '" + pa ssword +"');";
        String sql = "insert into usuario(nombre, email,direccion,telefono, password) values ('"+ nombre +"', '" + usuario +"', '"+  direccion +"', '"+telefono +"', '" + password +"');";
        Statement st;
        Connection conexion = db.conectar();
        try
        {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registración exitosa");
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public void consultarUsuario(String user, String pass)
    {
        // TODO add your handling code here:
        ConexionDB db = new ConexionDB();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
        String nombreusu = null; 
    try {

        
       // rs =cn.setString(1, user);
        //ResultSet rs = pst.executeQuery(user);
//String query = "SELECT email, password, nombre FROM usuario WHERE email = ?";
//PreparedStatement pst = cn.prepareStatement(query);
 //rs =pst.setString(1, user);


        Connection cn = db.conectar();
        String query = "SELECT email, password, nombre FROM usuario WHERE email = '" + user + "'";
        PreparedStatement pst = cn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
 
 
        if (rs.next()) {
            usuarioCorrecto = rs.getString(1);
            passCorrecto = rs.getString(2);
            nombreusu = rs.getString(3);
        }

        if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
            JOptionPane.showMessageDialog(null, "** Bienvenido/a " + nombreusu + "**");
        } else if (!user.equals(usuarioCorrecto) || pass.equals(passCorrecto)) {

            JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos"+usuarioCorrecto+passCorrecto);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error " + e);
    }
    }
    
}
