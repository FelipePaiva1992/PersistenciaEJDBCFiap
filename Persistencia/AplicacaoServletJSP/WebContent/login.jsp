<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina Index</title>
<style type="text/css">
p {
	color: red;
}
</style>
</head>
<body>
	<h1>Validação de usuários</h1>
	<form action="valida" method="post" class="form">
		<label for="nome">Usuário</label>
		<br>
		<input type="text" name="nome" id="nome" size="20">
		<br> <br>
		<label for="senha">Senha</label>
		<br>
		<input type="password" name="senha" id="senha" size="20">
		<br> <br>
		<input type="submit" value="Validar">
		<br><br><br>
		${msgValidacao}
	</form>
</body>
</html>