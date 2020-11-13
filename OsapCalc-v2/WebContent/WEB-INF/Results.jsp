<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/res/mc.css" type="text/css" title="cse4413" media="screen, print" />
</head>
<body>
	<header>
	Student Loan Application
	</header>
	<nav>
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
		
		
		</ul>
	
	</nav>
	
	
	<form action="" method="POST" class="resultForm">
	<fieldset>
	<legend>Calculator</legend>
		<strong>Grace Period Interest:$     </strong> ${graceInterest}<br/>
		<strong>Monthly payments:$   </strong> ${payment}<br/>
		<p>Calculations are based on a fixed rate based on Prime Rate + 5%</p><br>
		<button action="submit" name="restart" value="true">Re-compute</button>
		</fieldset>
	</form>
		<footer><img id="image" src="logo.png" alt="Lassonde logo" width="100" height="100" /></footer>
	
</body>
</html>