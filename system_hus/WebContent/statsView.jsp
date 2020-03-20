<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.CommuteDTO" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%> 

<% List<CommuteDTO> pageList = new ArrayList<CommuteDTO>();
List<CommuteDTO> pageList2 = new ArrayList<CommuteDTO>(); 
	pageList = (List<CommuteDTO>)request.getAttribute("searchList");
	pageList2 = (List<CommuteDTO>)request.getAttribute("searchList2");
	
	//int pagemonth = (Integer)request.getAttribute("checkmonth");
	//String pagehour = (String)request.getAttribute("checkhour");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>출퇴근 통계 기록 검색</title>
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
<form name = "monthform" action = "adminServlet" method = "post">
검색할 월 입력 : 
	<select name = "month" required>
		<option value="" selected> 선택하세요 </option>
		<option value = "1">1월</option>
		<option value = "2">2월</option>
		<option value = "3">3월</option>
		<option value = "4">4월</option>
		<option value = "5">5월</option>
		<option value = "6">6월</option>
		<option value = "7">7월</option>
		<option value = "8">8월</option>
		<option value = "9">9월</option>
		<option value = "10">10월</option>
		<option value = "11">11월</option>
		<option value = "12">12월</option>		
	</select>
		
	<br><br>초과 근무 기준 시간 입력 : 
	<div class="wrap-input100 validate-input" style="width:500px">
		<input class="input100" type="text" name = "hour" style="width:500px">
		<span class="focus-input100"></span>
	</div>
</form>


<br><a href="javascript:monthform.submit()"><button class="login100-form-btn" style="width:500px">월별 근무 시간 기록 검색
</button></a>
	
<br><a href="mainView.jsp"><button class = "login100-form-btn" style="width:500px">Main
</button></a><br><br>	

<%if (pageList!=null) { %>

  	<table class="type11">
		<tr><th scope="cols">아이디</th>
		<th scope="cols">이름</th>
		<th scope="cols">근무시간</th><tbody>
<%
	for(int i = 0; i <pageList.size(); i++){ %>
		<tr><td><%= pageList.get(i).getId() %></td>
		<td><%= pageList.get(i).getWorkername() %></td>
		<td><%= pageList.get(i).getWorktime() %></td>
		</tr>
<% } %>			
	</tbody></table>
<% } %>

<%if (pageList2!=null) { %>
  	<table class="type11">
		<tr><th scope="cols">아이디</th>
		<th scope="cols">이름</th>
		<th scope="cols">근무시간</th><tbody>
<%
	for(int i = 0; i <pageList2.size(); i++){ %>
		<tr><td><%= pageList2.get(i).getId() %></td>
		<td><%= pageList2.get(i).getWorkername() %></td>
		<td><%= pageList2.get(i).getWorktime() %></td>
		</tr>
<% } %>			
	</tbody></table>
<% } %>	

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
</body>
</html>