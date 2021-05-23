<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>

            <form action="${pageContext.request.contextPath}/fc/showOrders">

                <input type="hidden" name="idOrder" value="${requestScope.orderitem.idOrder}">

                <table>

                        <thead> <th>Pris</th></thead>

                    <tr>

                        <td>
                            <input type="text" value="${requestScope.orderitem.price}"/>
                        <td><button type="submit" name="update">Rediger</button>
                        </td>


                    </tr>

                </table>


            </form>






        </div>

    </jsp:body>
</t:genericpage>