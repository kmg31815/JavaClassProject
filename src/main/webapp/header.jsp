<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<style>
li {
	display: flex;
	flex-direction: row;
	margin: 1% 5% 1% 5%;
	padding: 1%;
	height: 300px;
	border-style: outset;
	border-radius: 20px;
}

.item-name-block {
	flex: 1;
	padding: 2%;
	/* 置中搭配 display: flex */
	display: flex;
	/* 水平置中 */
	justify-content: center;
	/* 垂直置中 */
	align-items: center;
	font-family: sans-serif;
	font-size: 1.1em;
	background-color: rgb(210, 240, 255);
}

.item-img-block {
	flex: 1;
	padding: 2%;
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: serif;
}

.item-desc-block {
	flex: 3;
	padding: 2%;
	font-size: 0.875em;
	background-color: rgb(210, 255, 250);
}

.item-price-block {
	flex: 1;
	padding: 2%;
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: serif;
	font-size: 1.5em;
	background-color: rgb(255, 230, 200);
}

img {
	height: 250px;
}

header {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	height: 100px;
	background-color: rgb(122, 206, 255);
}

a {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>