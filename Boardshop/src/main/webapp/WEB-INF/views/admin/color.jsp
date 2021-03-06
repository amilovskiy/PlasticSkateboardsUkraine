<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link href="/resources/css/mainStyle.css" rel="stylesheet"/>

<nav class="navbar navbar-inverse" role="navigation">
	<div class="collapse navbar-collapse" id="myNavbar">
		<div class="container">
			<ul class="nav navbar-nav">
				<li><a href="/admin/item">Item</a></li>
				<li><a href="/admin/category">Category</a></li>
				<li><a href="/admin/commodity">Commodity</a></li>
				<li><a href="/admin/producer">Producer</a></li>
				<li class="active"><a href="/admin/color">Color</a></li>
				<li><a href="/admin/wheel">Wheel</a></li>
				<li><a href="/admin/truck">Truck</a></li>
				<li><a href="/admin/deck">Deck</a></li>
			</ul>
		</div>
	</div>
</nav>

<div id="marTop" class="col-md-12"></div>

<div id="indexContent" class="col-md-12">
<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/admin/color" method="get" class="form-inline">
			<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			<h3><label for="search" class="control-label">Search :</label></h3>
			<div class="form-group">
				<form:input path="search" style="width: 150px;" class="form-control" placeholder="name"/>
			</div><br>
			<div class="form-group"><br>
				<button type="submit" class="btn btn-success">Search</button>
				<a href  = "/admin/color/cancel" class="btn btn-info" >Cancel</a>
			</div>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<form:form class="form-horizontal" action="/admin/color" method="POST"
			modelAttribute="color">
 			<div class="form-group">
				<label for="name" style="color:#A02525;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-5">
					<form:input class="form-control" path="name" id="name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Create</button>
				</div>
			</div>
		</form:form>
	</div>
</div>

<div class="col-md-2 col-xs-12"></div>

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>

<div class="row">
	<div class="col-md-3 col-xs-3">
		<h3>Color</h3>
	</div>
	<div class="col-md-3 col-xs-3">
		<h3>Options</h3>
	</div>
</div>

<c:forEach items="${page.content}" var="color">
	<div class="row">
		<div class="col-md-3 col-xs-3">${color.name}</div>
		<div class="col-md-3 col-xs-3">
			<a class="btn btn-warning" href="/admin/color/update/${color.id}">update</a>
			<a class="btn btn-danger" href="/admin/color/delete/${color.id}">delete</a>
		</div>
	</div>
</c:forEach>

<div id="CategAdminPage" class="col-md-6"></div>
<div class="col-md-2 col-xs-12"></div>
</div>

<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>