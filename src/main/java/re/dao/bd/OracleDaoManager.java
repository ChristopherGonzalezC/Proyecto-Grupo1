/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.dao.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import re.dao.DAOManager;
import re.dao.DatosDAO;

/**
 *
 * @author kriz_
 */
public class OracleDaoManager implements DAOManager{
    private Connection conn;
    private DatosDAO datos=null;
    
    public OracleDaoManager(String url, String username, String password) throws ClassNotFoundException, SQLException
    {
         Class.forName("oracle.jdbc.OracleDriver");//"oracle.jdbc.driver.OracleDriver"
          conn = DriverManager.getConnection(url, username, password);
         
    }

    @Override
    public DatosDAO getDatosDao() {
        if(datos==null)   {
             datos = new DatosBdDAO(conn);
         } 
         return datos;
    }

    public Connection getConn() {
        return conn;
    }
        
}
