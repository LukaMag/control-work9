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
    <form action="/task/edit" method="post" >
        <input type="hidden" value="${task.id}" name="id">
        Name<input type="text" name="name"><br><br>
        <#list statuses as status>
            <b>${status}</b><br>
        </#list>
        Status<input type="text" name="status"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Edit task">
    </form>
</div>
</body>
</html>