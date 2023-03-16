<%@ page import="com.modelo.EstudianteDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.modelo.Estudiante" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
        <title>JSP - PAGE </title>
</head>
    <body>
 <%
     EstudianteDao dao = new EstudianteDao();
     List<Estudiante> list = dao.listarEstudiante();
 %>
     <!DOCTYPE html>
     <html lang="es">
     <head>

         <title>Proyecto</title>
         <meta charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

     </head>
     <body>

     <div class="container">
         <h2>Lista de estudiante </h2>
         <p>Este es el listado de estudiantes que se encuentren registrados en el colegio</p>
         <input class="form-control" id="myInput" type="text" placeholder="Search..">
         <br>
         <table class="table table-bordered table-striped">
             <thead>
             <tr>
                 <th>id</th>
                 <th>fechaRegistro</th>
                 <th>Firstname</th>
                 <th>Lastname</th>
                 <th>celular</th>
                 <th>documento</th>
                 <th>estado</th>
             </tr>
             </thead>
             <tbody id="myTable">

             <%
                 for(Estudiante e : list){
             %>

             <tr
             <%=
                 e.getestado()  ? "style=\"background-color:#b3dfb3;\"º" : "style=\"background-color:#d1b6bc;\""
             %>
             >
                 <td><%=e.getId()%></td>
                 <td><%=e.getFechaRegistro() == null ? "" :e.getFechaRegistro()%></td>
                     <td><%=e.getNombre()%></td>
                         <td><%=e.getApellido()%></td>
                             <td><%=e.getCelular()%></td>
                                 <td><%=e.getDocumento()%></td>
                                     <td><%=e.getestado()%></td>

             </tr>
             <%
                 }
             %>

             </tbody>
         </table>

     </div>

     <script>
         $(document).ready(function(){
             $("#myInput").on("keyup", function() {
                 var value = $(this).val().toLowerCase();
                 $("#myTable tr").filter(function() {
                     $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                 });
             });
         });
     </script>

     </body>
                <footer style="text-align: center">No robar mi pagina web</footer>
     </html>

    </body>
</html>