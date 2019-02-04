<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post">
        <!-- Изменение логина -->
        <div class="form-group row mt-4">
            <label class="col-sm-2 col-form-label">New username:</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Enter new name"/>
            </div>
        </div>

        <!-- Изменение пароля -->
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">New password:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Type new password"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-primary" type="submit">Save

    </form>
</@c.page>