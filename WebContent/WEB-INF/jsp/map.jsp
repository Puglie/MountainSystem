<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="<c:url value="/jsp/css/photoswipe.css"/>" />

<link rel="stylesheet"
	href="<c:url value="/jsp/default/default-skin.css"/>">

<!-- Core JS file -->
<script src="<c:url value="/jsp/js/photoswipe.min.js"/>"></script>

<!-- UI JS file -->
<script src="<c:url value="/jsp/js/photoswipe-ui-default.min.js"/>"></script>
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
		<c:forEach var="m" items="${mountainMatrix}">
		i = i + 1;

		var icon = {
			url : "http://screenshot.it.sftcdn.net/blog/it/2012/12/Camera-Launcher-for-Nexus-72.png", // url
			scaledSize : new google.maps.Size(50, 50), // scaled size
			origin : new google.maps.Point(0, 0), // origin
			anchor : new google.maps.Point(0, 0)
		// anchor
		};
		var marker = new google.maps.Marker({
			position : {
				lat : Number("${m.get(0).mountain.latitude_decimal}"),
				lng : Number("${m.get(0).mountain.longitude_decimal}")
			},
			map : map,
			title : "${m.get(0).mountain.name}",
			icon : icon

		});

		google.maps.event.addListener(marker, 'click', function() {
			var pswpElement = document.querySelectorAll('.pswp')[0];


			var items = [ 
			<c:forEach var="m1" items="${m}">
				{
				src : '${m1.getUrl()}',
				w : 600,
				h : 400,
				title: '${m1.getMountain().getName()}'
				},
			</c:forEach>	
			];

			

			// define options (if needed)
			var options = {
				// optionName: 'option value'
				// for example:
				index : 0
			// start at first slide
			};

			// Initializes and opens PhotoSwipe
			var gallery = new PhotoSwipe(pswpElement, PhotoSwipeUI_Default,
					items, options);
			gallery.init();
		});
		</c:forEach>
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div id="map-canvas"></div>
	<!-- Root element of PhotoSwipe. Must have class pswp. -->
	<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">

		<!-- Background of PhotoSwipe. 
         It's a separate element as animating opacity is faster than rgba(). -->
		<div class="pswp__bg"></div>

		<!-- Slides wrapper with overflow:hidden. -->
		<div class="pswp__scroll-wrap">

			<!-- Container that holds slides. 
            PhotoSwipe keeps only 3 of them in the DOM to save memory.
            Don't modify these 3 pswp__item elements, data is added later on. -->
			<div class="pswp__container">
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
			</div>

			<!-- Default (PhotoSwipeUI_Default) interface on top of sliding area. Can be changed. -->
			<div class="pswp__ui pswp__ui--hidden">

				<div class="pswp__top-bar">

					<!--  Controls are self-explanatory. Order can be changed. -->

					<div class="pswp__counter"></div>

					<button class="pswp__button pswp__button--close"
						title="Close (Esc)"></button>

					<button class="pswp__button pswp__button--fs"
						title="Toggle fullscreen"></button>

					<button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>

					<!-- Preloader demo http://codepen.io/dimsemenov/pen/yyBWoR -->
					<!-- element will get class pswp__preloader--active when preloader is running -->
					<div class="pswp__preloader">
						<div class="pswp__preloader__icn">
							<div class="pswp__preloader__cut">
								<div class="pswp__preloader__donut"></div>
							</div>
						</div>
					</div>
				</div>

				<div
					class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
					<div class="pswp__share-tooltip"></div>
				</div>

				<button class="pswp__button pswp__button--arrow--left"
					title="Previous (arrow left)"></button>

				<button class="pswp__button pswp__button--arrow--right"
					title="Next (arrow right)"></button>

				<div class="pswp__caption">
					<div class="pswp__caption__center"></div>
				</div>

			</div>

		</div>

	</div>
</body>
</html>