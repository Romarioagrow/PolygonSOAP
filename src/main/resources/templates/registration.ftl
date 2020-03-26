<#import "parts/common.ftl" as c>
<#import "parts/loginForm.ftl" as l>

<@c.page>
    <div class="mb-1"><h3>Add new User, Sir!</h3></div>
    ${message!}
    <@l.login "/registration" true/>
    <a href="/login" class="btn btn-outline-dark btn-block" role="button" aria-pressed="true">Go back</a>

</@c.page>