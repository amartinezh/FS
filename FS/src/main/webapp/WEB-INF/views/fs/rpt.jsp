<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

<title>Finalcial Statement</title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="../resources/css/font-awesome.min.css"/>">

<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/smartadmin-production.min.css" />">
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/smartadmin-skins.min.css" />">

<!-- SmartAdmin RTL Support is under construction
			 This RTL CSS will be released in version 1.5
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> -->

<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/demo.min.css" />">

<!-- FAVICONS -->
<link rel="shortcut icon"
	href="<c:url value="/resources/img/favicon/favicon.ico" />"
	type="image/x-icon">
<link rel="icon"
	href="<c:url value="/resources/img/favicon/favicon.ico" />"
	type="image/x-icon">

<!-- GOOGLE FONT -->
<!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700"> -->
<link rel="stylesheet" href="<c:url value="/resources/js/j/css.css"/>">

<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
<link rel="apple-touch-icon"
	href="<c:url value="/resources/img/splash/sptouch-icon-iphone.png" />">
<link rel="apple-touch-icon" sizes="76x76"
	href="<c:url value="/resources/img/splash/touch-icon-ipad.png" />">
<link rel="apple-touch-icon" sizes="120x120"
	href="<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />">
<link rel="apple-touch-icon" sizes="152x152"
	href="<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />">

<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!-- Startup image for web apps -->
<link rel="apple-touch-startup-image"
	href="<c:url value="/resources/img/splash/ipad-landscape.png" />"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
<link rel="apple-touch-startup-image"
	href="<c:url value="/resources/img/splash/ipad-portrait.png" />"
	media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image"
	href="<c:url value="/resources/img/splash/iphone.png" />"
	media="screen and (max-device-width: 320px)">

<style type="text/css">
	tr:last-child {
		color: #ff0000;
		font-weight: bold;
	}
	
	.transp-block {
	    background: #000 url(watermark.jpg) no-repeat;
	    width: 575px;
	    height: 335px;
	}
	img.transparent {
	    filter:alpha(opacity=75);
	    opacity:.75;
	}

	#tbl tr td {
	    height: 1px;
	    padding: 1px;
	}	

</style>

</head>
<!--  <body oncontextmenu="return false">  -->

