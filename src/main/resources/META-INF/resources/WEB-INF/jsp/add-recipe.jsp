<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf" %>

<div class="container">

    <h2>Add recipe</h2>
    <form:form method="post" modelAttribute="recipe">

        <fieldset class="mb-3">
            <form:label path="recipeName">Recipe name</form:label>
            <form:input type="text" path="recipeName" required="required" />
            <form:errors path="recipeName" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required" />
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="addedByUser">Added by</form:label>
            <form:input type="text" path="addedByUser" required="required" />
            <form:errors path="addedByUser" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="dateAdded">Date</form:label>
            <form:input type="text" path="dateAdded" required="required" autocomplete="off" />
            <form:errors path="dateAdded" cssClass="text-warning"/>
        </fieldset>


        <form:input type="hidden" path="id"/>
        <input type="submit">
    </form:form>
    ${ErrorMsg}

</div>
<%@include file="common/footer.jspf"%>
<script type="text/javascript">
    $('#dateAdded').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>