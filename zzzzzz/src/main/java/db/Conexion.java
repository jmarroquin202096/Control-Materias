/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Josué Daniel Marroquín Hernández <jmarroquin-2020296@kinal.edu.gt>
 * @date 09-nov-2021
 * @time 12:28:36
 * Codigo Tecnico: IN5BV
 * Carnet: 2020296
 */
public class Conexion {
    
    private static final String DB = "control_materias";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB + "?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false&useTimezone=true";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        //Singleton
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(URL);
            dataSource.setUsername(USER);
            dataSource.setPassword(PASS);
            dataSource.setInitialSize(25);
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement pstmt){
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
