<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<title>Mountain List</title>
</head>
<body>
	<table border="1">
		<tr> <th>Name</th> <th>Latitude</th> <th>Longitude</th> </tr>
		<c:forEach var="mountain" items="${mountains}">
			<tr>
				<td>${mountain.name}</td>
				<td>${mountain.latitude_decimal}</td>
				<td>${mountain.longitude_decimal}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>