<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<title>Mountain Research</title>
</head>
<body>
<h2>MOUNTAIN RESEARCH</h2>
<form:form method="post" action="resultView.html"  >

	<table>
	<tr>
		<td><form:label path="name">Mountain Name</form:label></td>
		<td><form:input path="name"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Research"/>
		</td>
	</tr>
	</table>
</form:form>
</body>
</html>