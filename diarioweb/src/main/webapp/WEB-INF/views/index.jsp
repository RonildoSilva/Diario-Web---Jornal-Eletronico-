<%@page import="ufc.web.diario.models.TipoUsuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="pt-br">
<head>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.3/css/normalize.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.3/css/foundation.min.css">
<link
	href='http://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css'
	rel='stylesheet' type='text/css'>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

<title>Diário WEB</title>
</head>
<body>

	<%@ include file="topo.jsp"%>

	<div class="row">
		<div class="large-12 columns">
			<!--  12 columns -->
			<ul class="example-orbit" data-orbit>
				<!-- Slider -->
				<c:forEach var="noticia" items="${noticiasRecentes}">
					<li><img
						src="http://placehold.it/1000x400&amp;text=[%20img%201%20]">
						<a href="noticias/exibir?id=${noticia.noticiaId}">${noticia.titulo}</a>
					</li>

				</c:forEach>
			</ul>

			<hr />

			<h2>Notícias</h2>

			<a href="/diarioweb/noticias/form">Cadastrar Notícia</a> <br> <a
				href="/diarioweb/noticias/listar">Listar Notícias</a> <br>

			<h2>Secoes</h2>
			<a href="/diarioweb/secoes/form">Cadastrar Secão</a> <br>
			
			<h2>User</h2>
			<a href="/diarioweb/usuarios/login">Login</a> <br>
			
			<%    pageContext.setAttribute("monEnum", TipoUsuario.values()); %>
			<c:forEach var="entry" items="${monEnum}">
			    <option>${entry.nomeTipoUsuario}</option>
			</c:forEach>

		</div>
		<!--  12 columns -->
	</div>
	<!-- ROWS -->

	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.3/js/foundation.min.js"></script>
	<script>
		$(document).foundation();
	</script>

</body>
</html>