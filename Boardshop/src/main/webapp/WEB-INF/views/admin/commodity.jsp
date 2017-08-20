<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
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
	<div class="row">
  		<div class="col-md-3 col-xs-12">
			<form:form modelAttribute="filter" action="/admin/commodity" method="get" class="form-inline" >
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Sort by name" paramValue="name" />
								<custom:sort innerHtml="Sort by price" paramValue="price" />
							</ul>
						</div><br>
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
						<h3><label for="search" class="control-label">Search :</label></h3>
						<div class="form-group">
							<form:input path="search" style="width: 150px;" class="form-control" placeholder="name"/>
						</div><br>
						<h3><label for="deckIds" class="control-label">Deck :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${decks}" path="deckIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="colorIds" class="control-label">Color :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${colors}" path="colorIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="truckIds" class="control-label">Truck :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${trucks}" path="truckIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="wheelIds" class="control-label">Wheels :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${wheels}" path="wheelIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="producerIds" class="control-label">Producer :</label></h3>
						<div class="form-group">
							<form:checkboxes style="display: block;" items="${producers}" path="producerIds" itemLabel="name" itemValue="id"/>
						</div><br>
						<h3><label for="min" class="control-label">Price :</label></h3>
						<div class="form-group">
							<form:input path="min" style="width: 60px;" class="form-control" placeholder="min"/>
							<form:input path="max" style="width: 60px;" class="form-control" placeholder="max"/>
						</div><br>
						<div class="form-group"><br>
							<button type="submit" class="btn btn-success">Search</button>
							<a href  = "/admin/commodity/cancel" class="btn btn-info" >Cancel</a>
						</div>
			</form:form>

		</div>
  		<div class="col-md-7 col-xs-12">
			<form:form class="form-horizontal" action="/admin/commodity" method="POST" 
				modelAttribute="commodity" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name" style="color: #A02525; text-align: left;" 
						class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name" /></label>
				</div> 
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">Name</label>
					<div class="col-sm-5">
						<form:input class="form-control" path="name" id="name" />
					</div>
				</div>
				<div class="form-group">
					<label for="price" style="color: #A02525; text-align: left;" 
						class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="price" /></label>
				</div> 
				<div class="form-group">
					<label for="price" class="col-sm-2 control-label">Price</label>
					<div class="col-sm-5">
						<form:input class="form-control" path="price" id="price" />
					</div>
				</div>
				<div class="form-group">
					<label for="producer" style="color: #A02525; text-align: left;" 
						class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="producer" /></label>
				</div> 
				<div class="form-group">
					<label for="producer" class="col-sm-2 control-label">Producer</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="producer" id="producer" 
							items="${producers}" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
					<label for="producer" class="col-sm-2 control-label">Category</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="category" id="category" 
							items="${categories}" itemLabel="name" itemValue="id"/>
					</div>
				</div> 
				<div class="form-group">
					<label for="color" class="col-sm-2 control-label">Color</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="color" id="color" 
							items="${colors}" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
					<label for="deck" class="col-sm-2 control-label">Deck</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="deck" id="deck" 
							items="${decks}" itemLabel="name" itemValue="id"/>
					</div>
				</div> 
				<div class="form-group">
					<label for="color" class="col-sm-2 control-label">Truck</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="truck" id="truck" 
							items="${trucks}" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
					<label for="color" class="col-sm-2 control-label">Wheel</label>
					<div class="col-sm-5">
						<form:select class="form-control" path="wheel" id="wheel" 
							items="${wheels}" itemLabel="name" itemValue="id"/>
					</div>
				</div> 
				<div class="form-group">
					<label for="description" style="color: #A02525; text-align: left;" 
						class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="description" /></label>
				</div> 
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">Description</label>
					<div class="col-sm-5">
						<form:textarea path="description" rows="5" cols="33" />
					</div>
				</div>
				<div class="form-group">
					<label for="file" class="col-sm-2 control-label">Image</label>
					<div class="col-sm-5">
						<label class="btn btn-default btn-file">
		        			 <input type="file" id="file" name="file">
						</label>
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
		<div class="col-md-1 col-xs-1">
			<h3>Img</h3>
		</div>
		<div class="col-md-2 col-xs-2">
			<h3>Name</h3>
		</div>
		<div class="col-md-2 col-xs-2">
			<h3>Price</h3>
		</div>
		<div class="col-md-2 col-xs-2">
			<h3>Producer</h3>
		</div>
		<div class="col-md-2 col-xs-2">
			<h3>Category</h3>
		</div>
		<div class="col-md-3 col-xs-3">
			<h3>Options</h3>
		</div>
	</div>
 
	<c:forEach items="${page.content}" var="commodity">
		<div class="row">
			<div class="col-md-1 col-xs-1"><img class="img-rounded" width="100%" src="/images/commodity/${commodity.id}
				.jpg?version=${commodity.version}"></div> 
			<div class="col-md-2 col-xs-2">${commodity.name}</div>
			<div class="col-md-2 col-xs-2">${commodity.price} <b>$</b></div>
			<div class="col-md-2 col-xs-2">${commodity.producer.name}</div>
			<div class="col-md-2 col-xs-2">${commodity.category.name}</div> 
			<div class="col-md-3 col-xs-3">
				<a class="btn btn-success" href="/admin/commodity/description/${commodity.id}">description</a>
				<a class="btn btn-warning" href="/admin/commodity/update/${commodity.id}">update</a> 
				<a class="btn btn-danger" href="/admin/commodity/delete/${commodity.id}">delete</a>
			</div>
		</div>
	</c:forEach> 
</div>

<div id="marTop" class="col-md-12"></div>

<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>