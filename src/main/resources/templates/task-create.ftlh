<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Task create</title>
</head>
<body style="width: 1650px">
<div class="container">
    <form action="/task" method="post" >
        Name<input type="text" name="name"><br><br>
        <#list users as user>
            <b>${user.id}</b><br>
            <b>${user.name}</b><br>
        </#list>
        Developer<input type="number" name="userId"><br><br>
        Name<input type="text" name="name"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Add task">
    </form>
</div>
</body>
</html>