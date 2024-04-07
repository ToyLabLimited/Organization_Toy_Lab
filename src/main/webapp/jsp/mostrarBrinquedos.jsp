<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.toylab.model.Toy"%>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Brinquedos</title>
</head>
<body>
	<table width="60%" border="1">
		<tr>
			<th colspan="7"><h1>Lista de brinquedos </h1></th>
			<a href="html/incluir.html"><img src="image/adicionar-usuario.png" width="30px"></a>
		</tr>
		<tr>
			<th>Codigo</th>
			<th>Name</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Detalhes</th>
			<th>Categoria</th>
			<th>Marca</th>
		</tr>
		<%
				List<Toy> lista = new ArrayList<>();
				lista = (ArrayList) request.getAttribute("toyList");
			
			for (Toy a : lista) {
		%>
		<tr>
			<td><%=a.getCode()%></td>
			<td><%=a.getName()%></td>
			<td><%=a.getDescription()%></td>
			<td><%=a.getValue()%></td>
			<td><%=a.getDetails()%></td>
			<td><%=a.getCategory()%></td>
			<td><%=a.getBrand()%></td>
			
			<td>
				<a href="ToyServlet?cmd=exc&codigo_brinquedo=<%= a.getCode() %>"><img src="image/icons8-apagar-66.png" width="30px"></a>
		 	    <a href="ToyServlet?cmd=atu&codigo_brinquedo=<%= a.getCode() %>"><img src="image/icons8-editar-50.png" width="30px"></a>
		    </td>
		</tr>
		<%
		}
		
		%>
		<tr>
			<th colspan="7"><a href="index.html">P�gina Principal</a></th>
		</tr>
	</table>
</body>
</html>