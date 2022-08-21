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

				<form action="readProduct" method="GET"
					style="flex: 1; display: flex; flex-direction: row;">
					<div style="flex: 4; padding: 5px 20px 5px 5px;">
						<select name="type" class="form-control">
							<option value="" style="display: none">--- 請選擇商品類別 ---</option>
							<c:forEach var="i" begin="0" end="${typeList.size() - 1}"
								step="1">
								<option value="${typeList.get(i).typeId}">${typeList.get(i).typeName}</option>
							</c:forEach>
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
								placeholder="請輸入帳號" name="username" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label for="pass">密碼：</label> <input id="pass" type="password"
								placeholder="請輸入密碼" name="userpass" class="form-control"
								required>
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
				<form action="loginServlet" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label for="name">帳號：</label> <input id="name" type="text"
								placeholder="請輸入帳號" name="username" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label for="pass">密碼：</label> <input id="pass" type="password"
								placeholder="請輸入密碼" name="userpass" class="form-control"
								required>
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

	<footer> footer </footer>
</body>

</html>