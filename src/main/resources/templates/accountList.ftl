<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Accounts</title>
</head>
<body>
<div class=form-inline>
    <a role="button" class="btn btn-primary" href="/">Menu</a>
    <a role="button" class="btn btn-secondary" href="/account/customer/${customer.id}">Refresh</a>
    <a role="button" class="btn btn-secondary" href="/customer/list">Back</a>

</div>
<h1 align="center">Accounts</h1>
<div class="container img-t">
    <div class="table-responsive">
        <table id="customerTable" class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>Number</th>
                <th>Customer</th>
                <th>Quantity</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>

        <#list list as account>
        <tr>
            <td>${account.id?c}</td>
            <td>${customer.name}</td>
            <td>${account.quantity}</td>

            <td><a role="button" class="btn btn-primary" href="/transfer/withDraw/${account.id?c}">WithDraw</a></td>
            <td><a role="button" class="btn btn-primary" href="/transfer/deposit/${account.id?c}">Deposit</a></td>
            <td><a role="button" class="btn btn-primary" href="/transfer/transfer/${account.id?c}">Transfer</a></td>
        </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>

<form name="Account" action="/account/add" method="POST">
    <input hidden="hidden" title="CustomerId" type="text" name="customerId" value="${customer.id}">
    <br>
    <button class="btn btn-primary" type="submit">Generate new account</button>
</form>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>