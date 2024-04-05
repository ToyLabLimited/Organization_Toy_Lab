<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar brinquedo</title>
</head>
<body>
	<h2>Atualizar brinquedo</h2>
	<jsp:useBean id="toy" scope="session"
		class="br.com.toylab.model.Toy" />
	<%
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	%>
	<form action="ToyServlet?cmd=atualizar" method="post">
		<table border="1">
		
			<tr>
				<td>Codigo:</td>
				<td><input type="text" size="60" name="codigo_brinquedo"
					value="<%=toy.getCode()%>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" size="60" name="nome"
					value="<%=toy.getName()%>" /></td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td><input type="text" size="60" name="descricao"
					value="<%=toy.getDescription()%>" /></td>
			</tr>
			<tr>
				<td>Valor:</td>
				<td><input type="text" size="60" name="valor"
					value="<%=toy.getValue()%>"  /></td>
			</tr>
				<tr>
				<td>Detalhes:</td>
				<td><input type="text" size="60" name="detalhes"
					value="<%=toy.getDetails()%>"  /></td>
			</tr>
			<tr>
			<td> Categoria:</td>
				<td><input type="text" size="60" name="categoria"
					value="<%=toy.getCategory()%>"  /></td>			
			</tr>
				<tr>
			<td> Marca:</td>
				<td><input type="text" size="60" name="marca"
				value="<%=toy.getBrand()%>"/></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit"
					value="Confirmar Atualização" /></th>
			</tr>
			<tr>
				<th colspan="2"><a href="index.html">Página Principal</a></th>
			</tr>
		</table>
	</form>
</body>
</html>