<#import "parts/common.ftl" as c>
<#import "parts/loginForm.ftl" as l>
<@c.page>
    <div class="container" style="width: 60%;">
        <div class="row">
            <div class="col">


                <div class="card">
                    <h3 class="card-header p-tl-1">Please login first, Sir</h3>

                    <div>
                        <@l.login "/login" false/>
                    </div>



                </div>
            </div>
        </div>
    </div>
</@c.page>
<style>
    .p-tl-1 {
        padding-top: 1rem;
        padding-left: 1rem;
    }
</style>