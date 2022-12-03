<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Create</title>
</head>
<body style="width: 1650px">
<h2>Register</h2>
<div class="container">
    <form action="/register" method="post" >
        Name<input type="email" name="email"><br><br>
        Password<input type="password" name="password"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Add User">
    </form>
    <#if error??>
        <h2 style="color: red">${error}</h2>
    </#if>
</div>
</body>
</html>