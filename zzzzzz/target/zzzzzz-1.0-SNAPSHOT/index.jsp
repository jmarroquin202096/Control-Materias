<%-- 
    Document   : index
    Created on : 09-nov-2021, 12:01:50
    Author     : Daniel Marroquin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Source+Code+Pro:wght@200&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./assets/css/style.css"/>
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <title>Control de Materias - Inicio</title>
    </head>
    <body id="body_Kinal">
        <!-- HEADERRRRRRRRRR -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <main>
            <section id = "contenido">
                <p class = "descripcion">
                    Kinal es un Centro Educativo privado, no lucrativo, dirigido a la formación técnica profesional de
                    jóvenes y adultos, de beneficio colectivo y asistencia social en favor de los sectores más necesitados
                    de la comunidad.
                </p>

                <img id="kinal_img_principal" src="./assets/images/KINAL-1.jpg">

                <p class = "descripcion">
                    Nuestro valor fundamental es enseñar a realizar el trabajo bien hecho, que sea la base de la
                    superación de alumnos y el medio para servir a los demás.
                </p>

                <br>
            </section>
        </main>


        <!-- FOOTERRRRRRRRRR -->
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script src="./assets/js/jquery-3.6.0.js"></script> 
        <script src="./assets/js/bootstrap.bundle.js"></script>

    </body>
</html>
