<#import "parts/common.ftl" as c>

<@c.page>
    <div class="card" style="width: 50rem;">
        <div class="container">
            <div class="row">
                <#--COL-1-->
                <div class="col-8 p-0">
                    <img class="card-img" src="static/img/1DzTT50Oy70.jpg" alt="Card image cap">
                    <#--<div class="ml-3 pt-3">
                        <h2 class="card-title">Hello, ${(userName)!"Sir"}</h2>
                        <p class="card-text"><s>Здесь скоро будет ваша персональная интернет база!</s></p>
                    </div>
                    <div class="card-body" >
                        <form method="post">
                            <div class="form-group row mt-4">
                                <label class="col-sm-4 col-form-label"><s>First name</s></label>
                                <div class="col-sm-8">
                                    <input disabled type="text" name="firstName" class="form-control" placeholder="first"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label"><s>Last name</s></label>
                                <div class="col-sm-8">
                                    <input disabled type="text" name="lastName" class="form-control" placeholder="last"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label"><s>City</s></label>
                                <div class="col-sm-8">
                                    <input disabled type="text" name="city" class="form-control" placeholder="last"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label"><s>Age</s></label>
                                <div class="col-sm-8">
                                    <input disabled type="text" name="age" class="form-control" placeholder="last"/>
                                </div>
                            </div>
                            <input disabled type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button disabled class="btn btn-primary" type="submit">Save</button>
                        </form>
                    </div>-->
                </div>
                <#--COL-2-->
                <div class="col pt-4 pl-4">
                    <button type="button" onclick="goLogin()" class="btn btn-success btn-block">Sign in</button>
                </div>
            </div>
        </div>
    </div>
</@c.page>
<script>
    function goLogin() {
        window.location.href = 'http://localhost:9000/login'
    }
</script>
