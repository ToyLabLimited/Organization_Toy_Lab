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
   <link href="css/style.css" rel="stylesheet">
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
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
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
				<a type="button" class="btn btn-primary excbtn" data-toggle="modal" data-target="#Modal" href="ToyServlet?cmd=excluir&codigo_brinquedo=<%= a.getCode() %>"><img src="image/icons8-apagar-66.png" width="30px"></a>
		 	    <a href="ToyServlet?cmd=atu&codigo_brinquedo=<%= a.getCode() %>"><img src="image/icons8-editar-50.png" width="30px"></a>
		    </td>
		</tr>
		<%
		}
		
		%>
		<tr>
			<th colspan="7"><a href="index.html">Página Principal</a></th>
		</tr>
	</table>
	<div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Tela de Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Você tem certeza que deseja deletar esse registro?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
        <a type="button" class="btn btn-primary modal-exc">Excluir</a>
      </div>
    </div>
  </div>
</div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="./js/modal.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
</body>
</html>