<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Mountain Research</title>
<link rel="stylesheet" href="<c:url value="/jsp/css/default.css"/>" />
</head>
<body background="<c:url value="/jsp/res/montagna3.jpg"/>">
	<div class="generalResearch">
		<h1 class="formResearch">MOUNTAIN RESEARCH</h1>
		<br>
		<br>
		<br>
		<div class="research">
			<form:form class="formResearch" method="post"
				action="resultView.html">

				<table class="formResearch">
					<tr>
						<td><form:label class="formResearch" path="name">MOUNTAIN NAME</form:label></td>
						<td><form:input class="formResearch" path="name" /></td>
					</tr>
					<tr>
						<td colspan="2"><br>
						<br>
						<br>
						<input class="buttonResearch" type="submit" value="Research" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="backFromResearch">
			<form:form method="post" action="index.html">
				<input class="buttonResearch" type="submit" value="Home" />
			</form:form>
		</div>

	</div>
</body>


</html>