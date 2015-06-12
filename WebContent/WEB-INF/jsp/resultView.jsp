<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>images</title>
</head>
<body>
	<form:form method="post" action="saveImage.html">
		<input type="hidden" name="name" value="${research.name}">
		<c:forEach items="${mountain}" var="mountain">
			<img src="${mountain.smallurl}" width="214" height="138" />
			<input type="hidden" name="smallurl[]" value="${mountain.smallurl}">
			<input type="checkbox" name="url[]" value="${mountain.url}" />
		</c:forEach>
		<input type="submit" value="Save Images">
	</form:form>

</body>
</html>
