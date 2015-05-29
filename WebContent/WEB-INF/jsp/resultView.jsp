<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>images</title>
</head>
<body>
	<form ACTION="jspCheckBox.jsp">
		<c:forEach items="${mountain}" var="mountain">
    		<img src=${mountain.url}  width="214" height="138" /> 
    		<input type="checkbox" name="id" value=${mountain}> 
		</c:forEach>
		<input type="submit" value="Save Images">
	</form>
</body>
</html>
