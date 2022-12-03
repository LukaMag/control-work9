<#import "details/template.ftlh" as t>
<@t.template principal>
<div class="container">
    <table style="border: 2px solid black">
        <tr style="padding: 20px 50px;border: 2px solid black">
            <td style="padding: 20px 50px;border: 2px solid black">Name</td>
            <td style="padding: 20px 50px;border: 2px solid black">Status</td>
            <td style="padding: 20px 50px;border: 2px solid black">Developer</td>
        </tr>
        <#list tasks as task>
            <tr style="padding: 20px 50px;border: 2px solid black">
                <td style="padding: 20px 50px;border: 2px solid black">${task.name}</td>
                <td style="padding: 20px 50px;border: 2px solid black">${task.status}</td>
                <td style="padding: 20px 50px;border: 2px solid black">${task.user.email}</td>
            </tr>
            </#list>
    </table>
</div>
</@t.template>