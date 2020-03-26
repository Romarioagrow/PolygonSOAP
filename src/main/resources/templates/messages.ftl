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
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Your Message</span>
                    </div>
                    <textarea class="form-control" name="text" aria-label="With textarea" placeholder="Type something..."></textarea>
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
    <div class="card-columns" id="products">
        <#if messages?has_content>
            <#list messages as message>
                <div class="card product-card mr-3 mt-3">
                    <#if message.filename??>
                        <img class="card-img-top" src="static/img/posts/${message.filename}" alt="fuck image">
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">
                            <span>${message.text}</span>
                            <i>${message.tag}</i>
                        </h5>
                        <p class="card-text">
                            ${message.authorName}
                        </p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">
                            <span>at ${message.date}</span>
                        </small>
                    </div>
                </div>
            </#list>
        <#else>
            No messages
        </#if>
    </div>
</@c.page>