<%@ page import="org.shopping.connection.ConnectionDB" %>
<%@ page import="org.shopping.model.*" %>


<% User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
%>

<html lang="en">
<head>
    <title>Shopping Cart Cart</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<h1>Hello, world!</h1>

<%@include file="includes/footer.jsp" %>
</body>
</html>