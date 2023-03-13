package com.index.com;
import com.modelo.Estudiante;

import java.sql.SQLException;
import java.util.List;

public interface interfacesCrudEstudiante {

     List listarEstudiante();

     Estudiante selectEstudiante(int id);
     boolean insertEstudiante (Estudiante estudiante);
     boolean updateEstudiante(Estudiante estudiante) throws SQLException;
     boolean deleteEstudiante (int id );


}


