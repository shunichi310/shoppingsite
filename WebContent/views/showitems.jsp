<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>

<% request.setCharacterEncoding("UTF-8"); %>
商品一覧 
<a href = "/ShoppingSite/views/cart.jsp" > カート </a> 
<a href = "Logout.action"  > ログアウト </a>
<c:forEach var="item" items="${items}" >
商品名<c:out value="${item.itemname}"/> 
値段<c:out value="${item.price}"/>
<a href = "CartAdd.action?id=<c:out value="${item.item_id}"/>&price=<c:out value="${item.price}"/>">カートに追加</a>
</c:forEach>

</body>
</html>