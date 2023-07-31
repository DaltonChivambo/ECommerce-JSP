<%@ page import="java.util.ArrayList" %>
<%@ page import="org.shopping.connection.ConnectionDB" %>
<%@ page import="org.shopping.model.*" %>
<%@ page import="org.shopping.dao.ProductDao" %>


<% User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }

    ProductDao productDao = new ProductDao(ConnectionDB.getConnection());
    ArrayList
            <Product> products = productDao.getAllProducts();

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to Shopping Cart!</title>
    <%@ include file="includes/head.jsp" %>
</head>
<body>
<%@ include file="includes/navbar.jsp" %>
<div class="container">
    <div class="card-header my-3">All Products</div>
    <div class="row">
        <%
            if (!products.isEmpty()) {
                for (Product p : products) {%>
        <div class="col-md-3 my-3">
            <div class="card w-100" style="width: 18rem;">
                <img src="product_images/<%= p.getImage() %>" class="card-img-top" alt="female shoes">
                <div class="card-body">
                    <h5 class="card-title"><%= p.getName() %>
                    </h5>
                    <h6 class="price"><%= p.getPrice() %> MZN</h6>
                    <h6 class="category">Category: <%= p.getCategory() %>
                    </h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a href="#" class="btn btn-dark">Add to Cart</a>
                        <a href="#" class="btn btn-primary">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>

    </div>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>