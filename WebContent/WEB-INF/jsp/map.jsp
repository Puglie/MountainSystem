<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
html, body, #map-canvas {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1oWeCWSAsPTTAmaqeTxXaf90izHjSBgg">
	
</script>
<script type="text/javascript">
	function initialize() {

		var html =

		"<div><img width='120' height='120' src='https://cdn2.iconfinder.com/data/icons/ourea-icons/256/Mountain.png'</div>"
				+ "<br><br><br><input type='button' value='Next Photo' onclick='savePhoto()'/>";

		var infowindow = new google.maps.InfoWindow({

			content : html

		});
		var mapOptions = {
			center : {
				lat : 46.2323,
				lng : 9.0707
			},
			zoom : 8
		};
		var map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		var i = 0;
		<c:forEach var="m" items="${mountains}">
		i = i + 1;

		var icon = {
			    url: "${m.url}", // url
			    scaledSize: new google.maps.Size(50, 50), // scaled size
			    origin: new google.maps.Point(0,0), // origin
			    anchor: new google.maps.Point(0, 0) // anchor
			};
		var marker = new google.maps.Marker({
			position : {
				lat : Number("${m.mountain.latitude_decimal}")+Math.random(),
				lng : Number("${m.mountain.longitude_decimal}")+Math.random()
			},
			map : map,
			title : "${m.mountain.name}",
			icon : icon

		});

		google.maps.event.addListener(marker, 'click', function() {
			infowindow.open(map, marker);
		});
		</c:forEach>
	}

	google.maps.event.addDomListener(window, 'load', initialize);

	function savePhoto() {
		//location.href='index.jsp';
	}
</script>
</head>
<body>
	<div id="map-canvas"></div>
</body>
</html>