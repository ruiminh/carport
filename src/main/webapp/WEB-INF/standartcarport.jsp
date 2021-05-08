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
        <form name="addtobasket" action="${pageContext.request.contextPath}/fc/basket"  method="POST">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card text-center">

                    <div class="card-body">
                        <img src="${pageContext.servletContext.contextPath}/css/ProductPage.jpg" height="121" width="200"/>

                        <h5 class="card-title">CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING</h5>

                        <div class="row">

                            <div class="col-4 padding-0" >
                                <input type="number" min="0" class="form-control">
                            </div>

                            <div class="col-4 padding-0">
                                <button class="btn btn-primary" type="submit">Læg i indkøbskurv</button>
                            </div>

                            <div class="col-4 padding-0">
                                <h5 class="card-price">${{order.carport.price}}</h5>
                            </div>






                        </div>
                    </div>
                </div>

            </div>
        </form>





    </jsp:body>

</t:genericpage>
