<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Medarbejderside
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Medarbejderside du har følgende valgmuligheder:

        <p><a href="${pageContext.request.contextPath}/fc/showOrders">Se bestillinger</a></p>

    </jsp:body>
</t:genericpage>
