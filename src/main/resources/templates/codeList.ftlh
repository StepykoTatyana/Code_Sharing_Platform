<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link th:href="@{/css/style.css}" rel="stylesheet"/>
            <link rel="stylesheet" href="https://unpkg.com/@highlightjs/cdn-assets@11.5.1/styles/default.min.css">
            <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.6/highlight.min.js"></script>
            <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <#list codes as codeModel>
        <tr>
            <pre><code><span>${codeModel.date}</span></code></pre>
            <pre><code><pre>${codeModel.code}</pre></code></pre>
        </tr>
    </#list>
</body>
</html>