<body>
	<!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->

	<!-- HEADER -->
	
	<!-- ---------------------------------------------------- -->
	<!-- ---------------------------------------------------- -->
	<header id="header">
		
		<div class="pull-right">
		<a href="javascript:history.back(1)" class="btn btn-labeled btn-danger btn-sm" > 
			<span class="btn-label">
				<i class="fa fa-sign-out">
				</i>
			</span>
			Back
		</a>
		</div>
		<!-- end pulled right: nav area -->
	</header>
	
	<!-- ---------------------------------------------------- -->
	<!-- ---------------------------------------------------- -->

	<!-- END HEADER -->

	<!-- MAIN CONTENT -->
	<div id="content">

		<!-- widget grid -->
		<section id="widget-grid">

			<!-- row -->
			<div class="row">

				<!-- NEW WIDGET START -->
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div style="margin: 0 auto; display: block; position: absolute; right: 3%;">
						<p style="font-family: 'Arial Black', 'Arial Bold', Gadget, sans-serif;	font-size: 60px; font-style: normal; font-variant: normal; font-weight: bold; line-height: 44px; color:#ffffe6">
						Financial Statements</p>
					</div>
					<!-- Widget ID (each widget will need unique ID)-->
					<div class="jarviswidget jarviswidget-color-darken far"
						id="wid-id-0" data-widget-editbutton="false">
						<!-- widget div-->
						<div>
							<!-- widget content -->
							<div class="widget-body no-padding">
								<h1><strong>${tit}</strong></h1>
								<div id="dialog-message" title="Drill Down">
									<div id="opc" width="1500" height="100" style="background-color:#ffffff;">
										
									</div>
								</div>
							</div>
							
							<!-- end widget content -->
						</div>
						<!-- end widget div -->

					</div>
					<!-- end widget -->

				</article>
				<!-- WIDGET END -->

			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
					<h1 class="page-title txt-color-blueDark">
						<i class="fa fa-list-alt fa-fw "></i>
						<span><c:out value="${navegacion}" />
						</span>
					</h1>
				</div>
			</div>
			<c:set var="color" value="success"/>
			<table style=" white-space: pre" id="tbl" class="table table-bordered" width="100%">
				<thead>
					<tr>
					</tr>
					<tr>
						<th style="text-align: center; color: blue;"></th>
						<th style="text-align: center; color: blue;">ACTUAL</th>
						<th style="text-align: center; color: blue;">BUDGET</th>
						<th style="text-align: center; color: blue;">VARIATION</th>
						<th style="text-align: center; color: blue;">LAST YEAR</th>
						<th style="text-align: center; color: blue;">VARIATION</th>
						<th style="text-align: center; color: blue;">LAST MONTH</th>
						<th style="text-align: center; color: blue;">VARIATION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pgm}" var="b" varStatus="loopCounter">
						<c:choose>
						    <c:when test="${b.cdesc == 'LINEA'}">
						        <tr style="background-color: #D3D3D3">
						        <td >&nbsp</td>
						    </c:when>    
						    <c:otherwise>
						        
						        <c:choose>
								    <c:when test="${b.cdesc == 'DOBLE LINEA'}">
								        <tr style="background-color: #FF5733 ">
								        <td >&nbsp</td>
								    </c:when>    
								    <c:otherwise>
								        <tr class="${color}">
								        <td >${ b.cdesc } &nbsp</td>
								    </c:otherwise>
								</c:choose>
						        
						    </c:otherwise>
						</c:choose>
							<td ><c:if test="${b.cvalm != '.00'}"><fmt:formatNumber pattern="###,###,###" value="${b.cvalm}" type="number" /></c:if></td>
							<td ><c:if test="${b.cvalp != '.00'}"><fmt:formatNumber pattern="###,###,###" value="${b.cvalp}" type="number" /></c:if></td>
							<td ><c:if test="${b.cvar1 != '.00'}"><fmt:formatNumber pattern="###,###,###" value="${b.cvar1}" type="number" /></c:if></td>
							<td ><c:if test="${b.cvalmya != '.00'}"><fmt:formatNumber pattern="###,###,###" value="${b.cvalmya}" type="number" /></c:if></td>
							<td ><c:if test="${b.cvar2 != '.00'}"><fmt:formatNumber pattern="###,###,###" value="${b.cvar2}" type="number" /></c:if></td>
							<td ><c:if test="${b.cvalma != '.00'}"><fmt:formatNumber pattern="###,###,###" value="${b.cvalma}" type="number" /></c:if></td>
							<td ><c:if test="${b.cvar3 != '.00'}"><fmt:formatNumber pattern="###,###,###" value="${b.cvar3}" type="number" /></c:if></td>
						</tr>
						<tr class="${color}">
							
						</tr>
						<c:choose>
							<c:when test="${color=='success'}">
								<c:set var="color" value="warning"/>
						    </c:when>    
						    <c:otherwise>
								<c:set var="color" value="success"/>
						    </c:otherwise>
						</c:choose>
					</c:forEach>
					<tr>
						<td colspan="20" align="center"></td>
					</tr>
					<!-- <tr>
						<td colspan="11" align="center"></td>
					</tr>
					 <tr>
						<td colspan="11" align="center">Usuario: <c:out
								value="${usuarioactuall}" /></td>
					</tr>
					 -->
				</tbody>
			</table>
			
			<!-- end row -->

			<!-- end row -->

		</section>
		<!-- end widget grid -->

	</div>
	<!-- END MAIN CONTENT -->

	<!--================================================== -->

	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script data-pace-options='{ "restartOnRequestAfter": true }'
		src="<c:url value="/resources/js/plugin/pace/pace.min.js"/>"></script>

	<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
	<script src="<c:url value="/resources/js/j/jquery.min.js"/>"></script>
	<script>
		if (!window.jQuery) {
			document
					.write('<script src="<c:url value="/resources/js/libs/jquery-2.0.2.min.js"/>""><\/script>');
		}
	</script>

	<!-- <script	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>  -->
	<script src="<c:url value="/resources/js/j/jquery-ui.min.js"/>"></script>
	<script>
		if (!window.jQuery.ui) {
			document
					.write('<script src="<c:url value="/resources/js/libs/jquery-ui-1.10.3.min.js"/>"><\/script>');
		}
	</script>

	<!-- IMPORTANT: APP CONFIG -->
	<script src="<c:url value="/resources/js/app.config.js"/>"></script>

	<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
	<script
		src="<c:url value="/resources/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"/>"></script>

	<!-- BOOTSTRAP JS -->
	<script src="<c:url value="/resources/js/bootstrap/bootstrap.min.js"/>"></script>

	<!-- CUSTOM NOTIFICATION -->
	<script
		src="<c:url value="/resources/js/notification/SmartNotification.min.js"/>"></script>

	<!-- JARVIS WIDGETS -->
	<script
		src="<c:url value="/resources/js/smartwidgets/jarvis.widget.min.js"/>"></script>

	<!-- EASY PIE CHARTS -->
	<script
		src="<c:url value="/resources/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"/>"></script>

	<!-- SPARKLINES -->
	<script
		src="<c:url value="/resources/js/plugin/sparkline/jquery.sparkline.min.js"/>"></script>

	<!-- JQUERY VALIDATE -->
	<script
		src="<c:url value="/resources/vjs/plugin/jquery-validate/jquery.validate.min.js"/>"></script>

	<!-- JQUERY MASKED INPUT -->
	<script
		src="<c:url value="/resources/js/plugin/masked-input/jquery.maskedinput.min.js"/>"></script>

	<!-- JQUERY SELECT2 INPUT -->
	<script
		src="<c:url value="/resources/js/plugin/select2/select2.min.js"/>"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script
		src="<c:url value="/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js"/>"></script>

	<!-- browser msie issue fix -->
	<script
		src="<c:url value="/resources/js/plugin/msie-fix/jquery.mb.browser.min.js"/>"></script>

	<!-- FastClick: For mobile devices -->
	<script
		src="<c:url value="/resources/js/plugin/fastclick/fastclick.min.js"/>"></script>

	<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

	<!-- Demo purpose only -->
	<script src="<c:url value="/resources/js/demo.min.js"/>"></script>

	<!-- MAIN APP JS FILE -->
	<script src="<c:url value="/resources/js/app.min.js"/>"></script>

	<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
	<!-- Voice command : plugin -->
	<script src="<c:url value="/resources/js/speech/voicecommand.min.js"/>"></script>

	<!-- PAGE RELATED PLUGIN(S) -->
	
	<script
		src="<c:url value="/resources/js/plugin/chartjs/chart.min.js"/>"></script>
		
	<script
		src="<c:url value="/resources/js/plugin/datatables/jquery.dataTables.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatables/dataTables.colVis.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatables/dataTables.tableTools.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatables/dataTables.bootstrap.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugin/datatable-responsive/datatables.responsive.min.js"/>"></script>

	<script type="text/javascript">
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		// Para el titulo del Drill Down
		var tit="Grand Bay";
		$(document)
				.ready(
						function() {
							
							pageSetUp();
						})

		$(function() {
			$("table").stickyTableHeaders();
		});
		/*! Copyright (c) 2011 by Jonas Mosbech - https://github.com/jmosbech/StickyTableHeaders
		    MIT license info: https://github.com/jmosbech/StickyTableHeaders/blob/master/license.txt */

		;
		(function($, window, undefined) {
			'use strict';

			var name = 'stickyTableHeaders';
			var defaults = {
					fixedOffset: 0,
		            leftOffset: 0,
		            marginTop: 0,
		            scrollableArea: window
			};

			function Plugin(el, options) {
				// To avoid scope issues, use 'base' instead of 'this'
				// to reference this class from internal events and functions.
				var base = this;

				// Access to jQuery and DOM versions of element
				base.$el = $(el);
				base.el = el;

				// Listen for destroyed, call teardown
				base.$el.bind('destroyed', $.proxy(base.teardown, base));

				// Cache DOM refs for performance reasons
				base.$window = $(window);
				base.$clonedHeader = null;
				base.$originalHeader = null;

				// Keep track of state
				base.isSticky = false;
				base.leftOffset = null;
				base.topOffset = null;

				base.init = function() {
					base.options = $.extend({}, defaults, options);

					base.$el
							.each(function() {
								var $this = $(this);

								// remove padding on <table> to fix issue #7
								$this.css('padding', 0);

								base.$originalHeader = $('thead:first', this);
								base.$clonedHeader = base.$originalHeader
										.clone();

								base.$clonedHeader
										.addClass('tableFloatingHeader');
								base.$clonedHeader.css('display', 'none');

								base.$originalHeader
										.addClass('tableFloatingHeaderOriginal');

								base.$originalHeader.after(base.$clonedHeader);

								base.$printStyle = $('<style type="text/css" media="print">'
										+ '.tableFloatingHeader{display:none !important;}'
										+ '.tableFloatingHeaderOriginal{position:static !important;}'
										+ '</style>');
								$('head').append(base.$printStyle);
							});

					base.updateWidth();
					base.toggleHeaders();

					base.bind();
				};

				base.destroy = function() {
					base.$el.unbind('destroyed', base.teardown);
					base.teardown();
				};

				base.teardown = function() {
					if (base.isSticky) {
						base.$originalHeader.css('position', 'static');
					}
					$.removeData(base.el, 'plugin_' + name);
					base.unbind();

					base.$clonedHeader.remove();
					base.$originalHeader
							.removeClass('tableFloatingHeaderOriginal');
					base.$originalHeader.css('visibility', 'visible');
					base.$printStyle.remove();

					base.el = null;
					base.$el = null;
				};

				base.bind = function() {
					base.$window.on('scroll.' + name, base.toggleHeaders);
					base.$window.on('resize.' + name, base.toggleHeaders);
					base.$window.on('resize.' + name, base.updateWidth);
				};

				base.unbind = function() {
					// unbind window events by specifying handle so we don't remove too much
					base.$window.off('.' + name, base.toggleHeaders);
					base.$window.off('.' + name, base.updateWidth);
					base.$el.off('.' + name);
					base.$el.find('*').off('.' + name);
				};

				base.toggleHeaders = function() {
					base.$el
							.each(function() {
								var $this = $(this);

								var newTopOffset = isNaN(base.options.fixedOffset) ? base.options.fixedOffset
										.height()
										: base.options.fixedOffset;

								var offset = $this.offset();
								var scrollTop = base.$window.scrollTop()
										+ newTopOffset;
								var scrollLeft = base.$window.scrollLeft();

								if ((scrollTop > offset.top)
										&& (scrollTop < offset.top
												+ $this.height()
												- base.$clonedHeader.height())) {
									var newLeft = offset.left - scrollLeft;
									if (base.isSticky
											&& (newLeft === base.leftOffset)
											&& (newTopOffset === base.topOffset)) {
										return;
									}

									base.$originalHeader.css({
										'position' : 'fixed',
										'top' : newTopOffset,
										'margin-top' : 0,
										'left' : newLeft,
										'z-index' : 1
									// #18: opacity bug
									});
									base.$clonedHeader.css('display', '');
									base.isSticky = true;
									base.leftOffset = newLeft;
									base.topOffset = newTopOffset;

									// make sure the width is correct: the user might have resized the browser while in static mode
									base.updateWidth();
								} else if (base.isSticky) {
									base.$originalHeader.css('position',
											'static');
									base.$clonedHeader.css('display', 'none');
									base.isSticky = false;
								}
							});
				};

				base.updateWidth = function() {
					if (!base.isSticky) {
						return;
					}
					// Copy cell widths from clone
					var $origHeaders = $('th,td', base.$originalHeader);
					$('th,td', base.$clonedHeader).each(function(index) {

						var width, $this = $(this);

						if ($this.css('box-sizing') === 'border-box') {
							width = $this.outerWidth(); // #39: border-box bug
						} else {
							width = $this.width();
						}

						$origHeaders.eq(index).css({
							'min-width' : width,
							'max-width' : width
						});
					});

					// Copy row width from whole table
					base.$originalHeader.css('width', base.$clonedHeader
							.width());
				};

				base.updateOptions = function(options) {
					base.options = $.extend({}, defaults, options);
					base.updateWidth();
					base.toggleHeaders();
				};

				// Run initializer
				base.init();
			}

			// A plugin wrapper around the constructor,
			// preventing against multiple instantiations
			$.fn[name] = function(options) {
				return this.each(function() {
					var instance = $.data(this, 'plugin_' + name);
					if (instance) {
						if (typeof options === "string") {
							instance[options].apply(instance);
						} else {
							instance.updateOptions(options);
						}
					} else if (options !== 'destroy') {
						$.data(this, 'plugin_' + name,
								new Plugin(this, options));
					}
				});
			};

		})(jQuery, window);
		
		
	</script>

	<!-- Your GOOGLE ANALYTICS CODE Below -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-XXXXXXXX-X' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>

</body>

</html>