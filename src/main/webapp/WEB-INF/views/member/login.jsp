<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript"
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
/* 로그인 카드 */
#join_section .container {
	background: linear-gradient(180deg, #ffffff 0%, #fdfdfd 100%);
	padding: 30px;
	border-radius: 14px;
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.12);
	width: 360px;
	margin: auto;
}

/* 테이블 */
.table {
	margin-bottom: 0;
	border-collapse: separate;
	border-spacing: 0 8px;
}

.table th {
	background-color: #f8f9fc;
	vertical-align: middle;
	font-weight: 600;
	font-size: 13px;
	border: none !important;
	border-radius: 8px 0 0 8px;
	padding: 8px 12px;
	color: #555;
}

.table td {
	vertical-align: middle;
	border: none !important;
	border-radius: 0 8px 8px 0;
	padding: 8px 12px;
}

/* 입력창 */
.input-sm {
	width: 100%;
	height: 36px;
	padding: 6px 10px;
	border-radius: 7px;
	border: 1px solid #dcdde1;
	font-size: 13px;
	transition: all 0.25s ease;
}

.input-sm:focus {
	border-color: #f0ad4e;
	box-shadow: 0 0 0 2px rgba(240, 173, 78, 0.25);
	outline: none;
}

/* 자동로그인 */
input[type="checkbox"] {
	margin-right: 6px;
	accent-color: #f0ad4e;
	transform: scale(1);
}

/* 에러 메시지 */
td[style*="color:red"] {
	text-align: center;
	font-weight: 600;
	font-size: 12.5px;
	color: #e74c3c !important;
	padding: 6px 0;
}

/* 버튼 */
.btn-warning {
	background: linear-gradient(135deg, #f0ad4e, #ec971f);
	border: none;
	padding: 7px 20px;
	border-radius: 24px;
	font-weight: 600;
	font-size: 13px;
	box-shadow: 0 4px 10px rgba(240, 173, 78, 0.35);
	transition: all 0.25s ease;
}

.btn-warning:hover {
	background: linear-gradient(135deg, #ec971f, #d58512);
	transform: translateY(-1px);
	box-shadow: 0 6px 14px rgba(240, 173, 78, 0.45);
}

/* 버튼 정렬 */
.table tr:last-child td {
	text-align: center;
	padding-top: 14px;
}

.table tr:last-child button {
	margin: 0 6px;
}
</style>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(/img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="bradcumb-title text-center">
						<h2>로그인</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="breadcumb-nav">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<%-- 검색기 --%>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- ****** Breadcumb Area End ****** -->

	<!-- ****** Archive Area Start ****** -->
	<section class="archive-area section_padding_80" id="join_section">
		<div class="container" style="max-width: 800px; margin-top: 40px;">
			<div class="row justify-content-center">
				<form action="/member/login_process" method="post">
					<table class="table">
						<tbody>
							<tr>
								<th class="text-center" width=20%>ID</th>
								<td width=80%><input type=text size=20 class="input-sm"
									required name="userid"></td>
							</tr>
							<tr>
								<th class="text-center" width=20%>Password</th>
								<td width=80%><input type=password size=20 class="input-sm"
									required name="userpwd"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="checkbox" name="remember-me">
									자동로그인</td>
							</tr>
							<tr>
								<td colspan="2" style="color: red">${message }</td>
							</tr>

							<tr>
								<td colspan="2">
									<button class="btn-sm btn-warning" type="submit">로그인</button>
									<button class="btn-sm btn-warning" type="button"
										onclick="javascript:history.back()">취소</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</section>

</body>
</html>