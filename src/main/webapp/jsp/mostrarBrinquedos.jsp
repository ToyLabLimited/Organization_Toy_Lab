<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.toylab.model.Toy"%>
<!DOCTYPE html>
<html>
<head>
<title>TOYLAB - Lista de brinquedos</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/iconToyLab.png" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
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
    <!-- Topbar End -->

                    
    <div class="container-fluid pt-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">Lista de brinquedos</span></h2>                
		</div>
		<div class="row px-xl-5 pb-3">
		<%
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				List<Toy> lista = new ArrayList<>();
				lista = (ArrayList) request.getAttribute("toyList");
			
			for (Toy a : lista) {
		%>
		
	  <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
            <div class="card product-item border-0 mb-4">
                <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                    <img class="img-fluid w-100" src="<%= a.getImage() %>" alt="<%= a.getName() %>">
                </div>
                <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                    <h6 class="text-truncate mb-3"><%= a.getName() %></h6>
                    <div class="d-flex justify-content-center">
                        <h6>R$<%= a.getValue() %></h6>
                    </div>
                </div>
                <div class="card-footer d-flex justify-content-between bg-light border">
                    <a href="ToyServlet?cmd=con&id=<%= a.getCode() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>Ver detalhes</a>
                    <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Carrinho</a>
                </div>
            </div>
        </div>
    
<%
}
%>
</div>
</div>
</div>
		

</body>
</html>