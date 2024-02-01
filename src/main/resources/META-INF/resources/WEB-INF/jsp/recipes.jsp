<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>

<head>
    <title > Recipe page</title>
    <link href="/webjars/bootstrap/5.1.3/css/bootstrap.css" rel="stylesheet">
</head>


<body>

<%@include file="common/navigation.jspf" %>
<link class="container">
    <h1>Your Recipes</h1>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Added by</th>
            <th>Added:</th>
            <th></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${recipes}" var="recipe">
            <tr>
                <td>${recipe.id}</td>
                <td>${recipe.recipeName}</td>
                <td>${recipe.description}</td>
                <td>${recipe.addedByUser}</td>
                <td>${recipe.dateAdded}</td>
                <td> <a href="delete-recipe?id=${recipe.id}" class="btn btn-warning" >Delete</a> </td>
                <td> <a href="update-recipe?id=${recipe.id}" class="btn btn-success" >Update</a> </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

<a href="/add-recipe" class="btn btn-success">Add recipe</a>

</div>

<script src="/webjars/bootstrap/5.1.3/js/bootstrap.js"></script>
<script src="/webjars/jquery/3.6.0/jquery.js"></script>
</body>


</html>
