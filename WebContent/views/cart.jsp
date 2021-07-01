<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートの中身</title>
</head>
<body>

<c:choose>
	<c:when test = "${cart.size()>0}">
		<p>${cart.size()}種類の商品があります。</p>
<%--  		<p>${cart.total}</p>  --%>
		<hr>
	</c:when>
	<c:otherwise>
		<p>カートに商品がありません</p>
	</c:otherwise>
</c:choose>

<table style="border-collapse:separate;border-spacing:10px">
<c:forEach var="item" items="${cart}">
	<tr>
	<td>${item.items.itemname}</td>
	<td>値段：${item.items.price}円</td>
	<td>個数：${item.count}</td>
	<td><a href="CartRemove.action?id=${item.items.item_id}">カートから削除</a></td>
	</tr>
</c:forEach>
</table>
<hr>
<form action= "Purchase.action" method="post">
<p>お名前<input type = "text" name = "name"></p>
<p>住所<input type="text" name="address"></p>
<p><input type="submit" value="購入を確定"></p>
</form>

<!-- 未完成 -->
<form action = "/ShoppingSite/views/showitems.jsp" method = "post" >
<input type = "submit" value = "買い物を続ける"><br>
</form>

</body>
</html>