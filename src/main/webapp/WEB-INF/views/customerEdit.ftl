<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Edit Image</title>
</head>
<body class="form-group">
<form action="/customer/update" method="POST" class="form-group">
    <table class="table table-bordered table-hover">
        <tbody>
        <tr>
            <th>Customer name</th>
            <td><input title="Name" type="text" name="name" value="${customer.name}"></td>
            <td hidden><input title="Id" type="text" name="id" value="${customer.id}"></td>
        <tr>
            <th>Address</th>
            <td><input title="Address" type="text" name="address" value="${customer.address}"></td>
        </tr>
        <tr>
            <th>Age</th>
            <td><input title="Age" type="text" name="age" value="${customer.age}"></td>
        </tr>
        </tbody>

    </table>
    <div class="form-group">
        <button class="btn btn-primary" type="submit">OK</button>
        <a role="button" class="btn btn-secondary" href="/customer/list">Cancel</a>
    </div>


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