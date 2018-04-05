<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Alterar Produto</title>
</head>
<body>
	<form:form action="/estoque/produtos/alterar.html" method="post" modelAttribute="produto">
		<form:hidden path="id"/><br/>
		Descricao: <form:input path="descricao"/> <form:errors path="descricao"/><br/>
		Quantidade: <form:input path="quantidade"/> <form:errors path="quantidade"/><br/>
		<input type="submit" value="Alterar">
	</form:form>
</body>
</html>
