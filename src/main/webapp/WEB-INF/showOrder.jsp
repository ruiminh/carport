<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>



            <form action="${pageContext.request.contextPath}/fc/showOrders" method="post">

                <input type="hidden" class="form-control" name="idOrder" id="idOrder" value="${requestScope.orderItem.idOrder}">
                <input type="hidden" class="form-control" name="id" id="id" value="${requestScope.orderItem.id}">
                <table>

                        <thead> <th>Pris</th></thead>

                    <tr>

                        <td>

                            <input type="text" class="form-control"  name="price" id="price" value="${requestScope.orderItem.price}"/>
                        <td><button type="submit" name="update" >Rediger</button>
                        </td>


                    </tr>

                </table>

            </form>









    </jsp:body>
</t:genericpage>