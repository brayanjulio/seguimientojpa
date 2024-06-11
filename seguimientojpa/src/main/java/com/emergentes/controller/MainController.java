package com.emergentes.controller;

import com.emergentes.bean.BeanEstudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ESTAMOS EN EL SERVLET");
        try {
            BeanEstudiante dao = new BeanEstudiante();
            Integer id;
            Estudiante est = new Estudiante();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("formestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.buscar(id);
                    System.out.println(est);
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("formestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect(request.getContextPath() + "/MainController");
                    break;
                case "view":
                    List<Estudiante> lista = dao.listartodos();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
        //nuevo();
        mostrar();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");
        int id = 0; // Valor predeterminado o error
        if (!idParameter.isEmpty()) {
            try {
                id = Integer.parseInt(idParameter);
            } catch (NumberFormatException e) {
                // Manejar la excepción si el parámetro "id" no es un número válido
                // Puedes imprimir un mensaje de error o realizar otra acción aquí
                e.printStackTrace(); // Este es solo un ejemplo, puedes manejar el error de otra manera
            }
        }

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        Estudiante est = new Estudiante();
        est.setId(id);
        est.setNombre(nombre);
        est.setApellidos(apellidos);
        est.setEmail(email);
        est.setFechaNacimiento(fechaNacimiento);
        if (id == 0) {
            try {
                BeanEstudiante dao = new BeanEstudiante();
                dao.insertar(est);
                response.sendRedirect(request.getContextPath() + "/MainController");
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }

        } else {
            try {
                BeanEstudiante dao = new BeanEstudiante();
                dao.editar(est);
                response.sendRedirect(request.getContextPath() + "/MainController");
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        }
    }

    private void nuevo() {

        BeanEstudiante dao = new BeanEstudiante();
        Estudiante e = new Estudiante();
        e.setNombre("Casandra");
        e.setApellidos("Gutierrez");
        e.setEmail("casandra@mail.com");
        e.setFechaNacimiento("2020-09-08");
        dao.insertar(e);
    }

    private void mostrar() {
        BeanEstudiante dao = new BeanEstudiante();
        List<Estudiante> lista = dao.listartodos();
        for (Estudiante item : lista) {
            System.out.println(item.toString());
        }
    }
}
