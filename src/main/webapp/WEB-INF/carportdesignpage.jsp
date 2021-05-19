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

                <form name="Measures" action="${pageContext.request.contextPath}/fc/showBasket"  method="POST">

                        <label for="carportlength">Carport Længde</label>
                        <select class="form-select form-select-sm mb-3"  aria-label="carportlength" name="carportlength" id="carportlength">
                            <option selected>Vælg længde</option>
                            <c:forEach var="carportlength" items="${applicationScope.carportLengthList}">
                                <option value="${carportlength}">${carportlength}</option>
                            </c:forEach>
                        </select>
                        <label for="carportlength">Carport Bredde</label>

                        <select class="form-select form-select-sm mb-3"  aria-label="carportlength" name="carportwidth" id="carportwidth">
                            <option selected>Vælg Bredde</option>
                            <c:forEach var="carportwidth" items="${applicationScope.carportWidthList}">
                                <option value="${carportwidth}">${carportwidth} </option>
                            </c:forEach>
                        </select>
                        <label for="rooftype">Tag</label>
                        <select class="form-select form-select-sm mb-3"  aria-label="rooftype" name="rooftype" id="rooftype">
                            <option selected>vælg togpladser</option>
                        </select>

                    <label for="carportlength">Carport Længde</label>
                    <select class="form-select form-select-sm mb-3"  aria-label="shedlength" name="shedlength" id="shedlength">
                        <option selected>Vælg længde</option>
                        <c:forEach var="shedlength" items="${applicationScope.shedLenghtList}">
                            <option value="${shedlength}">${shedlength}</option>
                        </c:forEach>
                    </select>

                    <label for="carportlength">Carport bredde</label>
                    <select class="form-select form-select-sm mb-3"  aria-label="shedlength" name="shedlength" id="shedlength">
                        <option selected>Vælg længde</option>
                        <c:forEach var="shedwidth" items="${applicationScope.shedWidthList}">
                            <option value="${shedwidth}">${shedwidth}</option>
                        </c:forEach>
                    </select>













                    <c:if test="withshed==1ou">

                        <p>hej hej:)</p>
                    </c:if>

                        <div>

                                <p>Her kan du skrive en kommentar</p>

                                <textarea id="commend" name="commend" rows="4" cols="50">

                                </textarea>
                        </div>

                    <button class="btn btn-primary" type="submit">læg i kurv</button>
                </form>
        </div>
    </jsp:body>
</t:genericpage>
