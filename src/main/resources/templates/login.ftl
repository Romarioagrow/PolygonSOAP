<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>


<@c.page>
    <div class="mb-1"><h3>Please login first, Sir</h3></div>
    <@l.login "/login" false/>
</@c.page>