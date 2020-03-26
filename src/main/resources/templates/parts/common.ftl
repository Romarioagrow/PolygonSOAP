<!-- Общий шаблон для страниц-->
<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>myBase</title>
        <link rel="stylesheet" href="/static/css/style.css">
        <!-- Плотные шрифты-->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Стили Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    </head>
    <body>
    <!-- Подключить навпанель -->
    <#include "navbar.ftl">
    <!-- Сюда вставлются страницы -->
    <!-- Подлючить разметку и отступы Bootstrap -->
    <div class="container mt-5">
        <#nested>
    </div>
    <!-- Блоки JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    </body>
    </html>
</#macro>