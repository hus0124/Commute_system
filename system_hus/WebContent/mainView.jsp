<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.CommuteDTO"%>

<%
CommuteDTO pageDTO = new CommuteDTO();
pageDTO = (CommuteDTO)request.getAttribute("mainDTO");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>출퇴근 기록 시스템</title>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
				
					<span class="login100-form-title p-b-53">
						Commute Check
					</span>

<%if (pageDTO==null) { %>
<form name = "mainForm" action = "check" method = "get">
	<div class="p-t-20 p-b-9">
		<span class="txt1">ID
		</span>
	</div>
	<div class="wrap-input100 validate-input">
		<input class="input100" type="text" name="nfcid" >
		<span class="focus-input100"></span>
	</div>
</form>
	<div class="p-t-13 p-b-9">
		<span class="txt1">Name
		</span>						
	</div>
	<div class="wrap-input100 validate-input">
		<input class="input100" type="text">
		<span class="focus-input100"></span>
	</div>
	
	<div class="p-t-13 p-b-9">
		<span class="txt1">Time
		</span>						
	</div>
	<div class="wrap-input100 validate-input">
		<input class="input100" type="text" name = "tagTime">
		<span class="focus-input100"></span>
	</div>
	
		<br><a href="javascript:mainForm.submit()"><button class="login100-form-btn">Log In
		</button></a>


	
		<br><a href="mainView.jsp"><button class = "login100-form-btn">Main
		</button></a>					
	
	
<% } else { %>

<form name = "mainForm2" action = "check" method = "get">
	<div class="p-t-20 p-b-9">
			<span class="txt1">ID
			</span>
		</div>
		<div class="wrap-input100 validate-input">
			<input class="input100" type="text" name="nfcid" value = <%=pageDTO.getId() %>>
			<span class="focus-input100"></span>
		</div>
</form>

<div class="p-t-13 p-b-9">
	<span class="txt1">Name
	</span>						
</div>
<div class="wrap-input100 validate-input">
	<input class="input100" type="text"  value = <%=pageDTO.getWorkername() %>>
	<span class="focus-input100"></span>
</div>
	
<div class="p-t-13 p-b-9">
	<span class="txt1">Time
	</span>						
</div>
<% if(pageDTO.getIsout().equals("false")) { %>
	<div class="wrap-input100 validate-input">
		<input class="input100" type="text" name = "tagTime" value = "출근 <%=pageDTO.getComein() %>">
		<span class="focus-input100"></span>
	</div>
<% } else { %>
	<div class="wrap-input100 validate-input">
		<input class="input100" type="text" name = "tagTime" value = "퇴근 <%=pageDTO.getComeout() %>">
		<span class="focus-input100"></span>
	</div>
<% } %>
	
		<br><a href="javascript:mainForm2.submit()"><button class="login100-form-btn">Log In
		</button></a>
	

	
		<br><a href="mainView.jsp"><button class = "login100-form-btn">Main
		</button></a>					
	

<% } %>


<div class="w-full text-center p-t-55">
<span class="txt2">Copyright ⓡ Upseoyo</span>
</div>

			
	</div>
 </div>
</div>
	

	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/main.js"></script>
</body>
</html>