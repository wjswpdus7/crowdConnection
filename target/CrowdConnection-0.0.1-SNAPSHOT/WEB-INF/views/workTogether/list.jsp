<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	max-width: 1920px;
}

.logo {
	display: flex;
	list-style: none;
	justify-content: flex-end;
}

.logo:first-child {
	margin-right: 1000px;
}

.gnb ul {
	display: flex;
	list-style: none;
	justify-content: space-between;
	width: 1200px;
	margin: 0 auto;
}

.contents {
	display: flex;
	margin-top: 150px;
	margin: 0 auto;
	justify-content: center;
}

.sort ul {
	list-style: none;
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>
	<div class="logo">
		<p>로고</p>
		<p>로그인/회원가입</p>
		<p>투자펀딩 만들기</p>
	</div>

	<div class="gnb">
		<ul>
			<li>홈</li>
			<li>투자</li>
			<li>동업</li>
			<li>수요조사</li>
			<li>고객센터</li>
			<li><input type="text" placeholder="검색창"></li>
			<li><a href="search">검색</a></li>
		</ul>
	</div>

	<!--  -->
	<div class="contents">
		<div class="category">
			<p>종류</p>
			<label><input type="checkbox">변경</label> <label><input
				type="checkbox">확장</label>

			<p>분류</p>
			<label><input type="checkbox">진행중</label> <label><input
				type="checkbox">종료됨</label>
		</div>

		<div class="list">
			<div class="sort">
				<ul>
					<li><input type="text" placeholder="검색창"></li>
					<li><a href="search">검색</a></li>
					<li>조회순</li>
					<li>최신순</li>
					<li>인기순</li>
				</ul>
			</div>

			<div>
				<ul>
					<li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>