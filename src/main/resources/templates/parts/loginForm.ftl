<#macro login path isRegisterForm>
    <div>
        <form action="${path}" method="post">
            <div class="card-body pt-0">
                <div class="form-group row mt-4">
                    <label class="col-sm-4 col-form-label">User Name :</label>
                    <div class="col-sm-8">
                        <input type="text" name="username" class="form-control" placeholder="Your name"/>
                    </div>
                </div>
                <!-- Ввод пароля -->
                <div class="form-group row">
                    <label class="col-sm-4 col-form-label">Password:</label>
                    <div class="col-sm-8">
                        <input type="password" name="password" class="form-control" placeholder="Your password"/>
                    </div>
                </div>
            </div>
            <!-- Ввод логина -->
            <div class="card-footer">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="row">
                    <div class="col">
                        <button class="btn btn-primary btn-block" type="submit">
                            <#if isRegisterForm>Create<#else>Sign in</#if>
                        </button>
                    </div>
                    <div class="col">
                        <#if !isRegisterForm>
                            <a href="/registration" class="btn btn-outline-dark btn-block" role="button" aria-pressed="true">Add new User!</a>
                        </#if>
                    </div>
                </div>
            </div>
        </form>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-outline-danger" type="submit">Sign Out</button>
    </form>
</#macro>

