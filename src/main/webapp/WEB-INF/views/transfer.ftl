<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Transaction</title>
</head>
<body>
<div class=form-inline>
    <a role="button" class="btn btn-primary" href="/">Menu</a>

</div>
<h1 align="center">Transfer</h1>

<form name="Transfer" action="/transfer/transfer" method="post">
    <table class="table table-bordered table-hover">
        <tbody>
        <tr>
            <th>Sender</th>
            <td><input title="Name" type="text" name="customerName" value="${transferDto.customerName}"></td>
            <td hidden><input title="Name" type="text" name="customerId" value="${transferDto.customerId}"></td>
        <tr>
            <th>from Account</th>
            <td><input title="Account" type="text" name="account" value="${transferDto.account?c}"></td>
        </tr>
        <tr>
            <th>Available quantity</th>
            <td><input title="Available" type="number" name="quantity" value="${transferDto.value}"></td>
        </tr>
        <tr>
            <th>to Account</th>
            <td><select name="toAccount">
                <#list listAccounts as account>
                    <option value="${account.id?c}"> ${account.accountCustomerId}</option>
                </#list>
            </select></td>
        </tr>
        <tr>
            <th>Value</th>
            <td><input title="Value" type="text" name="value"></td>
        </tr>
        </tbody>
    </table>

    <button class="btn btn-primary" type="submit">Apply</button>
    <a role="button" class="btn btn-secondary" href="/account/customer/${transferDto.customerId}">Cancel</a>

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