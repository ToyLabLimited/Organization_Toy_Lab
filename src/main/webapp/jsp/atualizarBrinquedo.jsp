<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<title>Editar brinquedo</title>
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
                        <a href="catalogo.html" class="nav-item nav-link" style="padding: 20px;">Cat�logo</a>
                        <a href="login.html" class="nav-item nav-link active" style="padding: 20px;">Administra��o</a>
                        <a href="equipe.html" class="nav-item nav-link" style="padding: 20px;">Equipe</a>
                    </div>
                
                </div>
            </nav>
        
        </div>
    </div>
    
    
	<div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">Editar brinquedo</span></h2>
    </div>
    
	<jsp:useBean id="toy" scope="session"
		class="br.com.toylab.model.Toy" />
	<%
	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	%>
	
	<div class="container-fluid pt-5" >
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5" id="centralizar" style="text-align: center;">
            <form action="ToyServlet?cmd=atualizar" method="post" style="display: flex; flex-direction: column; justify-content: center" >
            	<table class="table table-bordered text-center mb-0" style="font-weight: bold;" >
	                   <tbody class="align-middle">
	                   		<tr>
	                            <td style="text-align: left;">C�digo</td>
					            <td> <input type="text" size="60" name="codigo_brinquedo"value="<%=toy.getCode()%>" readonly="readonly" style="width: 100%"/></td>
                        	</tr>
	                        <tr>
	                            <td style="text-align: left;">Nome</td>
					            <td><input type="text" size="60" name="nome"value="<%=toy.getName()%>" style="width: 100%"/></td>
                        	</tr>
	                        <tr>
	                            <td style="text-align: left;">Descri��o</td>
					            <td><input type="text" size="60" name="descricao"value="<%=toy.getDescription()%>" style="width: 100%"/></td>
                        	</tr>
	                         <tr>
	                            <td style="text-align: left;">Valor</td>
					            <td><input type="text" size="60" name="valor"value="<%=toy.getValue()%>"  style="width: 100%"/></td>
                        	</tr>   
	                        <tr>
	                            <td style="text-align: left;">Detalhes</td>
					            <td><input type="text" size="60" name="detalhes"value="<%=toy.getDetails()%>" style="width: 100%" /></td>
                        	</tr>
	                        <tr>
	                            <td style="text-align: left;">Categoria</td>
					            <td> <input type="text" size="60" name="categoria"value="<%=toy.getCategory()%>" style="width: 100%" /></td>
                        	</tr>    
	                        <tr>
	                            <td style="text-align: left;">Marca</td>
					            <td><input type="text" size="60" name="marca"value="<%=toy.getBrand()%>" style="width: 100%"/></td>
                        	</tr>  
	                        </tbody>
					</table>
					<input type="submit" value="Confirmar Atualiza��o" class="botaoincluir"/>
				</form>
            </div>
        </div>
    </div>
    
    
      <!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <img src="img/iconToyLab.png" alt="" style="width: 120px;">      
                </a> 
                <p><br>Explore a magia na ToyLab - onde a divers�o ganha vida! Encontre os melhores brinquedos para inspirar sorrisos e estimular a imagina��o. Junte-se a n�s para criar mem�rias inesquec�veis!</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>toylab@gmail.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+55 99 99999-9999</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Links r�pidos</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="login.html"><i class="fa fa-angle-right mr-2"></i>Administra��o</a>
                            <a class="text-dark mb-2" href="detail.html"><i class="fa fa-angle-right mr-2"></i>Termos</a>
                            <a class="text-dark mb-2" href="cart.html"><i class="fa fa-angle-right mr-2"></i>Avisos</a>
                            <a class="text-dark mb-2" href="equipe.html"><i class="fa fa-angle-right mr-2"></i>Equipe</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="row border-top border-light mx-xl-5 py-4">
            <div class="col-md-6 px-xl-0">
                <p class="mb-md-0 text-center text-md-right text-dark">
                    &copy; <a class="text-dark font-weight-semi-bold" href="#">TOYLAB</a>. Todos os direitos reservados. Designed
                    by
                    <a class="text-dark font-weight-semi-bold" href="https://htmlcodex.com">HTML Codex</a>
                </p>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>
</html>