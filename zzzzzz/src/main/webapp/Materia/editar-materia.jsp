<%-- 
    Document   : editar-materia
    Created on : 09-nov-2021, 12:00:58
    Author     : Daniel Marroquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Source+Code+Pro:wght@200&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./assets/css/style.css"/>
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <!-- bootsrap -->
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <title>Editar Materias</title>
    </head>
    <body id="body-kinal">
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <header id="main-header" class="py-4 bg-dark text-info text-center">
            <div class="conteiner">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            <i class="fas fa-tools"></i>
                            Editar Materias
                        </h1>
                    </div>
                </div>
            </div>
        </header>
        <section id="actions" class="py-4 mb-4 bg-dark">
            <div class="conteiner">
                <div class="row">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/ServletMateria?accion=listar" class="btn btn-outline-light"><i class="fas fa-angle-left"></i>     Regresar a Materias</a>
                    </div>
                </div>
            </div>
        </section>
        <main class="bg-dark">
            <div class="conteiner">
                <div class="row">
                    <div class="col-12">
                        <div class="card bg-dark">
                            <div class="card-body">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletMateria">
                                    <div class="form-floating mb-3">
                                        <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre de la Materia" value="${materia.nombreMateria}">
                                        <label for="nombre" class="form-label">Nombre de la Materia</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="date" id="ciclo" name="ciclo" class="form-control" placeholder="Ciclo Escolar" value="${materia.cicloEscolar}">
                                        <label for="ciclo" class="form-label">Ciclo Escolar</label>
                                    </div>   
                                    <div class="form-floating mb-3">
                                        <input type="time" id="horarioInicio" name="horarioInicio" class="form-control" placeholder="Horario Inicio" value="${materia.horarioInicio}">
                                        <label for="horarioInicio" class="form-label">Horario Inicio</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="time" id="horarioFinal" name="horarioFinal" class="form-control" placeholder="Horario Final" value="${materia.horarioFinal}">
                                        <label for="horarioFinal" class="form-label">Horario Final</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" id="catedratico" name="catedratico" class="form-control" placeholder="Catedratico" value="${materia.catedratico}">
                                        <label for="catedratico" class="form-label">Catedratico</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" id="salon" name="salon" class="form-control" placeholder="Salon" value="${materia.salon}">
                                        <label for="salon" class="form-label">Salon</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="number" id="cupomax" name="cupomax" class="form-control" placeholder="Cupo Maximo" value="${materia.cupoMaximo}">
                                        <label for="cupomax" class="form-label">Cupo Maximo</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="number" id="cupomin" name="cupomin" class="form-control" placeholder="Cupo Minimo" value="${materia.cupoMinimo}">
                                        <label for="cupomin" class="form-label">Cupo Minimo</label>
                                    </div>


                                    <input type="hidden" name="accion" value="actualizar">

                                    <div class="modal-footer bg-dark">
                                        <button type="button" class="btn btn-outline-warning" data-bs-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-outline-light">Actualizar</button>
                                        <input type="hidden" name="idMateria" value="${materia.idMateria}">
                                        <input type="hidden" name="accion" value="actualizar">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script src="./assets/js/jquery-3.6.0.js"></script> 
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
