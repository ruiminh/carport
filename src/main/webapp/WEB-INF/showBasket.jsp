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
        <h3>Du har valgt følgende cupcakes:</h3>

        <br/>

        <table class="table table-striped">

            <thead><th>Bund</th><th>Topping</th><th>Antal</th><th>pris</th></thead>
            <c:forEach var="order" items="${sessionScope.orderList}">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.carport.description}</td>
                    <td>${order.carport.lenght}</td>
                    <td>${order.carport.width}</td>
                    <td>${order.carport.price}</td>
                    <td>${order.carport.shedLength}</td>
                    <td>${order.carport.shedwidth}</td>
                <tr/>
            </c:forEach>





        </table>

        <p>Test</p>
        <p>Total pris:  ${sessionScope.shoppingcart.totalPrice()} Kr</p>

        <br/>
        <br/>
        <div/>






    </jsp:body>

</t:genericpage>
