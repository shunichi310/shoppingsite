<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
</head>
<body>

<form action = "../LoginAdmin.action" method = "post" >
ユーザーID<input type = "text" name = "username"><br>
パスワード<input type = "text" name = "password"><br>
<input type = "submit" value = "ログイン"><br>
</form>

</body>
</html>