<%@ page import="org.shopping.connection.ConnectionDB"%>

<html lang="en">
<head>
    <title>Welcome to Shopping Cart!</title>
    <%@ include file="includes/head.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<% out.print(ConnectionDB.getConnection()); %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>