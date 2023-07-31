<%@ page import="org.shopping.connection.ConnectionDB" %>
<%@ page import="org.shopping.model.*" %>


<% User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shopping Cart Orders</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>


<%@include file="includes/footer.jsp" %>
</body>
</html>