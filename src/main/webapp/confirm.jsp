<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.tooltip {
	position: relative;
	display: inline-block;
}

.tooltip .tooltiptext {
	visibility: hidden;
	width: 120px;
	background-color: #555;
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 5px 0;
	position: absolute;
	z-index: 1;
	bottom: 125%;
	left: 50%;
	margin-left: -60px;
	opacity: 0;
	transition: opacity 1s;
}

.tooltip .tooltiptext::after {
	content: "";
	position: absolute;
	top: 100%;
	left: 50%;
	margin-left: -5px;
	border-width: 5px;
	border-style: solid;
	border-color: #555 transparent transparent transparent;
}

.tooltip:hover .tooltiptext {
	visibility: visible;
	opacity: 1;
}
</style>
<script type="text/javascript">
	function checkEmail() {
		//alert("hello");
		var email = document.getElementById('email').value;
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		if (!filter.test(email)) {
			alert('Please provide a valid email address');
			return false;
		}
		else{
			//alert("hai");
			return true;
		}
		
	}
</script>
</head>
<center>
	<body style='background-color: #d3d3d3;'>
		<h1>Please Enter your details</h1>
		<br>
		<br>
		<form action="confirmServlet" onsubmit="return checkEmail()" method="get">
			<div class="tooltip">
				Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
					type="text" name="name"  required> <span class="tooltiptext">Enter
					user name</span>
			</div>
			<br>
			<br>
			<div class="tooltip">
				Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
					type="password" name="password" required> <span class="tooltiptext">Enter
					Password</span>
			</div>
			<br> <br>
			<div class="tooltip">
				confirm Password&nbsp;&nbsp;&nbsp;&nbsp;:<input type="password" name="password"  required> 
				<span class="tooltiptext">Confirm password</span>
			</div>
			<br> <br>
			<div class="tooltip">
				E-mail
				address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input
					type="text" name="email"  id="email"  required> <span class="tooltiptext">Enter
					E-mail id</span>
			</div>
			<br>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="submit" value="signup">
		</form>
	</body>
</center>
</html>