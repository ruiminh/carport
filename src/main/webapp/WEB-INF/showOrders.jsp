<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        Kunde ordre
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="d-flex flex-row mt-5">
            <div class="margintop ">
                    <div class="d-flex flex-column infobox">
                        <p>Medarbejderoplysninger</p>
                        <p class="mb-0">Medarbejdernr:${user.id} </p>
                        <p class="mb-0">Personalemail: ${user.email}</p>
                    </div>

            </div>




        <table class="table table-striped">
            <form name="showOrders" action="${pageContext.request.contextPath}/fc/showOrder"  method="POST">
            <thead><th>Bruger id</th><th>Bruger email</th><th>Ordre id</th><th>pris</th><th></th></thead>

                <c:forEach var="orderItem"  items="${applicationScope.userOrderList}">

                <tr>
                    <td>${orderItem.id}</td>
                    <td>${orderItem.email}</td>
                    <td>${orderItem.idOrder}</td>
                    <td>${orderItem.price}</td>
                    <td><button class="btn btn-outline-danger btn-sm" type="submit" name="edit" value="${orderItem.idOrder}"  >
                        Rediger</button>

                        <label>
                        <input type="hidden" name="id" value="${orderItem.id}" />
                        </label>
                        <label>
                            <input type="hidden" name="email" value="${orderItem.email}" />
                        </label>
                        <label>
                            <input type="hidden" name="idOrder" value="${orderItem.idOrder}" />
                        </label>
                        <label>
                            <input type="hidden" name="price" value="${orderItem.price}" />
                        </label>

                    <tr/>
                    </td>

            </c:forEach>





            </form>

        </table>










    </jsp:body>
</t:genericpage>