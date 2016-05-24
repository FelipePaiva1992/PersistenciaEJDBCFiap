<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
img {
	max-height: 300px;
}
</style>
</head>
<body>
	<a href="listalivros">Voltar</a>
	<br>
	<br>
	<h1>Detalhes do livro</h1>
	<ul>
		<li>Codigo: ${livro.codigo}</li>
		<li>Titulo: ${livro.titulo}</li>
		<li>Autor: ${livro.autor}</li>
	</ul>
	<img src="imagem?id=${livro.codigo}" />
</body>
</html>