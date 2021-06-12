<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELECIONES UFPS</title>
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style2.css">
</head>
<body>

	<header class="header">
        <a href="index.jsp">
            <img class="header__logo" src="img/logo.png" alt="LogoTipo">
        </a>
    </header>
    
    <nav class="navegacion">
        <a class="navegacion__enlace navegacion__enlace--activo" href="index.jsp" style="text-decoration: none">Inicio</a>
        <a class="navegacion__enlace navegacion__enlace--activo" href="admin.jsp" style="text-decoration: none">Administrativo</a>
        <a class="navegacion__enlace navegacion__enlace--activo" href="#" style="text-decoration: none">Ayuda</a>
    </nav>

	<br>
	<div class="container">
		<div class="row">			
			<div class="col">
				<div class="opcion">
					<a href="CandidatoServlet?action=list" style="text-decoration: none" ><p class="op_nombre">Registro de Candidatos</p></a>
				</div>
				<br>
				<div class="opcion">
					<a href="#" style="text-decoration: none" ><p class="op_nombre">Registro de Votantes</p></a>
				</div>
				<br>
				<div class="opcion">
					<a href="#" style="text-decoration: none" ><p class="op_nombre">Registro de Elecciones</p></a> 
				</div>
				<br>
				<div class="opcion">
					<a href="#" style="text-decoration: none" ><p class="op_nombre">Votos Registrados</p></a>
				</div>
			</div>
		</div>
	</div>
	<br>
	<footer class="footer">
        <p class="footer__texto">Elecciones UFPS 2021 - 2025</p>
    </footer>
</body>
</html>