<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Customers</title>
</head>
<body>
<div class=form-inline>
    <a role="button" class="btn btn-primary" href="/">Menu</a>
    <#--<a role="button" class="btn btn-secondary" href="/customer/add">Add customer</a>-->
    <a role="button" class="btn btn-secondary" href="/customer/list">Refresh</a>

    <nav class="navbar navbar-light bg-faded">
        <form class="form-inline img-t">
            <div class="input-group">
  	  <span class="input-group-addon" id="basic-addon3">
  	  	<select name="myChose" class="custom-select" id="setChoose">
         <option value="1">search by name</option>
         <option value="2">search by address</option>
         <option value="3">search by age</option>
        </select>
      </span>
                <input class="form-control mr-sm-2" type="text" id="myInput" onkeyup="Search()" placeholder="Search">
            </div>
        </form>
    </nav>
</div>
<h1 align="center">Customers</h1>
<div class="container img-t">
    <div class="table-responsive">
        <table id="customerTable" class="table table-bordered table-hover">
            <thead>
            <tr>
                <th hidden>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Age</th>
                <th>Sum</th>
                <th></th>
                <#--<th></th>-->
            </tr>
            </thead>
            <tbody>

        <#list list as customer>
        <tr>
            <td hidden>${customer.customerId}</td>
            <td><a href="/account/customer/${customer.customerId}">${customer.customerName}</a></td>
            <td>${customer.address}</td>
            <td>${customer.age}</td>
            <td>${customer.sum}</td>
            <td><a role="button" class="btn btn-primary" href="/customer/update/${customer.customerId}">Edit</a></td>
            <#--<td><a role="button" class="btn btn-primary" href="/customer/delete/${customer.id}">Delete</a></td>-->
        </tr>
        </#list>
            </tbody>
        </table>
    </div>
</div>
<form name="Customer" action="/customer/add" method="POST"  >
    <h1 align="center">Add new Customers</h1>
    <table align="center">
        <thead>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>age</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input title="Name" type="text" name="name"></td>
            <td><input title="Address" type="text" name="address"></td>
            <td><input title="Age" type="text" name="age"></td>
        </tr>
        </tbody>
    </table>


    <br>
    <button class="btn btn-primary" type="submit">Add</button>
    <a role="button" class="btn btn-secondary" href="/customer/list">Cancel</a>
</form>


<script>
    function Search() {
        var x = document.getElementById("setChoose").value;
        // Declare variables
        var input, filter, table, tr, td, i, k;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("customerTable");
        tr = table.getElementsByTagName("tr");
        th = table.getElementsByTagName("th");

        // Loop through all table rows, and hide those who don't match the search query

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[x];
            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
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