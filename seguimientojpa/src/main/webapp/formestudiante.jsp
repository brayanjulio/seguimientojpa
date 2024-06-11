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
            <h1 class="text-center">Formulario de Estudiantes</h1>
            <br>
            <div class="container col-4">
                <div class="card">
                    <div class="card-header">
                        Estudiantes
                    </div>
                    <div class="card-body">
                        <form action="MainController" method="post">
                            <input type="hidden" name="id" value="${estudiante.id}">
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombre" id="nombre" value="${estudiante.nombre}" class="form-control" placeholder="Escriba su nombre">
                            </div>
                            <div class="mb-3">
                                <label for="apellidos" class="form-label">Apellidos:</label>
                                <input type="text" name="apellidos" id="apellidos" value="${estudiante.apellidos}" class="form-control" placeholder="Escriba sus apellidos">
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email:</label>
                                <input type="email" name="email" id="email" value="${estudiante.email}" class="form-control" placeholder="ejemplo@mail.com">
                            </div>
                            <div class="mb-3">
                                <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento:</label>
                                <input type="date" name="fechaNacimiento" id="fechaNacimiento" value="${estudiante.fechaNacimiento}" class="form-control" placeholder="Fecha de Nacimiento">
                            </div>
                            <button type="submit" class="btn btn-success"><i class="bi bi-floppy"> Enviar</i></button>
                            <a href="MainController" class="btn btn-info"><i class="bi bi-arrow-return-left"> Volver</i></a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
