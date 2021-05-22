div>
<h3>Du har valgt følgende carporte:</h3>

<br/>

<table class="table table-striped">

    <thead><th>carportId</th><th>navn</th>><th>pris</th><th></th></thead>


        <tr>
            <td>${requestScope.idOrder}</td>
            <td>${requestScope.idOrder}</td>

            <td><button class="btn btn-outline-danger btn-sm" type="submit" name="delete" value="${status.index}">
                delete</button>

            </td>
        <tr/>

</table>



<br/>
<br/>

<div/>

<div>

    <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/fc/standartcarport" >Shop more</a>