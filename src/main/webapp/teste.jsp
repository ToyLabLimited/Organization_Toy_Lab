<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Brinquedos</title>
</head>
<body>
    <h1>Brinquedos por Categoria</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Categoria</th>
        </tr>
        <c:forEach items="${brinquedo}" var="brinquedo">
            <tr>
                <td>${brinquedo.id}</td>
                <td>${brinquedo.nome}</td>
                <td>${brinquedo.categoria}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
