<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/jsp/css/resultView.css"/>" />
<title>images</title>
</head>
<body background="<c:url value="/jsp/res/montagna3.jpg"/>">
	<div id="result">
		<h1 class="image">FOUND IMAGES</h1>
		<br>
		<br>
		<p>ZERO PHOTOS FOUND</p>
		<br>
		<br>
		<br>
		<br>
		<div class="back">
		<form:form method="get" action="mountainResearch.html">
			<input class="back" type="submit" value="Back To Research">
		</form:form>
		<form:form method="get" action="index.html">
			<input class="back" type="submit" value="Back Home">
		</form:form>
		</div>
	</div>


</body>
</html>