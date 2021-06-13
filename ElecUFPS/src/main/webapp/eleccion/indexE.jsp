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
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${eleccion != null}">
					<form action="EleccionesServlet?action=update&id=${eleccion.id}" method="post">
				</c:if>

				<c:if test="${eleccion == null}">
					<form action="EleccionesServlet?action=insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${eleccion != null}"> Editar Elección </c:if>

						<c:if test="${eleccion == null}"> Insertar Elección  </c:if>
					</h2>
				</caption>

				<c:if test="${eleccion != null}">
					<input type="hidden" name="id" value="<c:out value='${eleccion.id}' />" />
				</c:if>

				
				<fieldset class="form-group">
					<label>Nombre de la Elección</label> <input type="text"
						value="<c:out value='${eleccion.nombre}' />" class="form-control"
						name="nombre" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fecha de Inicio</label> <input type="date"
						value="<c:out value='${eleccion.fechainicio}' />" class="form-control"
						name="fechainicio" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fecha Fin</label> <input type="date"
						value="<c:out value='${eleccion.fechafin}' />" class="form-control"
						name="fechafin" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Cargo</label> <input type="text"
						value="<c:out value='${eleccion.cargo}' />" class="form-control"
						name="cargo" required="required">
				</fieldset>

				<br>
				<div class="d-grid gap-2 col-3 mx-auto">
					<button type="submit" class="btn boton" >Guardar</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	
	<br>
	<footer class="footer">
        <p class="footer__texto">Elecciones UFPS 2021 - 2025</p>
    </footer>
</body>
</html>