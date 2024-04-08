<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.toylab.model.Toy"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>TOYLAB - Área administrativa</title>
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

	<div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">Painel Administrativo</span></h2>
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
	                        <td class="align-middle"><%=a.getValue()%></td>
	                        <td class="align-middle">
	                        	<a href="ToyServlet?cmd=atu&codigo_brinquedo=<%= a.getCode() %> "class="btn btn-sm text-dark p-0"><i class="fas fa-edit text-primary mr-1"></i>Editar</a> -
	                            <a type="button" class=" excbtn" data-toggle="modal" data-target="#Modal" value=<%= a.getCode() %> href="ToyServlet?cmd=excluir&codigo_brinquedo=<%= a.getCode() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-trash text-danger mr-1"></i>Excluir</a>    
	                        </td>
	          			</tr>
	          			<%
							}
						%>
          			</tbody>
	          		<tr>
						<th colspan="7"><a href="incluir.html" style="color: green">+ REGISTRAR NOVO PRODUTO</a></th>
					</tr>
            	</table>
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
                <p><br>Explore a magia na ToyLab - onde a diversão ganha vida! Encontre os melhores brinquedos para inspirar sorrisos e estimular a imaginação. Junte-se a nós para criar memórias inesquecíveis!</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>toylab@gmail.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+55 99 99999-9999</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Links rápidos</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.html"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="login.html"><i class="fa fa-angle-right mr-2"></i>Administração</a>
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