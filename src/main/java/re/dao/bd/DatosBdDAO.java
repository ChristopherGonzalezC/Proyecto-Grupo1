/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.dao.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import re.dao.DAOException;
import re.dao.DatosDAO;
import re.modelo.Datos;

/**
 *
 * @author kriz_
 */
public class DatosBdDAO implements DatosDAO{
    
    final String INSERT = "INSERT INTO datos(id, dispositivo, dias, hora, lugar, situacion, tiempo, emergencia) values(?,?,?,?,?,?,?,?)";
    final String UPDATE = "UPDATE datos SET id = ?, dispositivo = ?, dias = ?,hora = ?, lugar = ?, situacion = ?, tiempo = ?, emergencia = ? where id=? ";
    final String DELETE = "DELETE FROM datos where id=? ";
    final String GETALL = "SELECT * FROM datos";
    final String GET0NE = "SELECT * FROM datos where id=?";

    private Connection conn;

    public DatosBdDAO(Connection conn) {
        this.conn = conn;
    }   
        
    @Override
    public void insertar(Datos a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getCod_Datos());
            stmt.setString(2, a.getDispositivo());
            stmt.setString(3, a.getDias());
            stmt.setString(4, a.getHora());
            stmt.setString(5, a.getLugar());
            stmt.setString(6, a.getSituacion());
            stmt.setDouble(7, a.getTiempo());
            stmt.setString(8, a.getEmergencia());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Datos a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(INSERT);
            stmt.setInt(1, a.getCod_Datos());
            stmt.setString(2, a.getDispositivo());
            stmt.setString(3, a.getDias());
            stmt.setString(4, a.getHora());
            stmt.setString(5, a.getLugar());
            stmt.setString(6, a.getSituacion());
            stmt.setDouble(7, a.getTiempo());
            stmt.setString(8, a.getEmergencia());       
           
            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha modificado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminar(Integer a) throws DAOException {
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, a);

            if (stmt.executeUpdate() == 0) {
                throw new DAOException("El registro no se ha borrado");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Datos> obtenerTodos() throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Datos> da = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(GETALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                da.add(convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return da;
    }

    @Override
    public List<Datos> obtenerLista(Integer a) throws DAOException {return null;}

    private Datos convertir(ResultSet rs) throws SQLException { //Java: JDBC – 14
        int cod_datos = rs.getInt("id");
        String dispositivo = rs.getString("dispositivo");
        String dias = rs.getString("dias");
        String hora = rs.getString("hora");
        String lugar = rs.getString("lugar");
        String situacion = rs.getString("situacion");
        Double tiempo = rs.getDouble("tiempo");
        String emergencia = rs.getString("emergencia");
        Datos da = new Datos(cod_datos,dispositivo,dias,hora,lugar,situacion,tiempo,emergencia);
        da.setCod_Datos(rs.getInt("id"));//revisar
        return da;

    }

    @Override
    public Datos obtener(Integer id) throws DAOException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Datos da = null;
        try {
            stmt = conn.prepareStatement(GET0NE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                da = convertir(rs);
            } else {
//                throw new DAOException("No se encontro el registro");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatosBdDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return da;
    }
    
}
