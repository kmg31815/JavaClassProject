<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp"></jsp:include>
<title>Home</title>
</head>

<body>
	<header>
		<div style="height: 100%; display: flex; flex-direction: row;">
			<div style="flex: 1;">
				<a href="index.jsp"> <img style="height: 100px;"
					src="images/logo.jpg" alt="LOGO">
				</a>
			</div>
			<div style="flex: 4; display: flex; flex-direction: column;">
				<div style="flex: 1; display: flex; flex-direction: row;">
					<a style="flex: 1; border-style: double; border-color: black;"
						href="shopping_car.jsp">
						<div>購物車</div>
					</a> <a style="flex: 1; border-style: double; border-color: black;"
						href="member_center.jsp">
						<div>會員中心</div>
					</a> <a style="flex: 1; border-style: double; border-color: black;"
						href="sign_up.jsp">
						<div>註冊</div>
					</a> <a style="flex: 1; border-style: double; border-color: black;"
						href="login.jsp">
						<div>登入</div>
					</a>
				</div>
				<form action="readProduct" method="GET"
					style="flex: 1; display: flex; flex-direction: row;">
					<div style="flex: 4; padding: 5px 20px 5px 5px;">
						<select name="type" class="form-control">
							<option value="" style="display: none">--- 請選擇商品類別 ---</option>
							<option value="1">小說</option>
							<option value="2">漫畫</option>
							<option value="3">電子書</option>
						</select>
					</div>
					<div style="flex: 4; padding: 5px 20px 5px 5px;">
						<input type="text" placeholder="請輸入關鍵字" name="keyword"
							class="form-control">
					</div>
					<div style="flex: 1; padding: 5px 20px 5px 5px;">
						<input type="submit" value="搜尋" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>
	</header>

	<div style="margin-top: 150px;">
		<c:if test="${products.size() > 0}">
			<ul>
				<c:forEach var="i" begin="0" end="${products.size() - 1}" step="1">
					<li>
						<div class="item-name-block">
							<span>${products.get(i).productName}</span>
						</div>

						<div class="item-img-block">
							<img src="${products.get(i).productImage}" alt="刀劍神域 1">
						</div>

						<div class="item-desc-block">
							<span>${products.get(i).productDesc}</span>
						</div>

						<div class="item-price-block">
							<span>${products.get(i).productPrice} 元</span>
						</div>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>

	<footer> footer </footer>
</body>

</html>