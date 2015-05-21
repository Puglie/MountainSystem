<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${url}" var="url">     
		<img src=${url} width="300" height="300"><p>${url}</p> 
</c:forEach>