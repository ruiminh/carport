<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Basket
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>


        <div>
        <h3>Bestillinger:</h3>

        <br/>

        <table class="table table-striped">

            <thead><th>customerId</th><th>navn</th>><th>pris</th><th></th></thead>
            <c:forEach var="product" varStatus="status" items="${sessionScope.basket.orderList}">

                <tr>
                    <td>${product.customerId}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>


                    <td>${product.price}</td>
                    <td><button class="btn btn-outline-danger btn-sm" type="submit" name="update" value="${status.index}">
                        ændre</button>

                    </td>
                <tr/>
            </c:forEach>
        </table>



        <br/>
        <br/>

        <div/>

        <div>

        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/fc/standartcarport" >Shop more</a>

    </jsp:body>

</t:genericpage>
