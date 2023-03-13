package com.modelo;
import com.configuracion.Conexion;
import com.index.com.interfacesCrudEstudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstudianteDao implements interfacesCrudEstudiante {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @Override
    public List listarEstudiante() {
        List<Estudiante> estudianteList = new ArrayList<>();
        try {
            con = cn.getConexion();
            String selectAllEstudiante = "SELECT * FROM estudiantes";
            pst = con.prepareStatement(selectAllEstudiante);
            rs = pst.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setFechaRegistro(rs.getString("fechaRegistro"));
                estudiante.setNombre(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumento(rs.getString("documento"));
                estudianteList.add(estudiante);
            }
        } catch (SQLException e) {
            System.err.printf("Fallo de la conexion" + e);
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return estudianteList;
    }

    @Override
    public Estudiante selectEstudiante(int id) {
        Estudiante estudiante = new Estudiante();
        try {
            con = cn.getConexion();
            String consultaEstudiantePorIdSql = "SELECT * FROM estudiantes where id=?";
            pst = con.prepareStatement(consultaEstudiantePorIdSql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {

                estudiante.setId(rs.getInt("id"));
                estudiante.setFechaRegistro(rs.getString("fechaRegistro"));
                estudiante.setNombre(rs.getString("nombres"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumento(rs.getString("documento"));
            }

        } catch (SQLException e) {
            System.err.printf("Fallo de la conexion" + e);
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return estudiante;
    }

    @Override
    public boolean insertEstudiante(Estudiante estudiante) {
        try {
            con = cn.getConexion();
            String consultarGurardaEstudianteSql = "INSERT INTO estudiante"
                    + " (fechaRegistro,nombres,apellido,celular,documento) VALUES((now()),?,?,?,?)";

            pst = con.prepareStatement(consultarGurardaEstudianteSql);
            pst.setString(2, estudiante.getNombre());
            pst.setString(3, estudiante.getApellido());
            pst.setString(4, estudiante.getCelular());
            pst.setString(5, estudiante.getDocumento());
            return pst.execute();
        } catch (SQLException e) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, e);
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean updateEstudiante(Estudiante estudiante) throws SQLException {

        try {
            con = cn.getConexion();
            String consultaActualizarEstudianteSql = "UPDATE estudiante SET nombres=?,apellido=?,celular=?,documento=?";
            pst.setString(1, estudiante.getNombre());
            pst.setString(2, estudiante.getApellido());
            pst.setString(3, estudiante.getCelular());
            pst.setString(4, estudiante.getDocumento());
            pst.setInt(5, estudiante.getId());
            pst.executeUpdate();
            return Boolean.TRUE;
        } catch (SQLException e) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, e);
            return Boolean.FALSE;
        }
    }
    @Override
    public boolean  deleteEstudiante(int id) {
        Estudiante estudiante = new Estudiante();
        try {
            con = cn.getConexion();
            String consultarEliminarEstudianteSql = "DELETE  FROM estudiantes where id=?";
            pst.setInt(1, id);
            pst = con.prepareStatement(consultarEliminarEstudianteSql);
            pst.executeUpdate();
            return Boolean.FALSE;

        } catch (SQLException e) {
            Logger.getLogger(EstudianteDao.class.getName()).log(Level.SEVERE, null, e);
            return Boolean.FALSE;
        }

    }
}




