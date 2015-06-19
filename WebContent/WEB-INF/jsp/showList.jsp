<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>images</title>
<link rel="stylesheet" href="<c:url value="/jsp/css/default.css"/>" />
</head>
<body background="<c:url value="/jsp/res/montagna3.jpg"/>">
	<h1 class="mountainList">MOUNTAIN LIST</h1>
	<c:forEach items="${correctmountain}" var="mountain">
		<table>
			<tr>
				<td>
					<form action="resultView.html" id="resultView" method="post">
						<input type="hidden" name="research" value="${mountain.name}" />
						<input class="mountainList" type="submit" value="${mountain.name}"/>
					</form>
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>