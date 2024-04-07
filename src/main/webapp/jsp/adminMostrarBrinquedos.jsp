<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.toylab.model.Toy"%>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Brinquedos</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <link href="img/iconToyLab.png" rel="icon">


    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 


    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

   
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <link href="css/style.css" rel="stylesheet">

</head>
<body>
<body>
     <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="index.html" class="text-decoration-none">
                    <img src="img/iconToyLab.png" alt="" style="width: 120px;">
                </a>
            </div>
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between" style="margin-left: 180px;" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0">
                        <a href="index.html" class="nav-item nav-link" style="padding: 20px;">Home</a>
                        <a href="catalogo.html" class="nav-item nav-link active" style="padding: 20px;">Catálogo</a>
                        <a href="login.html" class="nav-item nav-link" style="padding: 20px;">Administração</a>
                        <a href="equipe.html" class="nav-item nav-link" style="padding: 20px;">Equipe</a>
                    </div>
                
                </div>
            </nav>
        
        </div>
    </div>




 
                    
    <div class="container-fluid pt-5" id="">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5" id="centralizar" style="text-align: center;">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Nome</th>
                            <th>Categoria</th>
                            <th>Valor</th>
                            <th>Controles</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
		<%
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				List<Toy> lista = new ArrayList<>();
				lista = (ArrayList) request.getAttribute("toyList");
			
			for (Toy a : lista) {
		%>
		
	      <tr>
                            <td class="align-middle"><img src="<%=a.getImage()%>" alt="" style="width: 50px;"><%=a.getName()%> </td>
                            <td class="align-middle"><%=a.getCategory()%></td>
                            </td>
                            <td class="align-middle"><%=a.getValue()%></td>
                            <td class="align-middle">
                            <a href="ToyServlet?cmd=atu&codigo_brinquedo=<%= a.getCode() %> "class="btn btn-sm text-dark p-0"><i class="fas fa-edit text-primary mr-1"></i>Editar</a> -
                            <a type="button" class=" excbtn" data-toggle="modal" data-target="#Modal" value=<%= a.getCode() %> href="ToyServlet?cmd=excluir&codigo_brinquedo=<%= a.getCode() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-trash text-danger mr-1"></i>Excluir</a>  
                            </td>
                        </tr>
           
                                
<%
}
%>

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