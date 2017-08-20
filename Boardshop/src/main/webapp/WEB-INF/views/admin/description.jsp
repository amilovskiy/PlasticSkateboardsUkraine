<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="/resources/css/mainStyle.css" rel="stylesheet"/>

<nav class="navbar navbar-inverse" role="navigation">
	<div class="collapse navbar-collapse" id="myNavbar">
		<div class="container">
			<ul class="nav navbar-nav">
				<li><a href="/admin/item">Item</a></li>
				<li><a href="/admin/category">Category</a></li>
				<li class="active"><a href="/admin/commodity">Commodity</a></li>
				<li><a href="/admin/producer">Producer</a></li>
				<li><a href="/admin/color">Color</a></li>
				<li><a href="/admin/wheel">Wheel</a></li>
				<li><a href="/admin/truck">Truck</a></li>
				<li><a href="/admin/deck">Deck</a></li>
			</ul>
		</div>
	</div>
</nav>

<div id="marTop" class="col-md-12"></div>

<div id="indexContent" class="col-md-12">
	<div class="container">
		<div class="col-md-5">
			<h3><b>Image :</b></h3>
			<div class="row">
				<div class="col-md-4">
					<img class="img-rounded" width="300%" src="/images/commodity/${commodity.id}
						.jpg?version=${commodity.version}"> 
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<h3><b>Name :</b></h3>
			<div class="row">
				<div class="col-md-4">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.name}" escapeXml="false"/></b></h4>
				</div>
			</div>
			<h3><b>Price :</b></h3>
			<div class="row">
				<div class="col-md-3">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.price}" escapeXml="false"/> $</b></h4>
				</div>
			</div>
			<h3><b>Item :</b></h3>
			<div class="row">
				<div class="col-md-3">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.category.item.name}" escapeXml="false"/></b></h4>
				</div>
			</div>
			<h3><b>Category :</b></h3>
			<div class="row">
				<div class="col-md-3">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.category.name}" escapeXml="false"/></b></h4>
				</div>
			</div>
			<h3><b>Color :</b></h3>
			<div class="row">
				<div class="col-md-3">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.color.name}" escapeXml="false"/></b></h4>
				</div>
			</div>
			<h3><b>Deck :</b></h3>
			<div class="row">
				<div class="col-md-3">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.deck.name}" escapeXml="false"/></b></h4>
				</div>
			</div>
			<h3><b>Truck :</b></h3>
			<div class="row">
				<div class="col-md-3">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.truck.name}" escapeXml="false"/></b></h4>
				</div>
			</div>
			<h3><b>Wheel :</b></h3>
			<div class="row">
				<div class="col-md-3">
					<h4 style="color: #BDBDBD"><b><c:out value="${commodity.wheel.name}" escapeXml="false"/></b></h4>
				</div>
			</div>
			<h3><b>Description :</b></h3>
			<div class="row">
				<h5 style="color: #BDBDBD"><b><c:out value="${commodity.description}" escapeXml="false"/></b></h5>	
			</div>
			<h3><b>Producer :</b></h3>
			<div class="row">
				<div class="col-md-4">
					<img class="img-rounded" width="100%" src="/images/producer/${commodity.producer.id}
						.jpg?version=${commodity.producer.version}">
				</div>
			</div>
		</div>
		
	</div> 
	
</div>

<div id="productListHeight" class="col-md-6"></div>

<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>













