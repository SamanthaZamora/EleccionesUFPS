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
        <a class="navegacion__enlace navegacion__enlace--activo" href="<%=request.getContextPath()%>/CandidatoServlet?action=list" style="text-decoration: none">Candidatos</a>
    </nav>

	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${candidato != null}">
					<form action="CandidatoServlet?action=update" method="post">
				</c:if>

				<c:if test="${candidato == null}">
					<form action="CandidatoServlet?action=insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${candidato != null}"> Editar Candidato </c:if>

						<c:if test="${candidato == null}"> Insertar Candidato  </c:if>
					</h2>
				</caption>

				<c:if test="${candidato != null}">
					<input type="hidden" name="id" value="<c:out value='${candidato.id}' />" />
				</c:if>

				
				<fieldset class="form-group">
					<label>Documento</label> <input type="text"
						value="<c:out value='${candidato.documento}' />" class="form-control"
						name="documento" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Nombre del Candidato</label> <input type="text"
						value="<c:out value='${candidato.nombre}' />" class="form-control"
						name="nombre" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Apellido del Candidato</label> <input type="text"
						value="<c:out value='${candidato.apellido}' />" class="form-control"
						name="apellido" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Número de Tarjeton</label> <input type="text"
						value="<c:out value='${candidato.numero}' />" class="form-control"
						name="numero" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Elección</label> <br> <select name="eleccion"
						class="rounded form-control">
						<option value="">Elecciones vigentes</option>
						<c:forEach var="eleccion" items="${listaEleccion}">
							<option value="${eleccion.id}">${eleccion.nombre}</option>
						</c:forEach>
					</select>
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