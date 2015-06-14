<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/jsp/css/resultView.css"/>" />
<title>images</title>
</head>
<body>

	<form:form method="post" action="saveImage.html">
		<input type="hidden" name="name" value="${research.name}">
		<div id="view">
			<c:forEach items="${mountain}" var="mountain">
				<img src="${mountain.smallurl}" width="214" height="138" />
				<input type="hidden" name="smallurl[]" value="${mountain.smallurl}">
				<input type="checkbox" name="url[]" value="${mountain.url}" />
			</c:forEach>
		</div>
		<div id="save">
			<input type="submit" value="Save Images">
		</div>
	</form:form>
	<div id="index">
		<form:form method="get" action="index.html">
			<input type="submit" value="Back Home">
		</form:form>
	</div>

</body>
</html>
