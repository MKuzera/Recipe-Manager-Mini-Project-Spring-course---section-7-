<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>

<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title > add recipe</title>
</head>


<body>
<div class="container">

    <h2>Add recipe</h2>
    <form:form method="post" modelAttribute="recipe">
        Recipe name: <form:input type="text" path="recipeName" required="required" />
        Description: <form:input type="text" path="description" required="required" />
        Added by: <form:input type="text" path="addedByUser" required="required" />
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="dateAdded"/>
        <input type="submit">
    </form:form>
    ${ErrorMsg}

</div>
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.js"></script>
<script src="/webjars/jquery/3.6.0/jquery.js"></script>
</body>


</html>