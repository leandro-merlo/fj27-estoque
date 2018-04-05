<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Cadastro de Produtos</title>
</head>
<body>

	<form:form method="post" action="/estoque/produtos/salvar" modelAttribute="produto" >
		Descricao: <form:input path="descricao"/> <form:errors path="descricao"/><br/>
		Quantidade: <form:input path="quantidade"/> <form:errors path="quantidade"/><br/>
		<input type="submit" value="Salvar">
	</form:form>

</body>
</html>
