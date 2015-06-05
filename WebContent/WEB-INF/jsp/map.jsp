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
		
		var marker = new google.maps.Marker({
		      position: {
					lat : 46.2323,
					lng : 9.0707
				},
		      map: map,
   		 title: 'FirstMarker',
   		 icon: 'http://maps.google.com/mapfiles/kml/pal3/icon55.png'
   		
			});
		
		google.maps.event.addListener(marker, 'click', function() {
		    infowindow.open(map,marker);
		  });
	}
	google.maps.event.addDomListener(window, 'load', initialize);
	
	function savePhoto(){
		//location.href='index.jsp';
	}
</script>
</head>
<body>
	<div id="map-canvas"></div>
</body>
</html>