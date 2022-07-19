/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MateriaDaoImpl;
import domain.Materia;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josué Daniel Marroquín Hernández <jmarroquin-2020296@kinal.edu.gt>
 * @date 09-nov-2021
 * @time 13:55:14 Codigo Tecnico: IN5BV Carnet: 2020296
 */
@WebServlet("/ServletMateria")
public class ServletMateria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        System.out.println("\ndoPost");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarMateria(request, response);
                    break;
                case "actualizar":
                    actualizarMateria(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarMateria(request, response);
                    break;
                case "editar":
                    editarMateria(request, response);
                    break;
                case "eliminar":
                    eliminarMateria(request, response);
            }
        }

    }

    private void listarMateria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Materia> listaMateria = new MateriaDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaMateria", listaMateria);
        sesion.setAttribute("cantmaterias", getMaterias());
        response.sendRedirect("Materia/listar-materia.jsp");
    }
    
    public int getMaterias() {

        List<Materia> listaMateria = new MateriaDaoImpl().listar();

        int cantMaterias = listaMateria.size();

        return cantMaterias;
    }

    private void eliminarMateria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idMateria = Integer.parseInt(request.getParameter("idMateria"));

        Materia materia = new Materia(idMateria);

        int registroEliminado = new MateriaDaoImpl().eliminar(materia);
        System.out.println("materia eliminada" + registroEliminado);

        listarMateria(request, response);

    }

    private void editarMateria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("\nEditar");
        //Recuperar el Carne del Alumno
        int idMateria = Integer.parseInt(request.getParameter("idMateria"));

        //Crear objeto de tipo Alumno
        Materia materia = new MateriaDaoImpl().encontrar(new Materia(idMateria));

        request.setAttribute("materia", materia);

        request.getRequestDispatcher("Materia/editar-materia.jsp").forward(request, response);

    }

    private void insertarMateria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("\nInsertar");

        String nombreMateria = request.getParameter("nombre");
        Date cicloEscolar = Date.valueOf(request.getParameter("ciclo"));
        
        Time horarioInicio = Time.valueOf("00:00:00");
        Time horarioFinal = Time.valueOf("00:00:00");
        String horarioInicio2 = request.getParameter("horarioInicio");
        String horarioFinal1 = request.getParameter("horarioFinal");

        horarioInicio = Time.valueOf(horarioInicio2 + ":00");
        horarioFinal = Time.valueOf(horarioFinal1 + ":00");

        String catedratico = request.getParameter("catedratico");
        String salon = request.getParameter("salon");
        int cupoMaximo = Integer.parseInt(request.getParameter("cupomax"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupomin"));

        Materia materia = new Materia(nombreMateria, cicloEscolar, horarioInicio, horarioFinal, catedratico, salon, cupoMaximo, cupoMinimo);

        int registroIngresados = new MateriaDaoImpl().insertar(materia);

        System.out.println("registors Ingresado" + registroIngresados);

        listarMateria(request, response);

    }

    private void actualizarMateria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("\nActualizar");

        int idMateria = Integer.parseInt(request.getParameter("idMateria"));
        

        String nombreMateria = request.getParameter("nombre");
        Date cicloEscolar = Date.valueOf(request.getParameter("ciclo"));
        
        Time horarioInicio = Time.valueOf("00:00:00");
        Time horarioFinal = Time.valueOf("00:00:00");
        
        String horarioInicio2 = request.getParameter("horarioInicio");
        String horarioFinal1 = request.getParameter("horarioFinal");

        horarioInicio = Time.valueOf(horarioInicio2 + ":00");
        horarioFinal = Time.valueOf(horarioFinal1 + ":00");
        
        String catedratico = request.getParameter("catedratico");
        String salon = request.getParameter("salon");
        int cupoMaximo = Integer.parseInt(request.getParameter("cupomax"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupomin"));

        //Crear el Objeto Asiganacion Alumno utilizando el Bean
        Materia materia = new Materia(idMateria, nombreMateria, cicloEscolar, horarioInicio, horarioFinal, catedratico, salon, cupoMaximo, cupoMinimo);
        System.out.println(materia);

        //Ingresar el Registro Actualizado en la Base de Datos
        int registrosIngresados = new MateriaDaoImpl().actualizar(materia);

        //Imprimir Datos en Consola
        System.out.println("registors actualizados" + registrosIngresados);

        //Llamar al Metodo Listar Asigancion Alumno
        listarMateria(request, response);
    }
}
