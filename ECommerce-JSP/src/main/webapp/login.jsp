<%@ page import="org.shopping.model.*" %>

<% User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shopping Cart Login</title>
    <%@include file="includes/head.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center"> User Login</div>
        <div class="card-body">
            <form action="user-login" method="post">
                <div class="form-group">
                    <label>Email Address</label>
                    <input type="email" class="form-control" name="login-email" placeholder="Enter your email" required>
                </div>
                <div class="form-group my-3">
                    <label>Password</label>
                    <input type="password" class="form-control" name="login-password" placeholder="**********" required>
                </div>
                <div class="text_center my-3">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>