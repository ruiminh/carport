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
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card text-center">

                    <div class="card-body">
                        <a href="#"><img src="${pageContext.servletContext.contextPath}/css/ProductPage.jpg"  height="200" width="200"/>
                                         </a>
                        <h5 class="card-title">${{order.product.price}}</h5>
                        <div class="row">
                            <div class="col-4 padding-0" >
                                <input type="number" min="0" class="form-control"
                                       [(ngModel)]=order.quantity>
                            </div>
                            <div class="col-4 padding-0">
                                <button class="btn btn-primary" (click)="addToCart(order)"
                                        [disabled]="order.quantity <= 0">Add To Cart
                                </button>
                            </div>







                        </div>
                    </div>
                </div>
            </div>






    </jsp:body>

</t:genericpage>
