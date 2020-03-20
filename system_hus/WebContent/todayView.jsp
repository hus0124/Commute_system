<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "model.CommuteDTO" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%> 
<% 
List<CommuteDTO> pageList = new ArrayList<CommuteDTO>();
pageList = (List<CommuteDTO>)request.getAttribute("todayList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>금일 출근 상황</title>
<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
table.type11 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}
table.type11 th {
    width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #ce4869 ;
    text-align : center;
}
table.type11 td {
    width: 155px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
}
</style>
</head>
<body>

<table class="type11">
		<tr><th scope="cols">아이디</th>
		<th scope="cols">이름</th>
		<th scope="cols">퇴근여부(=true)</th>
		<th scope="cols">출근시간</th>
		<th scope="cols">퇴근시간</th>
		<th scope="cols">근무시간</th>
		<tbody>
<%
	for(int i = 0; i <pageList.size(); i++){ %>
		<tr><td><%= pageList.get(i).getId() %></td>
		<td><%= pageList.get(i).getWorkername() %></td>
		<td><%= pageList.get(i).getIsout() %></td>
		<td><%= pageList.get(i).getComein() %></td>
		<td><%= pageList.get(i).getComeout() %></td>
		<td><%= pageList.get(i).getWorktime() %></td>
		</tr>
<% } %>			
	</tbody></table>		

<br><a href="javascript:adminwindow.submit()"><button class = "login100-form-btn" style="width:600px">AdminWindow
</button></a>	

<br><a href="mainView.jsp"><button class="login100-form-btn" style="width:600px">Main
</button></a>

<form name = "adminwindow" action="check" method="get">
<input type ="hidden" name = "nfcid" value="admin">
</form>

<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/main.js"></script>
</body>
</html>