<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <title>Seguimiento</title>
    </head>
    <body>
        <div class="container ">
            <h1 class="text-center">REGISTRO</h1>
            <a class="btn btn-primary btn-sm" style="background: orange" href="MainController?action=add"><i class="bi bi-plus-circle"> Nuevo</i></a>
            <br>
            <br>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDOS</th>
                    <th>EMAIL</th>
                    <th>FECHA DE NACIMIENTO</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${estudiantes}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombre}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.email}</td>
                        <td>${item.fechaNacimiento}</td>
                        <td><a class="btn btn-warning" href="MainController?action=edit&id=${item.id}"  >EDITAR</a></td>
                        <td><a class="btn btn-danger" href="MainController?action=delete&id=${item.id}"  onclick="return(confirm('Esta seguro de eliminar?'))">ELIMINAR
                            </a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>