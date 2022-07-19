/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import domain.Materia;
import idao.IMateriaDao;
import db.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Josué Daniel Marroquín Hernández <jmarroquin-2020296@kinal.edu.gt>
 * @date 09-nov-2021
 * @time 12:41:24
 * Codigo Tecnico: IN5BV
 * Carnet: 2020296
 */
public class MateriaDaoImpl implements IMateriaDao{
    
    private static final String SQL_SELECT = "SELECT * FROM materia";
    private static final String SQL_DELETE = "DELETE FROM materia WHERE id_materia = ?";
    private static final String SQL_INSERT = "INSERT INTO materia(nombre_materia, ciclo_escolar, horario_inicio, horario_final, catedratico, salon, cupo_maximo, cupo_minimo) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE materia SET nombre_materia = ?, ciclo_escolar = ?, horario_inicio = ?, horario_final = ?, catedratico = ?, salon = ?, cupo_maximo = ?, cupo_minimo = ? WHERE id_materia = ?";
    private static final String SQL_SELECT_BY_CARNE = "SELECT * FROM materia WHERE id_materia = ?";
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Materia materia = null;
    List<Materia> listarMateria = new ArrayList<>();

    @Override
    public List<Materia> listar() {
       try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idMateria = rs.getInt("id_materia");
                String nombreMateria = rs.getString("nombre_materia");
                Date cicloEscolar = rs.getDate("ciclo_escolar");
                Time horarioInicio = rs.getTime("horario_inicio");
                Time horarioFinal = rs.getTime("horario_final");
                String catedratico = rs.getString("catedratico");
                String salon = rs.getString("salon");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");

                materia = new Materia(idMateria, nombreMateria, cicloEscolar, horarioInicio, horarioFinal, catedratico, salon, cupoMaximo, cupoMinimo);
                listarMateria.add(materia);

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return listarMateria;
    }

    @Override
    public Materia encontrar(Materia materia) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_CARNE);
            pstmt.setInt(1, materia.getIdMateria());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombreMateria = rs.getString("nombre_materia");
                Date cicloEscolar = rs.getDate("ciclo_escolar");
                Time horarioInicio = rs.getTime("horario_inicio");
                Time horarioFinal = rs.getTime("horario_final");
                String catedratico = rs.getString("catedratico");
                String salon = rs.getString("salon");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");

                materia.setNombreMateria(nombreMateria);
                materia.setCicloEscolar(cicloEscolar);
                materia.setHorarioInicio(horarioInicio);
                materia.setHorarioFinal(horarioFinal);
                materia.setCatedratico(catedratico);
                materia.setSalon(salon);
                materia.setCupoMaximo(cupoMaximo);
                materia.setCupoMinimo(cupoMinimo);

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return materia;
    }

    @Override
    public int insertar(Materia materia) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, materia.getNombreMateria());
            pstmt.setDate(2, materia.getCicloEscolar());
            pstmt.setTime(3, materia.getHorarioInicio());
            pstmt.setTime(4, materia.getHorarioFinal());
            pstmt.setString(5, materia.getCatedratico());
            pstmt.setString(6, materia.getSalon());
            pstmt.setInt(7, materia.getCupoMaximo());
            pstmt.setInt(8, materia.getCupoMinimo()); 
            
            rows = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return rows;
    }

    @Override
    public int actualizar(Materia materia) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, materia.getNombreMateria());
            pstmt.setDate(2, materia.getCicloEscolar());
            pstmt.setTime(3, materia.getHorarioInicio());
            pstmt.setTime(4, materia.getHorarioFinal());
            pstmt.setString(5, materia.getCatedratico());
            pstmt.setString(6, materia.getSalon());
            pstmt.setInt(7, materia.getCupoMaximo());
            pstmt.setInt(8, materia.getCupoMinimo());
            pstmt.setInt(9, materia.getIdMateria());
            
            System.out.println(pstmt.toString());
            
           rows = pstmt.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return rows;
    }

    @Override
    public int eliminar(Materia materia) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, materia.getIdMateria());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    
    
}
