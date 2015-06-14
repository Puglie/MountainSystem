<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>images</title>
</head>
<body>
	<c:forEach items="${correctmountain}" var="mountain">
		<table>
			<tr>
				<td>
					<form action="resultView.html" id="resultView" method="post">
						<input type="hidden" name="research" value="${mountain.name}" />
						<input type="submit" value="${mountain.name}"/>
					</form>
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>