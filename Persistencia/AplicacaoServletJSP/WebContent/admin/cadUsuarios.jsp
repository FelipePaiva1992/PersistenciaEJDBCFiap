<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Usuário</title>
</head>
<body>
	<a href="menu.jsp">Voltar</a>
	<br>
	<br>
	<form action="cadusuarios" method="post" class="form">
		<label for="nome">Usuário</label>
		<br>
		<input type="text" name="nome" id="nome" size="20">
		<br> <br>
		<label for="senha">Senha</label>
		<br>
		<input type="password" name="senha" id="senha" size="20">
		<br>  <br>
		<label for="nivel">Nivel</label>
		<br>
		<select id="nivel" name="nivel">
			<option value="1" selected>Administrador</option>
			<option value="2">Cliente</option>
		</select>
		<br><br>
		<input type="submit" value="Cadastrar">
		<br><br><br>
		${msgCadastro}
	</form>
</body>
</html>