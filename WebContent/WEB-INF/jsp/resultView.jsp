<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>images</title>
</head>
<body>
	<form:form method="post" action="saveImage.html" > 
		<c:forEach items="${mountain}" var="mountain">
    		<img src="${mountain.url}"  width="214" height="138" /> 
    	 	<input type="checkbox" name="id" ${mountain.isSelected}/> 
		</c:forEach> 
	 	<input type="submit" value="Save Images"> 
	 </form:form>
	
</body>
</html>
