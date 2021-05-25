<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Design Page
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div style="margin-top: 5em;" class="container">

                <form name="Measures" action="${pageContext.request.contextPath}/fc/carportDesigned"  method="POST">

                        <%--@declare id="withshed"--%><label for="carportlength">Carport Længde</label>
                        <select class="form-select form-select-sm mb-3"  aria-label="carportlength" name="carportlength" id="carportlength">
                            <option selected>Vælg længde</option>
                            <c:forEach var="carportlength" items="${applicationScope.carportLengthList}">
                                <option value="${carportlength}">${carportlength}</option>
                            </c:forEach>
                        </select>
                        <label for="carportlength">Carport Bredde</label>

                        <select class="form-select form-select-sm mb-3"  aria-label="carportwidth" name="carportwidth" id="carportwidth">
                            <option selected>Vælg Bredde</option>
                            <c:forEach var="carportwidth" items="${applicationScope.carportWidthList}">
                                <option value="${carportwidth}">${carportwidth} </option>
                            </c:forEach>
                        </select>
                        <label for="rooftype">Tag</label>
                        <select class="form-select form-select-sm mb-3"  aria-label="rooftype" name="rooftype" id="rooftype">
                            <option selected>vælg tagplader</option>
                        </select>


                            <p>Med redskabsrum?</p>
                            <div class="form-check form=check-online">
                                <input class="form-check-input" type="radio" id="yes" name="withshed" value="1">
                                <label class="form-check-label" for="yes">Ja</label>
                            </div>
                            <div class="form-check form=check-online">
                                <input class="form-check-input" type="radio" id="no" name="withshed" value="0">
                                <label class="form-check-label" for="no">no</label><br>
                            </div>



                    <label for="shedlength">Skur Længde</label>
                    <select class="form-select form-select-sm mb-3"  aria-label="shedlength" name="shedlength" id="shedlength">
                        <option selected>Vælg længde</option>
                        <c:forEach var="shedlength" items="${applicationScope.shedLenghtList}">
                            <option value="${shedlength}">${shedlength}</option>
                        </c:forEach>
                    </select>

                    <label for="shedwidth">Skur bredde</label>
                    <select class="form-select form-select-sm mb-3"  aria-label="shedwidth" name="shedwidth" id="shedwidth">
                        <option selected>Vælg længde</option>
                        <c:forEach var="shedwidth" items="${applicationScope.shedWidthList}">
                            <option value="${shedwidth}">${shedwidth}</option>
                        </c:forEach>
                    </select>

                        <input class="btn btn-primary" type="submit" type="submit" value="Submit">
                </form>
        </div>
    </jsp:body>
</t:genericpage>
