<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.toylab.model.Toy" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Brinquedos</title>
    <!-- Importe seus arquivos CSS e JS aqui -->
</head>
<body>
    <div class="container">
        <div class="row px-xl-5 pb-3">
            <% 
            List<Toy> toyList = (List<Toy>) request.getAttribute("toyList");
            if (toyList != null && !toyList.isEmpty()) {
                for (Toy toy : toyList) {
            %>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="card product-item border-0 mb-4">
                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                        <img class="img-fluid w-100" src="<%=toy.getImage()%>" alt="">
                    </div>
                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                        <h6 class="text-truncate mb-3"><%=toy.getName()%></h6>
                        <div class="d-flex justify-content-center">
                            <h6>R$<%=toy.getValue()%></h6>
                        </div>
                    </div>
                    <div class="card-footer d-flex justify-content-between bg-light border">
                        <a href="detail.html" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>Ver detalhes</a>
                        <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Carrinho</a>
                    </div>
                </div>
            </div>
            <%
                }
            } else {
            %>
            <div class="col-12">
                <p>Nenhum brinquedo encontrado.</p>
            </div>
            <% } %>
        </div>
    </div>
</body>
</html>