<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>images</title>
</head>
<body>
	<!--<c:forEach items="${url}" var="url" varStatus="status">
		<img src=${url } width="300" height="300">
		<p>${url}</p>
	</c:forEach>-->
	<c:forEach items="${url}" var="url">
    <img src=${url}  width="214" height="138" />
</c:forEach>
</body>
</html>
