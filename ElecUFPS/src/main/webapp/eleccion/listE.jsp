<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- JSTL PREFIJO C -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
        <a class="navegacion__enlace navegacion__enlace--activo" href="<%=request.getContextPath()%>/EleccionesServlet?action=list" style="text-decoration: none">Elecciones</a>
    </nav>
    
    <br>
	
	<div class="row">
		<div class="container">
		<br>
			<h2 class="text-center"><strong>Elecciones Vigentes </strong></h2>
			<hr>
			
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/EleccionesServlet?action=new" class="btn boton" >Nueva Elección</a>
			</div>
			
			<br>
			
			<table class="table table-bordered">
				<thead>
					<tr>				
						<th>Id</th>	
						<th>Nombre</th>
						<th>Fecha Inicio</th>
						<th>Fecha Fin </th>
						<th>Cargo </th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="eleccion" items="${listElecciones}">
						<tr>
							<td><c:out value="${eleccion.id}" /></td>
							<td><c:out value="${eleccion.nombre}" /></td>
							<td><c:out value="${eleccion.fechainicio}" /></td>
							<td><c:out value="${eleccion.fechafin}" /></td>
							<td><c:out value="${eleccion.cargo}" /></td>
							<td>
								<a href="<%=request.getContextPath()%>/EleccionesServlet?action=edit&id=${eleccion.id}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="EleccionesServlet?action=delete&id=${eleccion.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>