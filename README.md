# java_web_project

專案討論7/24

前台（尚未登入）=商品列表與搜尋
可加入購物車但結帳時需檢核是否登入
商品上會有一個加入購物車的按鈕􁄂􀆔購物車􏿿

後台（登入後）=多了會員中心
會員中心可 編輯商品、查看我的購買紀錄

編輯商品：由商品存的uid從DB查出使用者可編輯列表
購買紀錄：每次結帳要將資料存DB 變成一筆訂單資訊（訂單編號 交易日期 購買人的UID 商品的ID 跟金額）

商品分類 可以有個下拉選單取得商品種類 用商品種類做查詢 （商品table一樣要多一個typeId
