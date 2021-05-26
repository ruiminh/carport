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

        <form name="login" action="${pageContext.request.contextPath}/fc/confirmcommand" method="POST">

        <h3>Du har valgt følgende carporte:</h3>

        <br/>

        <table class="table table-striped">

            <thead><th>carportId</th><th>navn</th>><th>pris</th><th></th></thead>
            <c:forEach var="product" varStatus="status" items="${sessionScope.basket.cartList}">

                <tr>
                    <td>${product.carportId}</td>
                    <td>${product.name}</td>

                    <td>${product.price}</td>

                    </td>

                <tr/>
            </c:forEach>
        </table>

        <p>Total pris:  ${sessionScope.basket.totalPrice} Kr</p>

        <br/>
        <br/>

        <div/>
        </form>
        <div><td><input class="btn btn-primary" type="submit" type="submit" value="Submit">

        <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/fc/standartcarport" >Køb mere</a>

    </jsp:body>

</t:genericpage>
