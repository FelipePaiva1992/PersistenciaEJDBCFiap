<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Livros</title>
</head>
<body>
	<a href="menu.jsp">Voltar</a>
	<br>
	<br>
	<form action="cadlivros" method="post" class="form" enctype="multipart/form-data">
		<label for="codigo">Codigo</label>
		<br>
		<input type="number" name="codigo" id="codigo" size="10">
		<br> <br>
		<label for="titulo">Titulo</label>
		<br>
		<input type="text" name="titulo" id="titulo" size="30">
		<br> <br>
		<label for="autor">Autor</label>
		<br>
		<input type="text" name="autor" id="autor" size="30">
		<br> <br>
		<label for="data">Data Publicação</label>
		<br>
		<input type="date" name="data" id="data">
		<br> <br>
		<label for="preco">Preço</label>
		<br>
		<input type="number" name="preco" id="preco">
		<br> <br>
		<label for="foto">Foto</label>
		<br>
		<input type="file" name="foto" id="foto">
		<br> <br>
		<input type="submit" value="Cadastrar">
		<br> <br> <br> 
		${msgLivros}
	</form>
</body>
</html>