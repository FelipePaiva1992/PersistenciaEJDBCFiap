<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="menu.jsp">Voltar</a>
	<br>
	<br>
	<c:forEach var="item" items="${livros}">
	   <c:out value="${item.titulo}"/><a href="consultarlivro?codigo=<c:out value="${item.codigo}"/>">(ver detalhes)</a><br>
	</c:forEach>
	${msgLivro}
</body>
</html>