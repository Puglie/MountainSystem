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

<link rel="stylesheet" href="<c:url value="/jsp/css/map.css"/>">

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
	
	
	function getWidth(url){
		var img = new Image();
		img.src = url;
		return img.width;
	}
	function getHeight(url){
		var img = new Image();
		img.src = url;
		return img.height;
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
	<div id="map-canvas"></div>
	<div id="back">
		<form:form method="get" action="index.html">
			<input type="submit" value="Back Home">
		</form:form>
	</div>
	
	<div class="row">
		<div class="style-select">
			<p style="margin: 24px 0 12px; color: #444;">Demo gallery style</p>

			<div class="radio">
				<input type="radio" name="gallery-style" value="all"
					id="radio-all-controls" checked /> <label for="radio-all-controls">

					All controls<br /> <span>caption, share and fullscreen
						buttons, tap to toggle controls</span>
				</label>
			</div>

			<div class="radio">
				<input type="radio" name="gallery-style" value="minimal"
					id="radio-minimal-black" /> <label for="radio-minimal-black">

					Minimal<br /> <span>no caption, transparent background, tap
						to close</span>
				</label>
			</div>

		</div>
	</div>

	<div class="navigation">
		<div class="row row--nav">
			<a href="documentation/getting-started.html">Documentation</a>
			&middot; <a href="https://github.com/dimsemenov/photoswipe">GitHub</a>
			&middot; <a class="twitter-nav-link"
				href="http://twitter.com/photoswipe"><span>Twitter</span></a>
		</div>
	</div>

	<div class="section section--first">



		<div class="row title-block">
			<h2>Touch gestures</h2>
			<p>All basic gestures are supported: flick to the next or
				previous image, spread to zoom in, drag to pan, pinch to zoom out or
				close, tap to toggle the controls, double-tap to zoom.*</p>
		</div>

		<div class="row row--wide">

			<div class="col-50">
				<img class="col-img" src="test/spread.jpg">
				<figure class="img-desc">
					<h3>Spread to zoom image</h3>
					<p>PhotoSwipe is the first open-source gallery to support
						JavaScript-based image zooming. Even if a browser’s native zooming
						has been disabled, image zooming will still work.</p>
				</figure>
			</div>

			<div class="col-50">
				<img class="col-img" src="test/pinch.jpg">
				<figure class="img-desc">
					<h3>Pinch to close gallery</h3>
					<p>The gallery’s background will gradually fade out as the user
						zooms out. When the gesture is complete, the gallery will close.</p>
				</figure>
			</div>

		</div>


		<div class="row row--wide">

			<div class="col-50">
				<img class="col-img" src="test/vertical-swipe.jpg">
				<figure class="img-desc">
					<h3>Vertical swipe to close gallery</h3>
					<p>Gesture is added because close button in top right corner
						might be hard to reach on tall mobile devices while holding in one
						hand.</p>
				</figure>
			</div>

			<div class="col-50">
				<img class="col-img" src="test/horizontal-swipe.jpg">
				<figure class="img-desc">
					<h3>Horizontal swipe to switch items</h3>
					<p>Images can be changed even when current slide is zoomed.
						Swiping is not blocked during the transition.</p>
				</figure>
			</div>

		</div>



		<div class="row">
			<p>*You can assign your own actions for tap and double-tap
				gestures.</p>
		</div>

	</div>



	<div class="section">

		<div class="row title-block">
			<h2>Browser history API</h2>
			<p>PhotoSwipe manipulates the browser’s history so that the user
				can link to each gallery item and close the gallery via the “back”
				button. The initial URL is restored when the gallery is closed.</p>
		</div>

		<div class="row">
			<img src="test/history.png">
		</div>

		<div class="row row--history">
			<figure class="col-50 history-text-left">
				<h3
					style="font-wight: bold; border-left: 5px solid #b9bfe8; padding-left: 5px; margin-left: -10px;">“Back”
					button to close gallery</h3>
				<p>PhotoSwipe adds a history record when the gallery is opened,
					which allows the user to close it via the browser’s “back” button.</p>
			</figure>
			<figure class="col-50 history-text-right">
				<h3
					style="border-left: 5px solid #fcf5a3; padding-left: 5px; margin-left: -10px;">Unique
					URL for each gallery item</h3>
				<p>
					Users can share and link to each image. The hash suffix gets two
					extra parameters:
					<code>gid</code>
					(the gallery index) and
					<code>pid</code>
					(the picture index).
				</p>
			</figure>
		</div>

		<div class="row">
			<p>This feature comes as a module. You can exclude it from the
				build entirely, or fork it to fit the requirements of your product’s
				URL structure.</p>
		</div>

	</div>




	<div class="section">

		<div class="row title-block">
			<h2>Loading and displaying images</h2>
			<p>PhotoSwipe creates the illusion of faster loading.</p>
		</div>

		<div class="row">
			<div class="col-50">
				<h3>Images display progressively as data arrives</h3>
				<p>Photos are displayed before they fully load. This feature is
					disabled on touch devices because it could cause swipe transitions
					to lag.</p>
			</div>
			<div class="col-50">
				<h3>Low-resolution images are instantly displayed and then
					stretched to full size</h3>
				<p>Pass the source of a thumbnail to PhotoSwipe, which will
					display it instantly and load the full-sized image over top.</p>
			</div>
		</div>

		<div class="row">
			<div class="col-50">
				<h3>Smart loading indicator</h3>
				<p>Just a stretched thumbnail or gray placeholder is used, with
					the full image progressively loaded over top.</p>
				<p
					style="padding-left: 60px; background: url(test/luke45.png) 0 0 no-repeat;">
					<a href="http://www.lukew.com/ff/entry.asp?1797">Luke
						Wroblewski on spinners</a>:<br> “It’s like watching the clock
					tick down&mdash;when you do, time seems to go slower.”
				</p>
				<p>If at least a tiny part of the image has not loaded for 1
					second or a browser does not support progressive loading, a
					spinning progress indicator smoothly fades in. A delay is added to
					avoid blinking in case the image was cached or the user has a fast
					connection.</p>
			</div>
			<div class="col-50">
				<h3>Zoom animation</h3>
				<p>The zoom transition to open the gallery wasn’t added merely
					for a fancy effect. The image starts loading before the animation,
					so users on fast connections might not even notice that something
					was loading.</p>
			</div>
		</div>


		<div class="row">
			<div class="col-50">
				<h3>Smart lazy-loading</h3>
				<p>PhotoSwipe loads neighboring images based on the direction of
					the user’s movement. You can control how many images to preload
					through the API.</p>
			</div>
			<div class="col-50">
				<h3>Responsive images support</h3>
				<p>
					Because images in a gallery are loaded dynamically, you can pass
					the source that is appropriate to the user’s window size and DPI.<br>
					<a
						href="http://photoswipe.com/documentation/responsive-images.html">More
						about responsive images &rarr;</a>
				</p>
			</div>
		</div>

		<div class="row">
			<div class="col-50">
				<h3>Semantic and SEO friendly markup</h3>
				<p>
					PhotoSwipe allows to define absolutely any HTML text for gallery.
					You can use Schema.org structured data markup for ImageGallery.<br>
					<a href="http://photoswipe.com/documentation/seo.html">More
						about search-optimized gallery &rarr;</a>
				</p>
			</div>
		</div>

		<!-- 
		// TOOD: make a video
		<div class="row row--wide row--video">
			<div class="video">
				<div class="video__container">
					<iframe width="1280" height="720" src="//www.youtube.com/embed/b0EHul-Cy58?rel=0&amp;vq=hd720&amp;showinfo=0&amp;modestbranding=0" frameborder="0" ></iframe>
				</div>
				<p class="video-desc">In this video, a thumbnail that is 80 pixels wide is stretched to a viewport of about 800 pixels. If you increased the size of the thumbnail to, say, 160 pixels, the initial image would look much less blurry.<br>A connection speed of 720 Kbps is emulated.</p>
			</div>
		</div> -->

	</div>


	<div class="section">
		<div class="row title-block">
			<h2>Zoom on the desktop, too</h2>
			<p>PhotoSwipe emulates the default behavior of the browser’s
				image viewer.</p>
		</div>
		<div class="row">
			<div class="col-50">
				<h3>Click to zoom image</h3>
				<p>If an image is smaller than the viewport, PhotoSwipe will
					show a zoom cursor over the image and zoom icon in the top bar.</p>
			</div>
			<div class="col-50">
				<h3>
					Pan via the wheel or <span class="highlight">trackpad</span> or by
					dragging
				</h3>
				<p>When an image is zoomed in, the user can pan across it via
					the mouse wheel or the trackpad or by dragging it. And if you need
					to extend this functionality, you can use the API, of course.</p>
			</div>
		</div>
	</div>





	<div class="section">

		<div class="row title-block">
			<h2>User interface</h2>
			<p>
				The UI is entirely separated from the core of the script. If you’re
				making a custom interface for a gallery, you would write it <span
					class="highlight">instead of the default interface, not on
					top of it</span>. Default PhotoSwipe UI is responsive &ndash; optimized
				for desktop, tablets and mobile devices.
			</p>
		</div>

		<div class="row row--wide">
			<div class="col-50">
				<img class="col-img" src="test/high-dpi-icons.png">
				<figure class="img-desc">
					<h3>Pixel-perfect vector icons</h3>
					<p>
						SVG sprites are used for high-DPI screens, like Retina displays.
						PNG is used for regular (
						<code>@1x</code>
						) displays.
					</p>
				</figure>
			</div>
			<div class="col-50">
				<img class="col-img" src="test/share.png">
				<figure class="img-desc">
					<h3>Social sharing</h3>
					<p>The default UI has a button that pops open a window with
						sharing links. The default links are for Facebook, Twitter and
						Pinterest, but you can, of course, add more via the API.</p>
				</figure>
			</div>
		</div>

		<div class="row row--wide">
			<div class="col-50">
				<img class="col-img" src="test/fullscreen-laptop.jpg">
				<figure class="img-desc">
					<h3>Native HTML5 full-screen</h3>
					<p>A full-screen image-viewing experience is supported,
						including on mobile devices with native full-screen support.</p>
				</figure>
			</div>
			<div class="col-50">
				<img class="col-img" src="test/keyboard.jpg">
				<figure class="img-desc">
					<h3>Keyboard access</h3>
					<p>Galleries can be navigated via the arrow keys and closed via
						the “Escape” key. The controls (including the sharing buttons) can
						be focused on with the “Tab” button.</p>
				</figure>
			</div>
		</div>

		<div class="row">
			<h3>Also</h3>
			<p>
				To draw the most attention to the photos, <span class="highlight">controls
					are hidden when the mouse hasn’t moved</span> for 2 seconds or when the
				mouse moves off the window.
			</p>
			<p>
				PhotoSwipe <span class="highlight">can be closed simply by
					scrolling the page</span> (on non-touch devices), thus avoiding any extra
				movement of the mouse.
			</p>
			<p>The background can be set to any color and transparency level.</p>
			<p>The vertical margins between images can be controlled through
				an API.</p>
			<p>
				PhotoSwipe is treated as a modal dialog, so
				<code>aria</code>
				attributes are added, and the gallery gains focus when it is open.
			</p>
		</div>

	</div>


	<div class="section">
		<div class="row title-block">
			<h2>Problems solved by PhotoSwipe</h2>
			<p>Images are displayed at their highest possible size and are
				not limited by the width of the column or wrapper. Each image is
				isolated from the other content and fits the viewport vertically, so
				that the user can focus on it. If an image is larger than the
				viewport, it can be zoomed (which most galleries are unable to do).</p>
		</div>

		<div class="row">

			<h3>Detail is preserved in responsive images</h3>
			<p>Let’s say the viewport on a user’s phone is 500 pixels wide
				and your uncompressed image is 1200 pixels wide. You wouldn’t want
				to serve such a large image on mobile, so perhaps you’d resize it to
				500 pixels. But if the image has important details and the user
				zooms it, it will look pixelated. With PhotoSwipe, when the user
				taps the small image (500 pixels), the large one will load (1200
				pixels), thus preserving all of the detail.</p>

			<h3>Compared to an inline horizontal JavaScript gallery</h3>
			<p>PhotoSwipe will not slow the page from loading, because you
				can defer loading the gallery’s JavaScript file or even load it
				after the user has clicked the “Open gallery” button.</p>

			<h3>Compared to a list of images, one after another</h3>
			<p>PhotoSwipe saves users’ bandwidth because it doesn’t load all
				images at once &mdash; just nearby images according to the user’s
				direction of movement. Also, it occupies less space on the page, and
				you can directly link to individual images in a gallery.</p>

		</div>



		<div class="row">
			<h3>PhotoSwipe might not be a good idea if…</h3>
			<ul>
				<li>… your images are small or low quality or if there would be
					no point in zooming or isolating them. Use a simple list of images
					or a horizontal scroller instead.</li>
				<li>… your images are very large and should never be scaled
					(for example tall infographics with text). Simply link to image
					file, or create separate HTML page just with image.</li>
				<li>… your captions are long or more important than the images
					themselves. Consider using a simple list of images, with captions
					below or beside them. And when the user clicks on an image for
					which a larger version is available, then you could open
					PhotoSwipe, without the caption, to draw attention to the image
					itself.</li>
				<li>… your website’s layout is not fluid. On a non-responsive
					website on a small screen, PhotoSwipe’s controls would look tiny
					because the page will be zoomed out. Consider using Magnific Popup
					instead.</li>
			</ul>
		</div>

	</div>



	<div class="section section--developers">

		<div class="row title-block row--large">
			<h2>Technical specifications</h2>
			<p>PhotoSwipe is built for performance and integration with your
				product needs.</p>
		</div>

		<div class="row">
			<h3>Modules and size breakdown</h3>
			<p>
				PhotoSwipe is broken down into modules. All of them, except the
				controller, events &amp; gestures and framework bridge, may be
				excluded from your build to reduce the size. You’re free to edit any
				of these to fit your requirements. Built with <a
					href="http://gruntjs.com/"><img src="test/grunt-logo.png"
					style="transform: translateY(3px); margin-right: 4px;">Grunt</a>,
				linted with <a href="http://www.jshint.com/">JSHint</a>.
			</p>
		</div>

		<div class="row">
			<div class="size-chart">
				<div style="width: 24%; background: #EDEDDF; color: #333;">
					3.6 KB
					<!-- Core -->
				</div>
				<div style="width: 22%; background: #4ECDC4; color: #333;">
					3.2
					<!-- UI -->
				</div>
				<div style="width: 19%; background: #3BBDEC; color: #333;">
					2.6
					<!-- Events & gestures -->
				</div>
				<div style="width: 13%; background: #C7F464; color: #333;">
					1.9
					<!-- Controller -->
				</div>
				<div style="width: 8%; background: #FF6B6B">
					<!-- Framework bridge -->
				</div>
				<div style="width: 7%; background: #C44D58">
					<!-- History -->
				</div>
				<div style="width: 3%; background: #513E30">
					<!-- Desktop zoom -->
				</div>
				<div style="width: 2%; background: #556270">
					<!-- Tap -->
				</div>

			</div>
		</div>

		<div class="row row--modules row ">
			<div class="col-50">
				<ul>
					<li><span style="border-color: #EDEDDF;">Core</span><br>basic
						functionality, like switching items or zooming</li>
					<li><span style="border-color: #4ECDC4;">User interface</span><br>all
						buttons and their actions, captions, etc. (the interface is built
						exclusively with public methods &mdash; an example of what the API
						can do)</li>
					<li><span style="border-color: #3BBDEC;">Events &amp;
							gestures</span><br>touch, pointer, mouse events and gestures</li>
					<li><span style="border-color: #C7F464;">Controller</span><br>managing
						gallery items; adding content to the gallery; returning the sizes
						of images</li>

				</ul>
			</div>
			<div class="col-50">
				<ul>
					<li><span style="border-color: #FF6B6B;">Framework
							bridge</span><br>generic functions, like <code>addClass</code> and
						<code>addEventListener</code>; feature detection</li>
					<li><span style="border-color: #C44D58;">History</span><br>changes
						URL’s hash suffix (<code>#</code>); enables browser’s “back”
						button to close gallery</li>
					<li><span style="border-color: #513E30;">Desktop zoom</span><br>clicking
						to zoom; panning with trackpad or mouse wheel.</li>
					<li><span style="border-color: #556270;">Tap</span><br>firing
						tap and double-tap events</li>
				</ul>
			</div>
		</div>

		<div class="row row--large ">
			<p>
				The total size of core modules (Gzip’d) is about 11 KB + 3 KB UI,
				which is about <span class="highlight">three times lighter
					than jQuery 1.11</span> and only <span style="white-space: nowrap;">2
					KB</span> heavier than FancyBox.<br>The CSS comes out to 0.5 KB core
				+ 1.5 KB skin + single SVG or PNG icons sprite. Uses <a
					href="http://sass-lang.com/">Sass</a> preprocessor.
			</p>
			<p></p>
		</div>

		<div class="row row--large">
			<div class="col-50">
				<h3>Animation</h3>
				<ul class="text-list">
					<li><code>RequestAnimationFrame</code> is used wherever
						possible.</li>
					<li>Only the <code>transform</code> and <code>opacity</code>
						properties are animated. Almost no paints occur during animation,
						making transitions as smooth as possible.
					</li>
					<li>The frames-per-second (FPS) rate largely depends on the
						sizes of the images and the device itself. For example,
						landscape-oriented images that are 1000 pixels wide and displayed
						in portrait mode on an iPhone 4s running iOS 8 will animate
						smoothly at 60 FPS. If the images were 1400 pixels wide, then the
						FPS rate would drop noticeably.</li>
				</ul>
			</div>

			<div class="col-50">
				<h3>Memory</h3>
				<ul class="text-list">
					<li>PhotoSwipe keeps only three images in the DOM at once,
						because each “slide” is a composited layer, which consumes quite a
						lot of memory.</li>
					<li>Almost no memory is consumed until the gallery is first
						opened.</li>
					<li>The script has been tested for memory leaks. Navigating
						images back and forth and creating or deleting a gallery doesn’t
						leave a trace in memory.</li>
				</ul>
			</div>
		</div>


		<div class="row">
			<h3>Supported browsers and devices</h3>
			<p>The script has been developed to work on every device, which
				means that basic functionality should be supported everywhere:</p>
			<ul class="text-list">
				<li>desktop Chrome, Firefox, Safari, Opera and IE 8 and above</li>
				<li>Android 2.3.7+ (2.1 not tested yet): default browser,
					Chrome, Firefox (latest), Dolphin (latest)</li>
				<li>iOS 5+</li>
				<li>Windows Phone 7+: default browser (touch gestures are
					supported from 8+)</li>
				<li>BlackBerry OS 10+: default browser (older versions not
					tested yet)</li>
				<li>devices with multiple input methods (Surface, Chromebook
					Pixel, etc.)</li>
			</ul>
			<p>
				If you discover a problem on your device, please <a
					href="https://github.com/dimsemenov/PhotoSwipe/issues">open an
					issue on GitHub</a>, and provide as much detail as possible (OS name
				and version, browser name and version, screenshot or screencast,
				etc.).
			</p>
		</div>

		<div class="row">
			<h3>How PhotoSwipe determines whether a mouse is being used</h3>
			<p>
				If both touch and mouse input methods are detected, the script waits
				for two consecutive
				<code>mousemove</code>
				events to occur and only then applies the mouse-only features (for
				example left/right arrow buttons).
			</p>
		</div>

		<div class="row">
			<h3>How the zoom animation works for opening images</h3>
			<ol>
				<li>Once a thumbnail is clicked, its large version instantly
					starts loading.</li>
				<li>Meanwhile, PhotoSwipe creates a fixed-positioned layer with
					the duplicated thumbnail image, background, buttons and caption.
					The background and controls are styled with <code>opacity:
						0.001</code> (if it had <code>opacity: 0</code>, the paint would not
					occur in some browsers).
				</li>
				<li>A 50-millisecond timer starts. It is added to give the
					browser time to render the new layers (background, controls,
					image). Otherwise, the animation would start with a noticeable lag.
					TODO: change this delay depending on browser/os/device?</li>
				<li>Three CSS transitions start: one scales the image (<code>scale</code>
					and <code>translate</code> are animated), the second changes the
					opacity of the background, and the third changes the opacity of the
					controls.<br>By default, the transition lasts 333
					milliseconds.<br>The background is a separate element, because
					animating <code>opacity</code> looks much smoother than animating
					an RGBa <code>background-color</code>.
				</li>
				<li>Once the transition is complete, the large image is added
					on top of the stretched thumbnail, whether or not it’s fully
					loaded.</li>
				<li>To make the swipe transition smooth, the two neighboring
					slides are readied at the sides of the viewport.</li>
				<li>If lazy-loading is enabled on more than two neighboring
					images, then those images would start to load now, too.</li>
			</ol>
		</div>

		<div class="row">
			<h3>Are PhotoSwipe images crawlable by search engines?</h3>
			<p>PhotoSwipe does not force any HTML markup into the gallery
				&mdash; you have full control. Images will be crawlable if you'll
				have list of links to large images or the images themselves.</p>
		</div>

	</div>




	<div class="section">

		<div class="row row--large">
			<h2>License and price</h2>
			<p>
				The script is free to use for personal and commercial projects. It
				falls under the MIT license with one exception: Do not create a
				public WordPress plugin based on it, as I will develop it.<br>
				<span style="font-size: 14px; line-height: 20px;">If you need
					to use it for a public WordPress plugin right now, please <a
					href="http://dimsemenov.com/">ask me</a> by email first. Thanks!
				</span>
			</p>
			<p>Attribution is not required, but much appreciated, especially
				if you're making product for developers.</p>
		</div>

		<div class="row row--large">
			<h2>About</h2>
			<p>
				The script was created by <a href="http://www.codecomputerlove.com/"
					style="white-space: nowrap;">Code Computerlove</a>, a digital
				agency in Manchester. In March 2014, it <a
					href="https://twitter.com/PhotoSwipe/status/444134042787930113">passed</a>
				on development to <a href="http://dimsemenov.com/">Dmitry
					Semenov</a>.<br>The new version of PhotoSwipe (4.0) was entirely
				rewritten, supports a much longer list of devices, and contains a
				lot of performance and UX improvements. Built-in support for jQuery
				Mobile has been dropped.
			</p>
		</div>

		<div class="row row--large">
			<div class="share-buttons" style="text-align: center">
				<h2>Please spread the word if you find the script useful</h2>
				<div id="buttons-row">
					<a id="tweet" rel="nofollow" target="_blank"
						href="https://twitter.com/intent/tweet?text=New%20PhotoSwipe&amp;url=http://photoswipe.com">Tweet!</a>
					<a id="like" rel="nofollow" target="_blank"
						href="http://www.facebook.com/sharer.php?u=http://photoswipe.com">Like!</a>
					<a id="gplus" rel="nofollow" target="_blank"
						href="https://plus.google.com/share?url=http://photoswipe.com">+1</a>
				</div>
			</div>
		</div>



		<div class="row row--footer">

			<p>
				<span title="Coded">&lt;/&gt;</span> with <span title="love">&lt;3</span>
				in <a class="ukraine-flag"
					href="http://en.wikipedia.org/wiki/Ukraine" title="Ukraine"></a> by
				<a href="http://twitter.com/dimsemenov">@dimsemenov</a>
			</p>

		</div>



	</div>







	<div id="gallery" class="pswp" tabindex="-1" role="dialog"
		aria-hidden="false">
		<div class="pswp__bg"></div>

		<div class="pswp__scroll-wrap">

			<div class="pswp__container">
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
			</div>

			<div class="pswp__ui pswp__ui--hidden">

				<div class="pswp__top-bar">

					<div class="pswp__counter"></div>

					<button class="pswp__button pswp__button--close"
						title="Close (Esc)"></button>

					<button class="pswp__button pswp__button--share" title="Share"></button>

					<button class="pswp__button pswp__button--fs"
						title="Toggle fullscreen"></button>

					<button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>

					<div class="pswp__preloader">
						<div class="pswp__preloader__icn">
							<div class="pswp__preloader__cut">
								<div class="pswp__preloader__donut"></div>
							</div>
						</div>
					</div>
				</div>


				<!-- <div class="pswp__loading-indicator"><div class="pswp__loading-indicator__line"></div></div> -->

				<div
					class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
					<div class="pswp__share-tooltip">
						<!-- <a href="#" class="pswp__share--facebook"></a>
					<a href="#" class="pswp__share--twitter"></a>
					<a href="#" class="pswp__share--pinterest"></a>
					<a href="#" download class="pswp__share--download"></a> -->
					</div>
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