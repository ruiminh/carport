<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:attribute name="header">
         Enkelte Carporte
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>



    <jsp:body>

        <div class="row card-deck">
        <form name="addProduct" action="${pageContext.request.contextPath}/fc/showBasket"  method="POST">

            <div class="container">
                <c:forEach var="product" items="${applicationScope.productList}" varStatus="counter">
                <div class="row border">
                    <div class="col-sm ">
                        <c:if test="${product.carportId%2 == 0}">
                            <img src="${pageContext.servletContext.contextPath}/css/ProductPage.jpg" height="121" width="200"/>
                        </c:if>
                        <c:if test="${product.carportId%2 == 1}">
                            <img src="${pageContext.servletContext.contextPath}/css/ProductModel.jpg" height="121" width="200"/>
                        </c:if>
                    </div>
                    <div class="col-lg">
                        ${product.name}
                    </div>
<%--                    <div class="col-sm">--%>
<%--                        ${product.price}--%>
<%--                    </div>--%>
                    <div class="col-sm">
                        <p class="text-right">
                            <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.price}"/>
                        </p>
                        <button class="btn btn-primary" type="submit">Læg i indkøbskurv</button>
                        <input type="hidden" name="name" value="${product.name}" />
                        <input type="hidden" name="quantity" value="${product.quantity}" />
                        <input type="hidden" name="price" value="${product.price}" />
                        <input type="hidden" name="carportId" value="${product.carportId}" />
                    </div>
                </div>
                </c:forEach>
            </div>

<%--            <div class="col-lg-4 col-md-6 mb-4">--%>
<%--                <div class="card text-center">--%>

<%--                    <div class="card-body">--%>

<%--                        <c:forEach var="product" items="${applicationScope.productList}" varStatus="counter">--%>




<%--                        <div class="row">--%>

<%--                            <div class="col-4 padding-0">--%>
<%--                                <h5 class="card-price">${{product.price}}</h5>--%>
<%--                            </div>--%>

<%--                            <div class="col-4 padding-0">--%>
<%--                                <button class="btn btn-primary" type="submit">Læg i indkøbskurv</button>--%>
<%--                            </div>--%>

<%--                            <label>--%>

<%--
<%--                            </label>--%>

<%--                            </c:forEach>--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

            </div>

        </form>




    </jsp:body>

</t:genericpage>
