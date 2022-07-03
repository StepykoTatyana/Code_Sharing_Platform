<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link th:href="@{/css/style.css}" rel="stylesheet"/>
            <link rel="stylesheet" href="https://unpkg.com/@highlightjs/cdn-assets@11.5.1/styles/default.min.css">
            <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.6/highlight.min.js"></script>
            <script>hljs.initHighlightingOnLoad();</script>
        <script type="text/javascript" src="/js/function.js"></script>
</head>
<body>
    <pre><code><span id="load_date">${date}</span></code></pre>

    <#if viewsSecret >
        <span id="views_restriction">${views} more views allowed</span></br>
    </#if>
    <#if timeSecret >
        <span id="time_restriction">The code will be available for ${time} seconds</span>
    </#if>
        <pre id="code_snippet"><code>${code}</code></pre>
</body>
</html>