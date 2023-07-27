<%@ page import="org.shopping.connection.ConnectionDB"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to Shopping Cart!</title>
    <%@ include file="includes/head.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<%
// Crie uma instância da classe ConnectionDB
out.print(ConnectionDB.getConnection());
%>
<%@ include file="includes/footer.jsp" %>
</body>
</html>