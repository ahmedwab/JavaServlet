<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
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
	
	
	
	<fieldset>
	<legend> Calculator</legend>
	<form action="Osap" method="POST" class="osapForm">

	
		<label for="principal"> Principal <BR /> <small>(total loan amount after studies)</small></label>
		<input type="number" step="0.01" id="principal" name="principal" value="10000"></input> <BR />
		<label for="interest"> Annual Interest Rate <BR /> </label>
		<input type="number" step="1" id="interest" name="interest" value="10"></input> <BR />
		<label for="period"> Payment Period <BR /> <small>(total number of months)</small></label>
		<input type="number" step="1" id="period" name="period" value="120"></input> <BR />
		<label for="grace"> Grace Period <BR /> <small>(Take advantage of 6 month grace period interest with your loan balance)</small></label>
		<input type="checkbox" step="1" id="grace" name="grace" ></input> <BR />
		<button action="submit" name="calculate" value="true">Submit</button>
	</form>
	</fieldset>
	<footer><img id="image" src="logo.png" alt="Lassonde logo" width="100" height="100"></footer>
	



</body>
</html>