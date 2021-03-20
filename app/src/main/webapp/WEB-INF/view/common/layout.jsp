<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <h1>レイアウトファイルです<h1>
        <ul>
            <li><a href="/app/" />HOME</a></li>
            <li><a href="/app/jdbc" />JDBCサンプル</a></li>
            <li><a href="/app/add" />足し算アプリ</a></li>
            <li><a href="/app/params" />パスパラメータサンプル</a></li>
        </ul>
        <tiles:insert attribute="content" />
    </body>
</html>