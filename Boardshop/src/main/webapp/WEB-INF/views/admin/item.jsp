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
				<li class="active"><a href="/admin/item">Item</a></li>
				<li><a href="/admin/category">Category</a></li>
				<li><a href="/admin/commodity">Commodity</a></li>
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

<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/admin/item" method="get" class="form-inline">
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />
				<custom:hiddenInputs excludeParams="search"/>
				<br><br>
				<button type="submit" class="btn btn-primary">Search</button>
				<a href  = "/admin/item/cancel" class="btn btn-primary" >Cancel</a>
			</div>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<form:form class="form-horizontal" action="/admin/item" method="POST"
			modelAttribute="item">
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
		<h3>Item</h3>
	</div>
	<div class="col-md-3 col-xs-3">
		<h3>Options</h3>
	</div>
</div>

<c:forEach items="${page.content}" var="item">
	<div class="row">
		<div class="col-md-3 col-xs-3">${item.name}</div>
		<div class="col-md-3 col-xs-3">
			<a class="btn btn-warning" href="/admin/item/update/${item.id}">update</a>
			<a class="btn btn-danger" href="/admin/item/delete/${item.id}">delete</a>
		</div>
	</div>
</c:forEach>

<div id="CategAdminPage" class="col-md-6"></div>
<div class="col-md-2 col-xs-12"></div>

<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>



