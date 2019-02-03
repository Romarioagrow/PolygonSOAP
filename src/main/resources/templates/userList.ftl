<#import "parts/common.ftl" as c>

<@c.page>
    <h2>List of Users!</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Registration date</th>
            <th>Role</th>
            <th scope="col">Edit!</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.registrationDate}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">Edit user!</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>