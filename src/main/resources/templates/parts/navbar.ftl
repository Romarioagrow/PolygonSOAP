<#include "security.ftl">
<#import "loginForm.ftl" as l>

<!-- Подгонка навпанели под экран и цветовая схема-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <!-- Название проекта-->
    <a class="navbar-brand" href="/">
        <h1>Polygon S</h1>
    </a>

    <!-- Конопка меню на маленьких экранах-->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Основной блок навпанели -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <!-- Кнопки меню -->
        <ul class="navbar-nav mr-auto">
            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/">Main page</a>
                </li>
            </#if>

            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/messages">Messages</a>
                </li>
            </#if>

            <!-- только если пользователь - админ-->
            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/user">All Users</a>
                </li>
            </#if>

            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/user/profile">My profile</a>
                </li>
            </#if>
        </ul>

        <!-- Имя пользователя-->
        <div class="navbar-text mr-3">Sir ${name}</div>
        <#if isAdmin>
            <@l.logout/>
        </#if>
    </div>
</nav>