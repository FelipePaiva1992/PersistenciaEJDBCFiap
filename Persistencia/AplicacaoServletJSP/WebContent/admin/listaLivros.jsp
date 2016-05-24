<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de livros</title>
</head>
<body>
	<a href="menu.jsp">Voltar</a>
	<br>
	<br>
	<table border="1" cellpadding="10">
		<tr style="text-align: center;">
			<td>Codigo</td>
			<td>Nome</td>
			<td colspan="2">Opções</td>
		</tr>

		<c:forEach var="item" items="${livros}">
			<tr>
				<td style="text-align: center;"><c:out value="${item.codigo}" /></td>
				<td><c:out value="${item.titulo}" /></td>
				<td><a href="consultarlivro?codigo=<c:out value="${item.codigo}"/>">detalhes</a></td>
				<td><a href="gerapdf?cod=<c:out value="${item.codigo}"/>" target="_blank">sinopse</a></td>
			</tr>
		</c:forEach>
	</table>
	${msgLivro}
</body>
</html>