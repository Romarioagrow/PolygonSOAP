<#import "parts/common.ftl" as c>

<@c.page>
    <!-- Фильтр сообщений
    <div class="form-row mt-3">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" placeholder="Filter by tag" value="${filter!''}">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>-->

    <!-- Шапка разворачивающийся формы-->
    <a class="btn btn-primary"
       data-toggle="collapse"
       href="#collapseExample"
       role="button"
       aria-expanded="false"
       aria-controls="collapseExample">
        New message, Sir!
    </a>
    <!-- див формы отправки сообщений-->
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <!-- Форма отправки сообщений -->
            <form method="post" enctype="multipart/form-data">
                <!--<div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Your Message</span>
                    </div>
                    <textarea class="form-control" aria-label="With textarea"></textarea>
                </div>-->

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Your Message</span>
                    </div>
                    <textarea class="form-control" name="text" aria-label="With textarea" placeholder="Type something..."></textarea>
                    <!--<input type="text" class="form-control" name="text" placeholder="Enter message"/>-->
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" name="tag" placeholder="Your teg"/>
                </div>

                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose</label>
                    </div>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Post</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Разметка столбцов для отображения контента-карточек-->
    <div class="card-columns">
    <#list messages as message>
        <div class="card my-3"">
        <#if message.filename??>
            <img src="/img/${message.filename}" class="card-img-top">
        </#if>

        <div class="m-2">
            <span>${message.text}</span>
            <i>${message.tag}</i>
        </div>

        <div class="card-footer text-muted">
            ${message.authorName}
        </div>
        <table>
            <tr><a href="#" class="card-link">Edit message</a></tr>
            <tr><a href="#" class="card-link">Delete message</a></tr>
        </table>
        </div>
    <#else>
        No Messages!
    </#list>
</@c.page>