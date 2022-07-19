<%-- 
    Document   : listar-materia
    Created on : 09-nov-2021, 12:00:45
    Author     : Daniel Marroquin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Source+Code+Pro:wght@200&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../assets/css/style.css"/>
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <!-- bootsrap -->
        <link rel="stylesheet" href="../assets/css/bootstrap.css">

        <title>Materias</title>
    </head>
    <body id="body_Kinal">

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <header id="main-header" class="py-2 bg-dark text-light text-center">
            <div class="conteiner">
                <div class="row">
                    <div class="col-12">
                        <h1><i class="fas fa-book"></i>
                            Materias
                        </h1>
                    </div>
                </div>
            </div>
        </header>
        <div class="modal fade" id="agregar-materia-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header text-white bg-dark">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Nuevo Registro</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletMateria">
                        <div class="modal-body bg-dark text-dark">
                            <div class="form-floating mb-3">
                                <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre de la Materia">
                                <label for="nombre" class="form-label">Nombre de la Materia</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="date" id="ciclo" name="ciclo" class="form-control" placeholder="Ciclo Escolar">
                                <label for="ciclo" class="form-label">Ciclo Escolar</label>
                            </div>   
                            <div class="form-floating mb-3">
                                <input type="time" id="horarioInicio" name="horarioInicio" class="form-control" placeholder="Horario Inicio">
                                <label for="horarioInicio" class="form-label">Horario Inicio</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="time" id="horarioFinal" name="horarioFinal" class="form-control" placeholder="Horario Final">
                                <label for="horarioFinal" class="form-label">Horario Final</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" id="catedratico" name="catedratico" class="form-control" placeholder="Catedratico">
                                <label for="catedratico" class="form-label">Catedratico</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" id="salon" name="salon" class="form-control" placeholder="Salon">
                                <label for="salon" class="form-label">Salon</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="number" id="cupomax" name="cupomax" class="form-control" placeholder="Cupo Maximo">
                                <label for="cupomax" class="form-label">Cupo Maximo</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="number" id="cupomin" name="cupomin" class="form-control" placeholder="Cupo Minimo">
                                <label for="cupomin" class="form-label">Cupo Minimo</label>
                            </div>

                            <input type="hidden" name="accion" value="insertar">
                        </div>
                        <div class="modal-footer bg-dark">
                            <button type="button" class="btn btn-outline-danger" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-outline-success">Guardar</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <section id="materias">
            <div class="conteiner">
                <div class="row">
                    <div class="col-12 bg-dark">
                        <table class="table table-dark table-sm table-bordered border-light text-center"> 
                            <thead class="table-dark">
                                <tr>
                                    <th>No.</th>
                                    <th>Materia</th>
                                    <th>Ciclo Escolar</th>
                                    <th>Horario Inicio</th>
                                    <th>Horario Final</th>
                                    <th>Catedratico</th>
                                    <th>Salon</th>
                                    <th>Cupo Maximo</th>
                                    <th>Cupo Minimo</th>
                                    <th colspan="3">

                                        <a class="btn btn-outline-warning btn-dark bnt-block w-50  rounded-pill fs-6" data-bs-toggle="modal" data-bs-target="#agregar-materia-modal" class="btn btn-block">
                                            <i class="far fa-plus-square"></i> Agregar Materia
                                        </a>

                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="materia" items="${listaMateria}">
                                    <tr>
                                        <td>${materia.idMateria}</td>
                                        <td>${materia.nombreMateria}</td>
                                        <td>${materia.cicloEscolar}</td>
                                        <td>${materia.horarioInicio}</td>
                                        <td>${materia.horarioFinal}</td>
                                        <td>${materia.catedratico}</td>
                                        <td>${materia.salon}</td>
                                        <td>${materia.cupoMaximo}</td>
                                        <td>${materia.cupoMinimo}</td>
                                        <td>
                                            <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/ServletMateria?accion=eliminar&idMateria=${materia.idMateria}">
                                                <i class="far fa-trash-alt"></i></a>
                                        </td>
                                        <td>
                                            <a class="btn btn-outline-warning" href="${pageContext.request.contextPath}/ServletMateria?accion=editar&idMateria=${materia.idMateria}">
                                                <i class="far fa-edit"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div id="body-kinal" class="col-12 border-primary col-mb-3">
                <div class="row">
                    <div class="card text-center bg-dark text-light">
                        <div class="card-body">
                            <div class="row">
                                <h3>Cantidad de Materias:</h3>
                                <h4 class="display-4">
                                    <a>
                                        <i class="fas fa-book"></i>
                                        ${cantmaterias}</a>
                                </h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>


        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>

    </body>
</html>
