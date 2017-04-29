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
			</ul>
		</div>
	</div>
</nav>

<div id="marTop" class="col-md-12"></div>

<div id="indexContent" class="col-md-12">
	<b>Image</b>
	<div class="row">
		<div class="col-md-6">
			<div class="col-md-5 col-xs-5"><img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}
				.jpg?version=${commodity.version}"></div> 
		</div>
	</div> 
	<b>Name</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.name}" escapeXml="false"/>
		</div>
	</div>
	<b>Price</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.price}" escapeXml="false"/>
		</div>
	</div>
	<b>Description</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.description}" escapeXml="false"/>
		</div>
	</div>
	<b>Producer</b>
	<div class="row">
		<div class="col-md-5">
			<div class="col-md-3 col-xs-3"><img class="img-rounded" width="100%" src="/images/producer/${commodity.producer.id}
				.jpg?version=${commodity.producer.version}"></div>
		</div>
	</div>
	<b>Category</b>
	<div class="row">
		<div class="col-md-5">
			<c:out value="${commodity.category.name}" escapeXml="false"/>
		</div>
	</div>
	
	<div id="productListHeight" class="col-md-6"></div>	
</div>

<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>













