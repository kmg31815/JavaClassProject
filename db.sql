CREATE DATABASE `shopping`


-- shopping.`user` definition

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


-- shopping.`type` definition

CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


-- shopping.product definition

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- FOREIGN KEY 先拿掉，否則無法直接塞資料測試
--CREATE TABLE `product` (
--  `id` int NOT NULL AUTO_INCREMENT,
--  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
--  `price` int NOT NULL,
--  `type_id` int NOT NULL,
--  PRIMARY KEY (`id`),
--  CONSTRAINT `product_FK` FOREIGN KEY (`id`) REFERENCES `type` (`id`)
--) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


INSERT INTO shopping.`type` (name) VALUES
	 ('小說'),
	 ('漫畫'),
	 ('電子書');
	 

INSERT INTO shopping.product (name,image,description,price,type_id) VALUES
	 ('Sword Art Online刀劍神域 1 艾恩葛朗特','https://upload.wikimedia.org/wikipedia/zh/4/41/Sword_Art_Online_%28TW01%29.jpg','無法完全攻略就無法離開遊戲，GAME OVER也等於宣告玩家的「死亡」──<br>大約一萬名不知謎樣次世代線上遊戲「Sword Art Online 刀劍神域〈SAO〉」「真相」為何的玩家登入後，這場死亡戰鬥也隨之揭開了序幕。<br>身為其中一名SAO的遊戲玩家──主角．桐人，比任何人都還早接受這款線上遊戲的「真相」。他在遊戲的舞台──巨大浮遊城堡「艾恩葛朗特」裡，以不與人組隊的獨行劍士身分，逐漸展露頭角。<br>桐人原本以完全攻略的條件──以到達城堡最上層為目標，持續單獨地進行嚴酷且漫長的冒險。但在刺擊劍高手．女性劍士亞絲娜的強迫邀約之下，最後決定與她一起組隊。兩人的相遇也為桐人帶來了命中注定的契機──',161,1),
	 ('Sword Art Online刀劍神域 2 艾恩葛朗特','https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/046/77/0010467781.jpg&v=4bd0472dk&w=348&h=348','在主角．桐人所登入，完全攻略前無法脫離的死亡戰鬥ＭＭＯ「Sword Art Online刀劍神域」中，除了有像他這種以抵達最上層為目標的「攻略組」外，還有許多職業、想法各不相同的玩家存在。<br>她們在無法登出遊戲的嚴苛狀況下，仍充滿朝氣地生活著，歡笑並且哭泣，她們只是如此享受著「遊戲」。「馴獸師」西莉卡、「冶鍊商店」的女老闆．莉茲貝特、謎樣的小女孩．結衣、以及讓黑色劍士忘不了的少女．幸──<br>獨行玩家．桐人與她們交織出的四個章節，即將在此解開。',161,1),
	 ('Sword Art Online刀劍神域 Progressive 01','https://im1.book.com.tw/image/getImage?i=https://www.books.com.tw/img/001/067/08/0010670844.jpg&v=557028b7k&w=348&h=348','「這個遊戲是不可能被攻略的。所以只是在什麼地方以什麼樣的形式，以及早死……晚死的差異而已……」<br>茅場晶彥所設計的死亡遊戲開始已經有一個月的時間。<br>在這款難易度超高的VRMMO裡，已經出現了多達兩千名的犧牲者。<br>「第一層魔王攻略會議」當天。決定只強化自身能力，以「獨行」玩家身分戰鬥的桐人，<br>在前往會場的途中遇見了最前線相當少見的女性玩家。<br>只靠手裡的一把細劍持續與怪物進行戰鬥的她，看起來就像劃過夜空的「流星」一般──<br>收錄了「無星夜的詠嘆調」這篇桐人被稱呼為「黑色劍士」契機的短篇故事，<br>以及「幻矓劍之迴旋曲」這篇描述在攻略「第二層魔王」時，某名少年鐵匠的悲傷故事！',95,2);

