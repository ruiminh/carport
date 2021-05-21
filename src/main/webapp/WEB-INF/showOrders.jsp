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
                        <p class="mb-0">Medarbejdernr: ${user.id}</p>
                        <p class="mb-0">Personalemail: ${user.email}</p>
                    </div>

            </div>








    </jsp:body>
</t:genericpage>