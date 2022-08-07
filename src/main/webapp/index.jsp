<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form action="homeServlet" method="GET"
					style="flex: 1; display: flex; flex-direction: row;">
					<div style="flex: 4; padding: 5px 20px 5px 5px;">
						<select name="type" class="form-control">
							<option value="" style="display: none">--- 請選擇商品類別 ---</option>
							<option value="novel">小說</option>
							<option value="comic">漫畫</option>
							<option value="ebook">電子書</option>
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
		<ul>
			<li>
				<div class="item-name-block">
					<span>Sword Art Online刀劍神域 1 艾恩葛朗特</span>
				</div>

				<div class="item-img-block">
					<img
						src="https://upload.wikimedia.org/wikipedia/zh/4/41/Sword_Art_Online_%28TW01%29.jpg"
						alt="刀劍神域 1">
				</div>

				<div class="item-desc-block">
					<span> 無法完全攻略就無法離開遊戲，GAME OVER也等於宣告玩家的「死亡」──<br>
						大約一萬名不知謎樣次世代線上遊戲「Sword Art Online
						刀劍神域〈SAO〉」「真相」為何的玩家登入後，這場死亡戰鬥也隨之揭開了序幕。<br>
						身為其中一名SAO的遊戲玩家──主角．桐人，比任何人都還早接受這款線上遊戲的「真相」。他在遊戲的舞台──巨大浮遊城堡「艾恩葛朗特」裡，以不與人組隊的獨行劍士身分，逐漸展露頭角。<br>
						桐人原本以完全攻略的條件──以到達城堡最上層為目標，持續單獨地進行嚴酷且漫長的冒險。但在刺擊劍高手．女性劍士亞絲娜的強迫邀約之下，最後決定與她一起組隊。兩人的相遇也為桐人帶來了命中注定的契機──<br>
						在個人網站上連載時，創下超過650萬閱覽人數的紀錄！傳說中的小說即將登場！
					</span>
				</div>

				<div class="item-price-block">
					<span>161 元</span>
				</div>
			</li>
			<li>
				<div class="item-name-block">
					<span>商品名稱</span>
				</div>
				<div class="item-img-block">
					<img src="" alt="刀劍神域 2">
				</div>
				<div class="item-desc-block">
					<span>商品介紹</span>
				</div>
				<div class="item-price-block">
					<span>商品價錢</span>
				</div>
			</li>
			<li>
				<div class="item-name-block">
					<span>商品名稱</span>
				</div>
				<div class="item-img-block">
					<img src="" alt="刀劍神域 3">
				</div>
				<div class="item-desc-block">
					<span>商品介紹</span>
				</div>
				<div class="item-price-block">
					<span>商品價錢</span>
				</div>
			</li>
		</ul>
	</div>

	<footer> footer </footer>
</body>

</html>