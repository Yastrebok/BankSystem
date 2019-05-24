<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>All Transactions</title>
</head>
<body>
<div class=form-inline>
    <a role="button" class="btn btn-primary" href="/">Menu</a>
    <a role="button" class="btn btn-secondary" href="/transfer/all">Refresh</a>

</div>
<h1 align="center">Transactions</h1>
<div class="container img-t">
    <div class="table-responsive">
        <input class="form-control" type="text" placeholder="Customer or Date" id="search-text" onkeyup="tableSearch()">
        <table id="transactionTable" class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>Date</th>
                <th>Customer</th>
                <th hidden>CustomerId</th>
                <th>Account</th>
                <th>Type</th>
                <th>Value</th>
            </tr>
            </thead>
            <tbody>

        <#list list as transaction>
        <tr>
            <td>${transaction.date}</td>
            <td>${transaction.customerName}</td>
            <td hidden>${transaction.customerId}</td>
            <td>${transaction.account?c}</td>
            <td>${transaction.type}</td>
            <td>${transaction.value}</td>

        </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>

<script>
    function tableSearch() {
        var phrase = document.getElementById('search-text');
        var table = document.getElementById('transactionTable');
        var regPhrase = new RegExp(phrase.value, 'i');
        var flag = false;
        for (var i = 1; i < table.rows.length; i++) {
            flag = false;
            for (var j = table.rows[i].cells.length - 1; j >= 0; j--) {
                flag = regPhrase.test(table.rows[i].cells[j].innerHTML);
                if (flag) break;
            }
            if (flag) {
                table.rows[i].style.display = "";
            } else {
                table.rows[i].style.display = "none";
            }
        }
    }
</script>


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