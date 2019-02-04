<#import "parts/common.ftl" as c>

<@c.page>
    <h2>Hello, ${(userName)!"Sir"}</h2>
    <div>Здесь скоро будет ваша персональная интернет база!</div>

    <form method="post">
        <!-- first -->
        <div class="form-group row mt-4">
            <label class="col-sm-2 col-form-label">First name</label>
            <div class="col-sm-6">
                <input type="text" name="firstName" class="form-control" placeholder="first"/>
            </div>
        </div>

        <!-- last -->
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Last name</label>
            <div class="col-sm-6">
                <input type="text" name="lastName" class="form-control" placeholder="last"/>
            </div>
        </div>

        <!-- city -->
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">city</label>
            <div class="col-sm-6">
                <input type="text" name="city" class="form-control" placeholder="last"/>
            </div>
        </div>

        <!-- age -->
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">age</label>
            <div class="col-sm-6">
                <input type="text" name="age" class="form-control" placeholder="last"/>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-primary" type="submit">Save

    </form>

</@c.page>