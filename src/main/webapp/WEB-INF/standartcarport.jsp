<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Enkelte Carporte
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>



    <jsp:body>

        <div class="row card-deck">
        <form name="addProduct" action="${pageContext.request.contextPath}/fc/showBasket"  method="POST">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card text-center">

                    <div class="card-body">
                        <img src="${pageContext.servletContext.contextPath}/css/ProductPage.jpg" height="121" width="200"/>


                        <c:forEach var="product" items="${applicationScope.productList}" varStatus="counter" begin="0" end="0">

                            <h5 class="card-title"> ${{product.name}}  </h5>

                        <div class="row">

                            <div class="col-4 padding-0">
                                <h5 class="card-price">${{product.price}}</h5>
                            </div>

                            <div class="col-4 padding-0">
                                <button class="btn btn-primary" type="submit">Læg i indkøbskurv</button>
                            </div>

                            <label>

                                <input type="hidden" name="name" value="${product.name}" />
                                <input type="hidden" name="quantity" value="${product.quantity}" />
                                <input type="hidden" name="price" value="${product.price}" />
                            </label>

                            </c:forEach>

                        </div>
                    </div>
                </div>

            </div>

        </form>

        <div class="row card-deck">
        <form name="addProduct" action="${pageContext.request.contextPath}/fc/showBasket"  method="POST">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card text-center">

                    <div class="card-body">
                        <img src="${pageContext.servletContext.contextPath}/css/ProductModel.jpg" height="121" width="136"/>


                        <c:forEach var="product" items="${applicationScope.productList}" varStatus="counter" begin="1" end="1">

                        <h5 class="card-title"> ${{product.name}}  </h5>

                        <div class="row">

                            <div class="col-4 padding-0">
                                <h5 class="card-price">${{product.price}}</h5>
                            </div>

                            <div class="col-4 padding-0">
                                <button class="btn btn-primary" type="submit">Læg i indkøbskurv</button>
                            </div>

                            <label>

                                <input type="hidden" name="name" value="${product.name}" />
                                <input type="hidden" name="quantity" value="${product.quantity}" />
                                <input type="hidden" name="price" value="${product.price}" />
                            </label>

                            </c:forEach>

                        </div>
                    </div>
                </div>

            </div>

        </form>



    </jsp:body>

</t:genericpage>
