<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp"></jsp:include>
<title>shopping car</title>
</head>

<body>
	<header>
		<div style="height: 100%; display: flex; flex-direction: row;">
			<div style="flex: 1;">
				<a href="<%=request.getContextPath()%>/"> <img
					style="height: 100px;" src="images/logo.jpg" alt="LOGO">
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
					</a>
					<!-- Button trigger modal -->
					<a
						style="flex: 1; border-style: double; border-color: black; cursor: pointer;"
						data-toggle="modal" data-target="#signupModal">
						<div>註冊</div>
					</a>
					<!-- Button trigger modal -->
					<a
						style="flex: 1; border-style: double; border-color: black; cursor: pointer;"
						data-toggle="modal" data-target="#loginModal">
						<div>登入</div>
					</a>
				</div>

				<div>
					<marquee behavior="alternate" bgcolor="#7FFFD4" height="100%">以下為購物車商品列表</marquee>
				</div>
			</div>
		</div>
	</header>

	<div style="margin-top: 150px;">
		<c:if test="${buyProducts.size() > 0}">
			<ul>
				<c:forEach var="i" begin="0" end="${buyProducts.size() - 1}"
					step="1">
					<li>
						<div class="item-name-block">
							<span>${buyProducts.get(i).productName}</span>
						</div>

						<div class="item-img-block">
							<img src="${buyProducts.get(i).productImage}">
						</div>

						<div class="item-desc-block">
							<span>${buyProducts.get(i).productDesc}</span>
						</div>

						<div class="item-price-block">
							<span>${buyProducts.get(i).productPrice} 元</span>
						</div>
						<div class="item-buy-block">
							<a type="button" class="btn btn-warning"
								href="<%=request.getContextPath()%>/shoppingCar?buy_product_id=${buyProducts.get(i).productId}">下次再買</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>

	<!-- signup Modal -->
	<div class="modal fade" id="signupModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sign Up</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="signUpServlet" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label for="name">帳號：</label> <input id="name" type="text"
								placeholder="請輸入帳號" name="username" class="form-control">
						</div>
						<div class="form-group">
							<label for="pass">密碼：</label> <input id="pass" type="password"
								placeholder="請輸入密碼" name="userpass" class="form-control">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">註冊</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- login Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sign In</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="signUpServlet" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label for="name">帳號：</label> <input id="name" type="text"
								placeholder="請輸入帳號" name="username" class="form-control">
						</div>
						<div class="form-group">
							<label for="pass">密碼：</label> <input id="pass" type="password"
								placeholder="請輸入密碼" name="userpass" class="form-control">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">登入</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- sign up fail -->
	<c:if test="${fail}">
		<script>
			alert('使用者名稱已註冊');
		</script>
		<%
		session.setAttribute("fail", false);
		%>
	</c:if>

	<!-- sign up success -->
	<c:if test="${success}">
		<script>
			alert('註冊成功，請重新登入');
		</script>
		<%
		session.setAttribute("success", false);
		%>
	</c:if>

	<!-- login fail -->
	<c:if test="${loginfail}">
		<script>
			alert('登入失敗\n帳號或密碼錯誤');
		</script>
		<%
		session.setAttribute("loginfail", false);
		%>
	</c:if>

</body>
</html>